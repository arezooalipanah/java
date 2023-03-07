package generic.repository.array;

import generic.repository.InvalidIndexOrLineException;
import generic.shared.Base;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------add element/elements----------");
        GenericArrayRepository<Base> genericArrayRepository = new GenericArrayRepository<>(2);
        Base base = new Base();
        base.setId(300);

        Base baseForRemove = new Base();
        baseForRemove.setId(600);
        // add
        genericArrayRepository.add(new Base(100, "name100"));
        genericArrayRepository.add(new Base(101, "name101"));
        genericArrayRepository.add(new Base(102, "name102"));
        genericArrayRepository.add(new Base(103, "name103"));
        genericArrayRepository.print();
        // add as array
        System.out.println("add by array");
        genericArrayRepository.add(new Base[]{new Base(200, "name200"), new Base(201, "name201"), new Base(202, "name202"), new Base(203, "name203")});
        genericArrayRepository.add(base);
        genericArrayRepository.add(baseForRemove);
        genericArrayRepository.add(baseForRemove);
        genericArrayRepository.add(base);
        genericArrayRepository.add(base);
        genericArrayRepository.add(baseForRemove);

        genericArrayRepository.print();

        System.out.println("----------get element----------");
        // get by index
        try {
            System.out.println(genericArrayRepository.get(2).getId());
//            System.out.println(arrayRepository.get(-1));
        } catch (InvalidIndexOrLineException e) {
            throw new RuntimeException(e);
        }
        // get by id
        System.out.println(genericArrayRepository.getById(100L));

        System.out.println("----------find element----------");
        System.out.println(genericArrayRepository.find(base));
        System.out.println(genericArrayRepository.findById(201L));

        System.out.println("----------remove element/duplicate elements----------");
        try {
            genericArrayRepository.remove(0);
        } catch (InvalidIndexOrLineException e) {
            throw new RuntimeException(e);
        }
        genericArrayRepository.print();

        System.out.println("remove element");
        try {
            genericArrayRepository.remove(baseForRemove);
        } catch (InvalidIndexOrLineException e) {
            throw new RuntimeException(e);
        }
        genericArrayRepository.print();

        System.out.println("remove duplicate elements");
        try {
            genericArrayRepository.removeDuplicates(baseForRemove);
        } catch (InvalidIndexOrLineException e) {
            System.out.println(e);
            ;
        }
        genericArrayRepository.print();


        System.out.println("----------update element----------");
        try {
//            arrayRepository.update(-1, new Base((long) 500L));
            genericArrayRepository.update(1, new Base(500, "name500"));
        } catch (InvalidIndexOrLineException e) {
            throw new RuntimeException(e);
        }
        genericArrayRepository.print();

        System.out.println("-----clear && contain && sub-elements && print-----");
        System.out.println("contain");
        System.out.println(genericArrayRepository.contain(201L));
        System.out.println(genericArrayRepository.contain(301L));

        System.out.println("sub-element");
        System.out.println(Arrays.toString(genericArrayRepository.slice(1, 4)));
//        throw NullPointException
//        System.out.println(Arrays.toString(genericArrayRepository.slice(1, 100)));
        genericArrayRepository.subElements(0, 3).print();

        System.out.println("before clear");
        genericArrayRepository.print();
        genericArrayRepository.clear();
        System.out.println("after clear");
        genericArrayRepository.print();

        System.out.println("-----use constructor with generic------");
        GenericArrayRepository<Base> genericArrayRepository1 = new GenericArrayRepository<>(genericArrayRepository);
        genericArrayRepository1.add(new Base(700, "name701"));
        genericArrayRepository.print();
    }
}
