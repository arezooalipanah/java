package org.example.creational.abstractfactory;

public interface AbstractFactory<T> {
    T create(String name);
}
