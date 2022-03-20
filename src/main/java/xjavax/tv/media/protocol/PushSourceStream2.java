/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.media.protocol;

/**
 * The <code>PushSourceStream2</code> interface identifies a
 * <code>SourceStream</code> that pushes asynchronous data.
 *
 * <p> Note that a <code>PushSourceStream2</code> provides no
 * guarantees of the length of time that incoming data will be
 * buffered before being discarded or overwritten with new data.
 * Because of the time-dependent nature of the stream, clients should
 * read the pending data immediately upon notification.
 *
 * <p> This interface is functionally identical to
 * <code>javax.media.protocol.PushSourceStream</code>, except that it
 * provides the <code>readStream()</code> method that throws
 * exceptions.  Instances of <code>PushSourceStream2</code> may be
 * obtained through the JMF method
 * <code>javax.media.protocol.PushDataSource.getStreams()</code>.  In
 * Java TV implementations, objects returned by this method will be of
 * type <code>PushSourceStream2</code>.  Instances of
 * <code>PushDataSource</code> are obtained by means of
 * <code>javax.media.Manager.createDataSource(javax.media.MediaLocator)</code>.
 * If access to broadcast asynchronous data is not supported by the
 * system, this method will throw
 * <code>javax.media.NoDataSourceException</code>.
 * <HR>
 *
 *
 */
public interface PushSourceStream2 extends javax.media.protocol.PushSourceStream
{
    /**
     * Reads pending data from the stream without blocking.
     *
     * @param buffer - The buffer to read bytes into.
     * @param offset - The offset into the buffer at which to begin writing data.
     * @param length - The number of bytes to read.
     * @return The number of bytes read or -1 when the end of stream is reached.
     * @throws java.io.IOException - If an I/O error occurs.
     * @throws DataLostException - If data from the stream has been lost.
     * @throws ArrayIndexOutOfBoundsException - If offset , length , or offset+length > buffer.length.
     */
    public int readStream(byte[] buffer, int offset, int length) throws java.io.IOException, DataLostException;

}
