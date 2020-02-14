package com.tema1.utils;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * Class that implements methods for fast input parsing.
 * It only implements parsing for Strings and Ints.
 * */
public final class Reader {
    private static Constants c = new Constants();
    private final int shifter = 17;
    private final int bufferSize = 1 << shifter;
    private DataInputStream dataInputStream;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    /**
     * Constructor that initialize the stream for the parsing process.
     * @param inputPath which represents that path for the input stream
     * */
    public Reader(final String inputPath) throws IOException {
        dataInputStream = new DataInputStream(new FileInputStream(inputPath));
        buffer = new byte[bufferSize];
        bufferPointer = c.getZero();
        bytesRead = c.getZero();
    }

    /**
     * Method used for parsing a line.
     * @return String which represents the line read from the file specified in constructor.
     * */
    public String readLine() throws IOException {
        byte[] buf = new byte[1 << c.getMaxItemBag()];
        int counter = c.getZero();
        int chr;

        while ((chr = read()) != c.getNil()) {
            if (chr == '\n') {
                break;
            }
            buf[counter++] = (byte) chr;
        }
        return new String(buf, c.getZero(), counter);
    }

    /**
     * Method used for parsing an Integer value.
     * @return int
     * */
    public int nextInt() throws IOException {
        int ret = 0;
        byte chr = read();

        while (chr <= ' ') {
            chr = read();
        }

        boolean neg = (chr == '-');
        if (neg) {
            chr = read();
        }
         while (chr >= '0' && chr <= '9') {
            ret = (ret << c.getThree()) + (ret << c.getOne()) + chr - '0';
            chr = read();
        }

        if (neg) {
            return -ret;
        }

        return ret;
    }

    /**
     * Method that fills that buffer with data.
     * */
    private void fillBuffer() throws IOException {
        bufferPointer = c.getZero();
        bytesRead = dataInputStream.read(buffer, bufferPointer, bufferSize);
        if (bytesRead == c.getNil()) {
            buffer[0] = (byte) c.getNil();
        }
    }

    /**
     * Method used for buffer traversal.
     * @return byte which represent the current character in the buffer
     * */
    private byte read() throws IOException {
        if (bufferPointer == bytesRead) {
            fillBuffer();
        }
        return buffer[bufferPointer++];
    }

}
