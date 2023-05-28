package org.example.abstractfactory;

import org.example.abstractfactory.color.Black;
import org.example.abstractfactory.color.Color;
import org.example.abstractfactory.color.White;

import java.nio.file.Watchable;

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
