package generic.repository.file;

import generic.repository.InvalidIndexOrLineException;
import generic.shared.Base;

public class Main {
    public static void main(String[] args) {
        GenericFileRepository<Base> file = new GenericFileRepository<>("file.txt");
        file.createFile();

        file.add(new Base(1, "name1"));
        file.add(new Base(2, "name2"));
        file.add(new Base(7, "name7"));
        file.add(new Base(3, "name3"));
        file.add(new Base(4, "name4"));
        file.add(new Base(5, "name5"));
        file.add(new Base(6, "name6"));
        file.add(new Base(7, "name7"));
        file.add(new Base(7, "name7"));
        file.add(new Base(7, "name7"));
        file.add(new Base(7, "name7"));
        file.add(new Base(7, "name7"));
        file.add(new Base(7, "name7"));

        System.out.println("-----get line-----");
        System.out.println(file.get(2));

        System.out.println("-----slice-----");
        System.out.println(file.slice(2, 4));

        System.out.println("-----find-----");
        System.out.println(file.find(new Base(1, "name1")));

        System.out.println("-----remove-----");
        try {
            file.remove(1);
        } catch (InvalidIndexOrLineException e) {
            System.out.println(e);
        }

        try {
            file.remove(new Base(1, "name1"));
        } catch (InvalidIndexOrLineException e) {
            System.out.println(e);
        }

        try {
            file.removeDuplicates(new Base(7, "name7"));
        } catch (InvalidIndexOrLineException e) {
            System.out.println(e);
        }

        System.out.println("-----update-----");
        try {
            file.update(1, new Base(1, "name1"));
        } catch (InvalidIndexOrLineException e) {
            System.out.println(e);
        }

        System.out.println("-----contain-----");
        System.out.println(file.contain(new Base(1, "name1")));
        System.out.println(file.contain(new Base(1, "name1")));

        System.out.println("-----minify-----");
        file.minifyFile();

        System.out.println("-----clear-----");
        // uncomment below to see result
//        file.print();
//        file.clear();
//        file.print();

        System.out.println("-----delete-----");
        // uncomment below to see result
//        file.delete();
    }
}
