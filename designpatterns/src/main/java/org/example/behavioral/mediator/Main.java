package org.example.behavioral.mediator;

public class Main {
    public static void main(String[] args) {
        ChatRoom mediator = new ChatRoom();

        User john = new User("John", mediator);
        User jane = new User("Jane", mediator);

        john.send("Hi there!"); // March 01, 21:38 [John]: Hi there!
        jane.send("Hey!");      // March 01, 21:38 [Jane]: Hey!
        jane.send("Hey!");      // March 01, 21:38 [Jane]: Hey!
    }
}
