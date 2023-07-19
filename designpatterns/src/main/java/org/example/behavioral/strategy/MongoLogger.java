package org.example.behavioral.strategy;

public class MongoLogger implements Logger {
    @Override
    public void log(Object o) {
        System.out.println("Logged on mongo" + o);
    }
}
