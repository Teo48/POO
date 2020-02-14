package com.oop_pub.exceptions.ex4;

import java.util.EnumSet;

public class EmailLogger extends LoggerBase{
    EmailLogger(EnumSet<LogLevel> enumSet) {
        super(enumSet);
    }

    @Override
    void writeMessage(String msg) {
        System.out.println("[Email] " + msg);
    }
}