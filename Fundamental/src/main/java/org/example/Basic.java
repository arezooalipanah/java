package org.example;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Basic {

    public static void main(String[] args) {
        // primitive data types
        int x = 1;
        int y = x;
        x = 2;
        System.out.println(y);

        // reference data types
        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 2;
        point1.y = 2;
        System.out.println(point2);
        point2.x = 8;
        System.out.println(point1);

        // String
        String message = new String("  hello world!  ");
        System.out.println(message);
        String message1 = "hellllo"; // shorthand for string declare
        System.out.println(message1);
        System.out.println(message.endsWith("d"));
        System.out.println(message.length()); // length string
        System.out.println(message.indexOf("oll")); // -1
        System.out.println(message.replace("!", "?"));
        System.out.println(message);
        System.out.println(message.trim());

        // escape sequence
        System.out.println("hellp ]\"kfk\"");
        System.out.println("c:\\windows");
        System.out.println("c:\nwindows");
        System.out.println("c:\twindows");

        // array
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
//        numbers[10] = 5; // ArrayIndexOutOfBoundsException
        System.out.println(numbers);
        System.out.println(Arrays.toString(numbers));

        boolean[] strs = new boolean[5];
        strs[0] = false;
        System.out.println(Arrays.toString(strs));

        int[] nums = {1, 2, 3, 8, 5, 4}; // shorthand for array declare
        System.out.println(Arrays.toString(nums));
        System.out.println(nums.length); // length array
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int[][] numbers2 = new int[3][2];
        numbers2[0][0] = 1;
        System.out.println(Arrays.deepToString(numbers2));

        int[][] nums2 = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println(Arrays.deepToString(nums2));

        // constant
        final float PI = 3.14F;

        // operators + - * / %
        int a = 10 / 3;
        System.out.println(3); // 3
        double b = (double) 10 / 3;
        System.out.println(a); // 3.333

        // prefix ++ and postfix ++
        int z = 1;
//        int w = z++;
//        System.out.println(z); // 2
//        System.out.println(w); // 1
//        System.out.println(z); // 2
//
        int w = ++z;
        System.out.println(w); // 2
        System.out.println(z); // 2
        System.out.println(w); // 2

        int d = 1;
        x += 2; // x = x + 2;
        System.out.println(x);

        // type casting
//        short o = 1; // short convert to int
//        int p = o + 2;
//        System.out.println(p);

        double o = 1.1;
        double p = o + 2; // int 2 convert to double if we want int cast it // 3.1
        p = (int) o + 2; // 3.0
        System.out.println(p);

        // cast string to numbers
        // use wrapper classes

        // string to int
        int n = Integer.parseInt("1");
        System.out.println(n);

        // string to double
        double m = Double.parseDouble("2");
        System.out.println(m);

        // Math
        double result = Math.round(1.1F);
        System.out.println(result);

        result = Math.floor(1.1F);
        System.out.println(result);

        result = Math.ceil(1.1F);
        System.out.println(result);

        result = Math.max(1, 2);
        System.out.println(result);

        result = Math.min(15, 12);
        System.out.println(result);

        result = Math.random();
        System.out.println(result);
        System.out.println((int) (result * 100));
        System.out.println(Math.round(result * 100));

        // number format
        // Factory methods
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String format = currency.format(123456.89);
        System.out.println(format);
        String currency2 = NumberFormat.getPercentInstance().format(0.1);
        System.out.println(currency2);

        // scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Age: ");
        byte age = scanner.nextByte();
        System.out.println("your age is: " + age);
        System.out.println("name: ");
        String name = scanner.next();
        System.out.println(name);
    }
}
