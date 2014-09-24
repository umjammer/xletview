/*
 * 
 */
package net.beiker.xletview.net;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

import net.beiker.cake.Log;
import net.beiker.cake.Logger;

/**
 * 
 * @author Martin Sveden 
 */
public class OutputServerThread extends Thread{
	/** Debugging facility. */
	private final static Logger logger = Log.getLogger(OutputServerThread.class);
	
	// The Server that spawned us
	private OutputServer server;
	
	// The Socket connected to our client
	private Socket socket;
	
	// Constructor.
	public OutputServerThread( OutputServer server, Socket socket ) {
		
		// Save the parameters
		this.server = server;
		this.socket = socket;
		
		// Start up the thread
		start();
	}
	
	// This runs in a separate thread when start() is called in the
	// constructor.
	public void run() {
		
		try {
			
			// Create a DataInputStream for communication; the client
			// is using a DataOutputStream to write to us
			DataInputStream din = new DataInputStream( this.socket.getInputStream() );
			
			// Over and over, forever ...
			while (true) {
				
				// ... read the next message ...
				String message = din.readUTF();
				
				// ... tell the world ...
				logger.debug( "Sending "+message );
				
				// ... and have the server send it to all clients
				this.server.sendToAll( message );
			}
		} catch( EOFException ie ) {
			
			// This doesn't need an error message
		} catch( IOException ie ) {
			
			// This does; tell the world!
			ie.printStackTrace();
		} finally {
			
			// The connection is closed for one reason or another,
			// so have the server dealing with it
			this.server.removeConnection( this.socket );
		}
	}
}
