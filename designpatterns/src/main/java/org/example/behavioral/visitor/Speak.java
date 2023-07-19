package org.example.behavioral.visitor;

public class Speak implements AnimalOperation{
    @Override
    public void visitMonkey(Monkey monkey) {
        monkey.shout();
    }

    @Override
    public void visitLion(Lion lion) {
        lion.roar();
    }
}
