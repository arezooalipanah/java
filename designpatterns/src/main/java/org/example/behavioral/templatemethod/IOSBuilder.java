package org.example.behavioral.templatemethod;

public class IOSBuilder extends Builder{
    @Override
    public void assemble() {
        System.out.println("Assembling iOS build");
    }

    @Override
    public void deploy() {
        System.out.println("Deploying iOS build");
    }

    @Override
    public void lint() {
        System.out.println("Linting iOS code");
    }

    @Override
    public void test() {
        System.out.println("Running iOS tests");
    }
}
