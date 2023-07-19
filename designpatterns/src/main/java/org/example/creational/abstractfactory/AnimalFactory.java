package org.example.creational.abstractfactory;

import org.example.creational.abstractfactory.animal.Animal;
import org.example.creational.abstractfactory.animal.Dog;
import org.example.creational.abstractfactory.animal.Duck;

public class AnimalFactory implements AbstractFactory<Animal>  {
    @Override
    public Animal create(String name) {
        switch (name) {
            case "DOG":
                return new Dog();
            case "DUCK":
                return new Duck();
            default:
                throw new IllegalArgumentException("unknown type");
        }
    }
}
