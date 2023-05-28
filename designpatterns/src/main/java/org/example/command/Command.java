package org.example.command;

public interface Command<T, E> {
    T execute(E e);
}
