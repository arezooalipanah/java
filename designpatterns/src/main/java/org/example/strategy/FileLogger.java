package org.example.strategy;

public class FileLogger implements Logger {
    @Override
    public void log(Object o) {
        System.out.println("logged on file" + o);
    }
}
