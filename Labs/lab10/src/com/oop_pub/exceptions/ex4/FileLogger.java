package com.oop_pub.exceptions.ex4;

import java.util.EnumSet;

public class FileLogger extends LoggerBase {
    FileLogger(EnumSet<LogLevel> enumSet) {
        super(enumSet);
    }

    @Override
    void writeMessage(String msg) {
        System.out.println("[File] " + msg);
    }
}