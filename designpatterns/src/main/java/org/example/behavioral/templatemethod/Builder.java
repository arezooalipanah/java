package org.example.behavioral.templatemethod;

public abstract class Builder {
    // Template method
    public void build() {
        test();
        lint();
        assemble();
        deploy();
    }

    abstract public void test();
    abstract public void lint();
    abstract public void assemble();
    abstract public void deploy();

}
