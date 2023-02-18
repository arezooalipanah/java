package org.example;

import java.text.NumberFormat;
import java.util.Scanner;

public class Exercice {

    public static void main(String[] args) {
        // example1
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Principal...");
        int principal = scanner.nextInt();

        System.out.println("Annual...");
        float annual = scanner.nextFloat();
        float monthlyInterest = annual / PERCENT / MONTHS_IN_YEAR;


        System.out.println("Period (yearly)...");
        byte year = scanner.nextByte();
        int numberOfPayments = year * MONTHS_IN_YEAR;

        double result = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
                (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgage = NumberFormat.getCurrencyInstance().format(result);
        System.out.println(mortgage);


        // example2
        Scanner scanner1 = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.print("input..");
            input = scanner1.next().toLowerCase();
            if (input.equals("reset"))
                continue;
            if (input.equals("quit"))
                break;
            System.out.println(input);
        }
    }
}
