package org.example.behavioral.strategy;

import java.util.HashMap;
import java.util.Map;

public interface Logger {
    void log(Object o);
}


class Test {
    public static void main(String[] args) {
        Map<LoggerTypes, Logger> loggerMap = new HashMap<>();
        loggerMap.put(LoggerTypes.MONGO, new MongoLogger());
        loggerMap.put(LoggerTypes.FILE, new FileLogger());
//        use
//        if(...) {
//            loggerMap.get(LoggerTypes.FILE).log(....);
//        }
    }
}

enum LoggerTypes {
    FILE, MONGO
}