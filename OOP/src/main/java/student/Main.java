package student;

import java.util.Scanner;

public class Main {
    public static void
    main(String[] args) {
        // null pointer
        // reference
//        Student[] student = new Student[10];
//        for (int i = 0; i < student.length; i++) {
//            student[i].setID(i+1000);
//        }
//        System.out.println(student[5].getID());

        // correct
        Scanner scanner = new Scanner(System.in);
        Student[] student = new Student[10];
        for (int i = 0; i < student.length; i++) {
            student[i] = new Student();
            student[i].setID(i+1000);
            student[i].setName(scanner.next());
        }
        System.out.println(student[5].getID());

        // outofmemoryerror
        int[] array = new int[Integer.MAX_VALUE / 10];
    }
}
