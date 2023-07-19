package org.example.behavioral.visitor;

public class Main {
    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        Lion lion = new Lion();

        Speak speak = new Speak();
        Jump jump = new Jump();

        monkey.accept(speak);   // Ooh oo aa aa!
        monkey.accept(jump);    // Jumped 20 feet high! on to the tree!

        lion.accept(speak);     // Roaaar!
        lion.accept(jump);      // Jumped 7 feet! Back on the ground!
    }
}
