package org.example.behavioral.memento;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.type("This is the first sentence.");
        editor.type("This is second.");
// Save the state
        editor.save();
// Type more
        editor.type("This is third.");
// Print all contents
        System.out.println(editor.getContent()); // This is the first sentence. This is second. This is third.
// Restoring to last saved state
        editor.restore();
// Print content
        System.out.println(editor.getContent()); // This is the first sentence. This is second.
    }
}
