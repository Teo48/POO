package com.oop_pub.exceptions.ex4;

import java.util.EnumSet;

enum LogLevel {
    Info, Debug, Warning, Error, FunctionalMessage, FunctionalError;

    static EnumSet<LogLevel> All() {
        return EnumSet.allOf(LogLevel.class);
    }
}