package com.oop_pub.exceptions.ex1;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainEx1 {
    private static void readAndPrintLine() throws IIOException {

        // TODO: Read a line from stdin and print it to stdout
        // TODO: Don't forget to close the reader (Hint: try-with-resources, try-finally)
//        try {
//            System.out.println(reader.readLine());
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                reader.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        readAndPrintLine();
    }
}
