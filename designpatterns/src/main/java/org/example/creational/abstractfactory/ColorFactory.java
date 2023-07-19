package org.example.creational.abstractfactory;

import org.example.creational.abstractfactory.color.Black;
import org.example.creational.abstractfactory.color.Color;
import org.example.creational.abstractfactory.color.White;

public class ColorFactory implements AbstractFactory<Color> {
    @Override
    public Color create(String name) {
        switch (name) {
            case "WHITE":
                return new White();
            case "BLACK":
                return new Black();
            default:
                throw new IllegalArgumentException("unknown name");
        }
    }
}
