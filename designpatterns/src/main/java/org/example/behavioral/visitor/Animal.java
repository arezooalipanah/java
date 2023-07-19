package org.example.behavioral.visitor;

public interface Animal {
    void accept(AnimalOperation operation);
}
