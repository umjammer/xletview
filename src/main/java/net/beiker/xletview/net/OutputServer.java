
package net.beiker.xletview.net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import net.beiker.xletview.io.OutputPrinter;

/**
 *
 * @author Unknown
 */
public class OutputServer implements OutputPrinter{

    /** Debugging facility. */
    private final static Logger logger = Logger.getLogger(OutputServer.class.getName());

    private PrintStream original;

    // a ServerSocket for accepting new connections
    private ServerSocket ss;

    // for mapping sockets to DataOutputStreams
    private Map<Socket, DataOutputStream> outputStreams = new HashMap<>();

    // Constructor and while-accept loop all in one.
    public OutputServer(int port, PrintStream original) throws IOException {
        this. original = original;
        // All we have to do is listen
        listen(port);
    }

    private void listen(int port) throws IOException {

        this.ss = new ServerSocket(port);
        logger.fine("Listening on " + this.ss);

        // accepting forever
        while (true) {

            // accept incoming
            Socket s = this.ss.accept();
            logger.fine("Connection from " + s);

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // Save stream
            this.outputStreams.put(s, dout);

            // a new thread for this connection
            //new OutputServerThread(this, s);
        }
    }

    // Get an enumeration of all the OutputStreams, one for each client
    // connected to us
    private Collection<DataOutputStream> getOutputStreams() {
        return this.outputStreams.values();
    }

    // Send a message to all clients (utility routine)
    void sendToAll(String message) {

        // We synchronize on this because another thread might be
        // calling removeConnection() and this would screw us up
        // as we tried to walk through the list
        synchronized (this.outputStreams) {

            // For each client ...
            for (DataOutputStream dout : getOutputStreams()) {

                // ... and send the message
                try {
                    this.original.print(message);
                    dout.writeUTF(message);
                }
                catch (IOException ie) {
                    logger.warning(ie.toString());
                }
            }
        }
    }

    void removeConnection(Socket s) {

        // Synchronize so we don't mess up sendToAll() while it walks
        // down the list of all output streamsa
        synchronized (this.outputStreams) {

            logger.fine("Removing connection to " + s);

            // Remove it from our hashtable/list
            this.outputStreams.remove(s);

            // Make sure it's closed
            try {
                s.close();
            }
            catch (IOException ie) {
                logger.severe("Error closing " + s);
                ie.printStackTrace();
            }
        }
    }

    /* (non-Javadoc)
     * @see net.beiker.xletview.io.OutputPrinter#print(java.lang.String)
     */
     static int i = 0;
    public void print(String s) {
        // TODO Auto-generated method stub
        if(i < 4){
            logger.fine("echo");
            i++;
        }
        sendToAll(s);

    }

}

