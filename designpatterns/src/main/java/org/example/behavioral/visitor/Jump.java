package org.example.behavioral.visitor;

public class Jump implements AnimalOperation{
    @Override
    public void visitMonkey(Monkey monkey) {
        System.out.println("Jumped 20 feet high! on to the tree!");
    }

    @Override
    public void visitLion(Lion lion) {
        System.out.println("Jumped 7 feet! back on the ground!");
    }
}
