package org.example.creational.abstractfactory;

import org.example.creational.abstractfactory.color.Color;

public class FactoryProvider {
    public static AbstractFactory getFactory(String choice) {
        switch (choice) {
            case "Animal":
                return new AnimalFactory();
            case "Color":
                return new ColorFactory();
            default:
                throw new IllegalArgumentException("unknown choice");
        }
    }
}

class Test {
    public static void main(String[] args) {
        AbstractFactory color = FactoryProvider.getFactory("Color");
        Color black = (Color) color.create("BLACK");
        System.out.println(black.getColor());
        System.out.println("hello".equals("helkklo"));
    }
}
