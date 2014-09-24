

package net.beiker.xletview.download;
/**
 * Thrown when an application's size is too big.
 * @author Martin Sveden
 *
 */
public class AppSizeExceededException extends RuntimeException {
    /**
     * Constructs a <code>AppSizeExceededException</code> with no detail message.
     */
    public AppSizeExceededException() {
        super();
    }

    /**
     * Constructs a <code>AppSizeExceededException</code> with the specified 
     * detail message. 
     *
     * @param   s   the detail message.
     */
    public AppSizeExceededException(String s) {
        super(s);
    }
}