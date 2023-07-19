package org.example.structural.bridge;

public class Main {
    public static void main(String[] args) {
        Shape square = new Square(new Blue());
        System.out.println(square.draw());
    }
}
