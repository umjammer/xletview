/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.io;

import java.io.IOException;
import java.io.OutputStream;

/*
    Based on code by Greg Travis. You can find the original code
    and how to write a custom console here:
    http://www.developer.com/tech/article.php/630821
*/

/**
 * Redirects an Outputstream to a class implementing OutputPrinter
 */
public class OutputRedirector extends OutputStream {

    private OutputPrinter outputPrinter;

    // we keep a buffer around for creating 1-char strings, to
    // avoid the potential horror of thousads of array allocations
    // per second
    private byte littlebuf[] = new byte[1];


    /**
     *
     * @param printer The OutputPrinter to redirect to
     */
    public OutputRedirector(OutputPrinter printer){
        outputPrinter = printer;
    }

    // Redirect output to the console
    public void write(int b) throws IOException {
        littlebuf[0] = (byte) b;
        String s = new String(littlebuf, 0, 1);
        outputPrinter.print(s);
    }

    // Redirect output to the console
    public void write(byte b[]) throws IOException {
        String s = new String(b, 0, b.length);
        outputPrinter.print(s);
    }

    // Redirect output to the console
    public void write(byte b[], int off, int len) throws IOException {
        String s = new String(b, off, len);
        outputPrinter.print(s);
    }

    // nothing need be done here
    public void flush() throws IOException {
    }

    // nothing need be done here
    public void close() throws IOException {
    }
}
