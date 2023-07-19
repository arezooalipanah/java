package org.example.behavioral.templatemethod;

public class AndroidBuilder extends Builder {
    @Override
    public void assemble() {
        System.out.println("Assembling android build");
    }

    @Override
    public void deploy() {
        System.out.println("Deploying android build");
    }

    @Override
    public void lint() {
        System.out.println("Linting android code");
    }

    @Override
    public void test() {
        System.out.println("Running android tests");
    }
}
