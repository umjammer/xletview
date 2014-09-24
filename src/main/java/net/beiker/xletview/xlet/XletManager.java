/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sveden
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.xlet;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.Vector;
import net.beiker.xletview.Startup;

import net.beiker.cake.Log;
import net.beiker.cake.Logger;
import net.beiker.xletview.classloader.XletClassLoader;
import net.beiker.xletview.download.DownloadEvent;
import net.beiker.xletview.download.DownloadEventListener;
import net.beiker.xletview.download.Downloader;
import net.beiker.xletview.media.BackgroundLayer;
import net.beiker.xletview.media.ScreenContainer;
import net.beiker.xletview.util.Constants;
import net.beiker.xletview.util.MemoryPrinter;
import net.beiker.xletview.util.Settings;
import net.beiker.xletview.util.Util;

import org.havi.ui.HScene;

import xjava.io.EmulatorFile;
import xjavax.tv.graphics.TVContainer;
import xjavax.tv.util.TVTimerImpl;
import xjavax.tv.xlet.Xlet;
import xjavax.tv.xlet.XletStateChangeException;

public class XletManager implements Runnable, DownloadEventListener{

	/** Debugging facility. */
	private static final Logger logger = Log.getLogger(XletManager.class);
	
    
	private static XletManager THE_INSTANCE;
    private Vector xletContexts;
    private XletContextImpl activeContext;
    private static ThreadGroup threadGroup;
    private HScene scene;
    
    private Class xletClass;
    private URL xletHome;
    private final Vector xletExtraPaths = new Vector(); // Vector<URL>
    private String xletClassName;

    private ThreadGroup xletThreadGroup;
    private Thread xletThread;
    private Thread downloadThread;

    private static int appCount;    
    
    public static XletManager getInstance() {
        if (THE_INSTANCE == null) {
            THE_INSTANCE = new XletManager();
        }
        return THE_INSTANCE;
    }

    private XletManager() {
        this.xletContexts = new Vector();
        this.xletThreadGroup = getThreadGroup();//new ThreadGroup(Thread.currentThread().getThreadGroup(), "xletThreadGroup");
    
        String extra = Settings.getProperty("extra.classpath");
        if (extra != null){
        	// TODO: test
        	logger.debug("Adding extra class paths from extra.classpath property.");
        	StringTokenizer st = new StringTokenizer(extra, File.pathSeparator, false);
        	int numTokens = st.countTokens();
        	for (int i=0; i<numTokens; i++){
        		String token = st.nextToken();
        		logger.debug("Adding '"+token+"' class path.");
        		URL path = Startup.pathString2URL(token);
        		this.xletExtraPaths.add(path);
        	}
        }
        
    }

    /**
     * 
     *@deprecated
     */
    public void setXlet(String xletHome, String xletClassName){
    	URL url = null;
    	try {
			url = new URL("file:"+xletHome);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setXlet(url, xletClassName);
    }
    
    public void setXlet(URL xletHome, URL[] xletExPaths, String xletClassName){
    	logger.debug("Adding Xlet's extra paths...");
    	for (int i=0; i<xletExPaths.length; i++){
    		logger.debug(xletExPaths[i]);
    		this.xletExtraPaths.add(xletExPaths[i]);
    	}
    	logger.debug("Done adding Xlet's extra paths.");
    	
    	// Also runs the Xlet, so do this last.
    	setXlet(xletHome, xletClassName);
    }
    
    public void setXlet(URL xletHome, String xletClassName) {
        
    	/* Leave that commented out.
    	 * This will result in a problem when a class should be loaded as a
    	 * resource (because of jassist performing bytecode manipulation) when
    	 * the URL is a jar URL such as
    	 *  jar:file:foo.jar!/bin/
    	 * We don't want
    	 *  jar:file:foo.jar!/bin/\
    	 * under Win32, even 
    	 *  jar:file:foo.jar!/bin\
    	 * would not work, the user could not even remove the trailing slash
    	 * and make it work!
    	 * [Enver Haase <enver.haase@gmx.de> 07-Jan-2004]
    	 */
    	/*
    	if (!xletHome.toExternalForm().endsWith(File.separator))
			try {
				xletHome = new URL(xletHome.toExternalForm()+File.separator);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		*/	
			
    	this.xletHome = xletHome;
        this.xletClassName = xletClassName;
        
        /*
         * The downloader that is/was experimental,
         * might be used in the future to
         * download the app to the "box"
         *  
         * downloadThread = new Thread(this);
         * downloadThread.start();
         */
        
        /*
         * If the downloader is not used this
         * goes here
         */
        runXlet();
    }

    private void runXlet() {
       

        destroyActiveXlet();

        // create the new xlet
        ClassLoader xletLoader = null;

        URL[] xletURLs = new URL[1+this.xletExtraPaths.size()];
		xletURLs[0] = this.xletHome; // Should be used FIRST
		for (int i=0; i<this.xletExtraPaths.size(); i++){
			xletURLs[i+1] = (URL) this.xletExtraPaths.elementAt(i);
		}
		
		try{        	
            xletLoader = new XletClassLoader(xletURLs);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        logger.info("loading Xlet... [" + this.xletClassName + "]");
        try {

            logger.debug(this.xletClassName);
            //xletClass = Class.forName(xletClassName, true, loader);
            this.xletClass = xletLoader.loadClass(this.xletClassName);
            this.xletThread = new Thread(this.xletThreadGroup, this, "xletThread-" + this.xletContexts.size());
            this.xletThread.start();
            logger.info("XLET started... [" + this.xletClassName + "]");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            cleanup();
            logger.info("Application not loaded!");
        }
        catch (Exception e) {
            e.printStackTrace();
            cleanup();
        }


    }

    public void reloadActiveXlet() {
        if (this.activeContext != null) {
        	logger.info("reloading xlet " + this.xletHome + ", " + this.xletClassName);
            setXlet(this.xletHome, this.xletClassName);
        }
    }

    public void addScene(HScene scene) {
        this.scene = scene;
        ScreenContainer.getInstance().addToXletContainer(scene);
        //ScreenContainer.getInstance().getXletContainer().requestFocus();
        
    }

    public HScene getScene() {
        return this.scene;
    }

    public void run() {
        if(this.downloadThread != null){
            try {
                Downloader dwnLoader = new Downloader(Constants.PATH_APPDIR);
                dwnLoader.addDownloadEventListener(this);
                dwnLoader.download(this.xletHome);
            }
            catch (IOException e1) {
                e1.printStackTrace();
                return;
            }
        }
        else if(this.xletThread != null){
            initXlet();
            if (this.activeContext != null) {
    
                resumeRequest(this.activeContext);
                /* keep the thread alive until destroy */
                synchronized (this) {
                    try {
                        wait();
                    }
                    catch (Exception ex) {
                        logger.error("error: " + ex);
                    }
                }
            }
            logger.debug("xxxxx" + this.xletThread.getName() + " just died xxxxx");
            this.xletThread = null;
        }
    }

    public void destroyActiveXlet() {
        // only if an Xlet is running
        if (this.activeContext != null) {
        	logger.debug("CURRENT THREAD IS " + Thread.currentThread().getName());

        	logger.debug("###############" + Thread.activeCount() + " threads active ###############");
            synchronized (this) {
                try {
                    notifyAll();
                }
                catch (Exception ex) {
                    logger.error("error: " + ex);
                }
            }
            destroyXlet(this.activeContext);

            // check if sub threads are alive and if so try to kill them
            Thread[] threads = new Thread[Thread.activeCount()];
            int threadCount = Thread.enumerate(threads);
            for (int i = 0; i < threadCount; i++) {
                ThreadGroup group = threads[i].getThreadGroup();
                logger.debug("subthread=" + threads[i].getName() + " in group=" + threads[i].getThreadGroup());
                //threads[i].stop();
                if (group == this.xletThreadGroup && threads[i] != this.xletThread) {
                    //logger.debug("subthread=" + threads[k].getName() +  " in group=" + threads[k].getThreadGroup());
                    //threads[k].interrupt();
                	logger.debug(threads[i] + " is still alive, trying to stop it... ");
                    threads[i] = null;
                    //threads[i].stop(); unsafe
                }
            }
            this.activeContext = null;
            logger.debug("###############" + Thread.activeCount() + " threads active ###############");
        
            /*
             * Remove all UserEvent listeners, just to not 
             * have any references to this destroyed Xlet
             */
            org.dvb.event.EventManager.getInstance().removeAllUserEventListeners();
            
            /*
             * Remove all from the TVTimer queue
             */
            TVTimerImpl.getInstance().descheduleAll(this);
        }
        MemoryPrinter.print();
        logger.debug("running gc...");
        System.gc();
        logger.debug("after gc...");
        MemoryPrinter.print();
    }

    private void initXlet() {
        Object newObj = null;

        // mount before new instance of the xlet
//        CarouselMountPoint mountPoint = new CarouselMountPoint("apploc" + (appCount++));
//        xjava.io.FileSystem.mountCarousel(mountPoint);
//        mountPoint.mount(new File(xletHome));
        EmulatorFile mountPoint = xjava.io.FileSystem.mountCarousel("apploc" + (appCount++), new File(this.xletHome.getFile()));
        
        
        
        try {
            newObj = this.xletClass.newInstance();
            Xlet xlet = null;
            try {
                xlet = (Xlet) newObj;    
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            
            
            XletContextImpl xci = new XletContextImpl(this, xlet, mountPoint);
            this.xletContexts.add(xci);
            xlet.initXlet(xci);
            this.activeContext = xci;
            xci.setState(XletContextImpl.INITIALIZED);
        }
        catch (Exception e) {
        	e.printStackTrace();
            cleanup();
        }
        catch (NoClassDefFoundError e) {
        	e.printStackTrace();
            cleanup();
            logger.info("Application not loaded!");
        }
        catch (Error e) {
        	e.printStackTrace();
            cleanup();
        }

    }

    private void destroyXlet(XletContextImpl context) {
        //logger.debug("¤####¤¤" + Thread.currentThread().getName());

        if (this.activeContext != null) {
        	logger.debug("About to destroy Xlet [" + context.getXlet().toString() + "]");
            TVContainer.getRootContainer(context).removeAll();
            Xlet xlet = this.activeContext.getXlet();
            try {
                xlet.destroyXlet(true);
            }
            catch (XletStateChangeException e) {
                //                logger.debug("###############\n###############\n###############\n###############\n");
                cleanup();
                /* XletStateChangeException - is thrown if the Xlet wishes to continue to execute 
                 * (Not enter the Destroyed  state). This exception is ignored if unconditional is equal to true.
                 * So, we ignore it.
                 * */
            }
            catch (NoClassDefFoundError e) {
                e.printStackTrace();
                cleanup();
            }
            catch (Exception e) {
                e.printStackTrace();
                cleanup();
            }
            BackgroundLayer.getInstance().removeAll();
            ScreenContainer.getInstance().repaint();
            //logger.debug("compcount=" + BackgroundLayer.getInstance().getComponentCount());
            TVContainer.getRootContainer(context).repaint();
            logger.info("Xlet destroyed");
        }

        //        Thread[] threads = new Thread[Thread.activeCount()];
        //        int threadCount = Thread.enumerate(threads);
        //        for(int i = 0; i < threadCount; i++){            
        //            logger.debug("thread=" + threads[i].getThreadGroup().getName());
        ////            ThreadGroup tGroup = threads[i].getThreadGroup();
        ////            if(tGroup != null){
        ////                logger.debug("this group=" + Thread.currentThread().getThreadGroup() + ", thread's group" + threads[i].getThreadGroup());
        ////            }
        //        }
        //        
        //        xletThreadGroup.list();
        //        
        //        
        //      Thread[] threads = new Thread[xletThreadGroup.activeCount()];
        //      int threadCount = Thread.enumerate(threads);
        //      logger.debug("threadCount=" + threadCount);
        //      for(int i = 0; i < threadCount; i++){            
        //          logger.debug("thread=" + threads[i].getName());
        //      }        
        //

        logger.debug("Threads running=" + Thread.activeCount());
    }

    void notifyDestroyed(XletContextImpl xc) {
        // remove the reference to the context
        this.xletContexts.remove(xc);

        // if the context was the active one, set it to null 
        if (this.activeContext == xc) {
            this.activeContext = null;
        }
        MemoryPrinter.print();
        logger.debug("running gc...");
        System.gc();
        logger.debug("after gc...");
        MemoryPrinter.print();
    }

    void notifyPaused(XletContextImpl xc) {
        if (xc == this.activeContext) {
            this.activeContext = null;
        }
    }

    void resumeRequest(XletContextImpl xc) {
        if (this.activeContext.getState() == XletContextImpl.INITIALIZED || this.activeContext.getState() == XletContextImpl.PAUSED) {
            if (xc != this.activeContext) {
                this.activeContext.getXlet().pauseXlet();
                this.activeContext.setState(XletContextImpl.PAUSED);
                this.activeContext = null;
            }
            this.activeContext = xc;
            try {
            	
            	/*
            	 * request focus on the ScreenContainer, because
            	 * if a component in the previous loaded Xlet
            	 * had the focus no component has the focus right
            	 * now and the event mechanism doesn't work
            	 */  
            	ScreenContainer.getInstance().requestFocus();
                
            	this.activeContext.getXlet().startXlet();
                this.activeContext.setState(XletContextImpl.ACTIVE);
                
            }
            catch (XletStateChangeException e) {
                e.printStackTrace();
                cleanup();
            }
        }
        else if (xc.getState() == XletContextImpl.ACTIVE) {
        	logger.debug("Xlet was already active");
        }
    }

    private void cleanup() {
    	logger.debug("Something went wrong, cleaning up errors...");
        ScreenContainer.getInstance().getXletContainer().removeAll();
        ScreenContainer.getInstance().getXletContainer().repaint();
        this.xletContexts.removeAllElements();
        this.scene = null;
        this.activeContext = null;
        this.xletClass = null;
    }

    public ThreadGroup getThreadGroup() {
        if (threadGroup == null) {
            threadGroup = new ThreadGroup("xlet thread group") {
                public void uncaughtException(Thread t, Throwable e) {
                    if (!(e instanceof ThreadDeath)) {                       
                        logger.error(Util.getStackTrace(e)+"\n>>>>> error <<<<<");
                        cleanup();
                    }
                }
            };
        }
        return threadGroup;
    }

    public void downloadUpdate(DownloadEvent e) {
        //logger.debug(e.getProcent() + "%" + ", file=" + e.getFileName() );  
        
        //logger.info(e.getFileName() + ", " + e.getProcent() + "% finished");
        ScreenContainer.showProgressBar();
        ScreenContainer.updateProgressBar(e.getProcent());
        if(e.getProcent() == 100){
            e.getDownloader().removeDownloadEventListener(this);
            
            // make sure the downloadThread is null so it's not downloaded twice
            this.downloadThread = null;            
            runXlet();
            ScreenContainer.hideProgressBar();
        }      
    }
}
