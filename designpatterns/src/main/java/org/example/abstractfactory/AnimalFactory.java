package org.example.abstractfactory;

import org.example.abstractfactory.animal.Animal;
import org.example.abstractfactory.animal.Dog;
import org.example.abstractfactory.animal.Duck;

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
