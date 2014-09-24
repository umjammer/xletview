/*
 * 
 * This file is part of XleTView Copyright (C) 2003 Martin Sveden
 * 
 * This is free software, and you are welcome to redistribute it under certain
 * conditions;
 * 
 * See LICENSE document for details.
 *  
 */

package xjavax.tv.util;

import java.util.Vector;

import net.beiker.xletview.util.ArraySorter;
import net.beiker.xletview.util.Comparer;


/**
 * Implementation of TVTimer
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class TVTimerImpl extends TVTimer {

	private static TVTimerImpl THE_INSTANCE;

	// the queue
	private Q theQ;

	private TVTimerImpl() {

		theQ = new Q();

		// start the "perpetual" TimerThread
		new TimerThread(this, theQ);

	}

	public static TVTimerImpl getInstance() {
		if (THE_INSTANCE == null) {
			THE_INSTANCE = new TVTimerImpl();
		}
		return THE_INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see xjavax.tv.util.TVTimer#scheduleTimerSpec(xjavax.tv.util.TVTimerSpec)
	 */
	public TVTimerSpec scheduleTimerSpec(TVTimerSpec spec) throws TVTimerScheduleFailedException {
		theQ.addSpec(spec);
		return spec;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see xjavax.tv.util.TVTimer#deschedule(xjavax.tv.util.TVTimerSpec)
	 */
	public void deschedule(TVTimerSpec spec) {
		theQ.deSchedule(spec);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see xjavax.tv.util.TVTimer#getMinRepeatInterval()
	 */
	public long getMinRepeatInterval() {
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see xjavax.tv.util.TVTimer#getGranularity()
	 */
	public long getGranularity() {
		return -1;
	}

	public void descheduleAll(net.beiker.xletview.xlet.XletManager manager) {
		theQ.removeAll();
	}

	/**
	 * Manages a queue of Times
	 * 
	 * @author Martin Sveden
	 */
	private class Q implements Comparer {

		/*
		 * Each TimeKeeper holds a TVTimerSpec
		 */
		private TimeKeeper[] timeKeepers = new TimeKeeper[0];

		/**
		 * Adds a new TVTimerSpec to the queue
		 * 
		 * @param spec
		 *  
		 */
		synchronized void addSpec(TVTimerSpec spec) {
			TimeKeeper[] newArr = new TimeKeeper[timeKeepers.length + 1];
			System.arraycopy(timeKeepers, 0, newArr, 0, timeKeepers.length);
			newArr[newArr.length - 1] = new TimeKeeper(spec);
			timeKeepers = newArr;
			ArraySorter.sort(timeKeepers, this);

			synchronized (this) {
				notifyAll();
			}
		}

		boolean isEmpty() {
			return (timeKeepers.length == 0) ? true : false;
		}

		/**
		 * Removes the first TVTimeSpec in the queue
		 */
		void removeFirst() {
			/*
			 * we have to check if it's empty because someone could have
			 * descheduled all
			 */
			if (!isEmpty()) {
				TimeKeeper[] newArr = new TimeKeeper[timeKeepers.length - 1];
				System.arraycopy(timeKeepers, 1, newArr, 0, timeKeepers.length - 1);
				timeKeepers = newArr;
			}

		}

		/**
		 * @return The next to go off
		 */
		synchronized TimeKeeper getNext() {
			TimeKeeper result = null;
			if (!isEmpty()) {
				result = timeKeepers[0];
			}
			return result;
		}

		void deSchedule(TVTimerSpec spec) {
			// then remove it from the queue
			removeAll(spec);
		}

		/**
		 * Removes a time from the queue
		 * 
		 * @param l
		 *            An absolute time
		 */
		synchronized void removeAll(TVTimerSpec spec) {
			Vector v = new Vector();
			for (int i = 0; i < timeKeepers.length; i++) {
				if (timeKeepers[i].getSpec() != spec) {
					v.add(timeKeepers[i]);
				} else {
					timeKeepers[i].setScheduled(false);
				}
			}
			TimeKeeper[] newArr = new TimeKeeper[v.size()];
			v.copyInto(newArr);
			timeKeepers = newArr;
		}

		synchronized void removeAll() {
			timeKeepers = new TimeKeeper[0];
		}

		public int compare(Object oa, Object ob) {
			long a = ((TimeKeeper) oa).getTimerTime();
			long b = ((TimeKeeper) ob).getTimerTime();
			if (a > b)
				return 1;
			if (a == b)
				return 0;
			if (a < b)
				return -1;
			return 0;
		}
	}

	/**
	 * A perpetual Thread that fires scheduled Time objects
	 * 
	 * @author Martin Sveden
	 */
	private class TimerThread extends Thread {

		private TVTimer tvTimer;
		private Q q;

		TimerThread(TVTimer tvTimer, Q q) {
			super("TimerThread");
			this.tvTimer = tvTimer;
			this.q = q;
			start();
		}

		public void run() {
			//System.out.println("TimerThread run");
			try {
				while (true) {
					synchronized (q) {
						if (q.isEmpty()) {
							// wait for a spec to be scheduled
							q.wait();
						}
						while (true) {
							TimeKeeper nextTime = q.getNext();

							if (nextTime != null) {

								// the time to wait until the next spec goes
								// off
								long timeToGoOff = nextTime.getTimerTime() - System.currentTimeMillis();

								if (nextTime.isScheduled() == false) {
									// the spec is not scheduled anymore
									q.removeFirst();
								} else if (timeToGoOff <= 0) {
									/*
									 * All the events goes off here
									 */

									// go off!
									nextTime.getSpec().notifyListeners(tvTimer);

									// remove it from the queue
									q.removeFirst();

									/*
									 * After the event went off, check what to
									 * to with that spec
									 */
									if (nextTime.getSpec().isRepeat() && !nextTime.getSpec().isAbsolute() && nextTime.isScheduled()) {
										// reschedule the spec
										nextTime.reschedule();
										q.addSpec(nextTime.getSpec());
									}

								} else {
									/*
									 * Always waiting here as long as there is
									 * a next scheduled time
									 */
									q.wait(timeToGoOff);
								}
							} else {
								/*
								 * Next time was null i.e no time in queue,
								 * break the loop and wait for a spec to be
								 * scheduled
								 */
								break;
							}
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		TVTimerImpl timer = new TVTimerImpl();

	}

}
