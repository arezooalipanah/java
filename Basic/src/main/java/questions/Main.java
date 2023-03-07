package questions;

import java.text.NumberFormat;
import java.util.IllformedLocaleException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // task 2
        System.out.println("---------task 2---------");
        Integer[] numbers = {5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243};
        System.out.println(Tasks.warOfNumbers(numbers));

        // task 3
        System.out.println("---------task 3---------");
        People people1 = new People("John", 21, 23000);
        People people2 = new People("steve", 32, 40000);
        People people3 = new People("martin", 16, 2700);
        People[] peoples = {people1, people2, people3};
        System.out.println(Tasks.getBudgets(peoples));

        // task 4
        System.out.println("---------task 4---------");
        System.out.println(Tasks.getDecimalPlaces("43.20"));
        System.out.println(Tasks.getDecimalPlaces("400"));
        System.out.println(Tasks.getDecimalPlaces("3.1"));

        // task 5
        System.out.println("---------task 5---------");
        Integer[] numbers2 = {9, 2, 2, 5};
        System.out.println(Tasks.isAvgWhole(numbers2));

        // task 6
        System.out.println("---------task 6---------");
        String[] items = {"12", "13", "17", "19", "20", "40", "121317192040"};
        String[] items2 = {"1", "1", "1", "11"};
        System.out.println(Tasks.matchLastItem(items));
        System.out.println(Tasks.matchLastItem(items2));

        // task 7
        System.out.println("---------task 7---------");
        System.out.println(Tasks.replaceVowels("the aardvark", '#'));
        System.out.println(Tasks.replaceVowels("minnie mouse", '?'));

        // task 8
        System.out.println("---------task 8---------");
        System.out.println(Tasks.isValid("59001"));
        System.out.println(Tasks.isValid("853a7"));
        System.out.println(Tasks.isValid("732 32"));

        // task 9
        System.out.println("---------task 9---------");
        System.out.println(Tasks.repeat("mice", 5));
        System.out.println(Tasks.repeat("hello", 3));
        System.out.println(Tasks.repeat("stop", 1));

        // task 10
        System.out.println("---------task 10---------");
        System.out.println(Tasks.spaceMeOut("space"));
        System.out.println(Tasks.spaceMeOut("far out"));

        // task 11
        System.out.println("---------task 11---------");
        Integer[] numbers3 = {1, 1, 0, 1, 3, 10, 10, 10, 10, 1};
        Integer[] numbers4 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 10};
        System.out.println(Tasks.maxTotal(numbers3));
        System.out.println(Tasks.maxTotal(numbers4));

        // task 12
        System.out.println("---------task 12---------");
        Integer[] numbers5 = {2, 7, 4, 9, 6, 1, 6};
        Integer[] numbers6 = {2, 7, 9, 1, 6, 1, 6, 3};
        Integer[] numbers7 = {2, 7, 8, 8, 6, 1, 6, 3};
        System.out.println(Tasks.isSpecialArray(numbers5));
        System.out.println(Tasks.isSpecialArray(numbers6));
        System.out.println(Tasks.isSpecialArray(numbers7));

        // task 13
        System.out.println("---------task 13---------");
        System.out.println(Tasks.canNest(new Integer[]{1, 2, 3, 4}, new Integer[]{0, 6}));
        System.out.println(Tasks.canNest(new Integer[]{9, 9, 8}, new Integer[]{8, 9}));

        // task 14
        System.out.println("---------task 14---------");
        Integer[] numbers8 = {3, 6, 12, 36};
        Integer[] numbers9 = {1, 2, 4, 8, 16, 32};
        Integer[] numbers10 = {10, 1};
        System.out.println(Tasks.factorChain(numbers8));
        System.out.println(Tasks.factorChain(numbers9));
        System.out.println(Tasks.factorChain(numbers10));

        // task 15
        System.out.println("---------task 15---------");
        System.out.println(Tasks.existsHigher(new Integer[]{5, 3, 15, 22, 4}, 10));
        System.out.println(Tasks.existsHigher(new Integer[]{1, 2, 3, 4, 5}, 8));
        System.out.println(Tasks.existsHigher(new Integer[]{}, 5));
        System.out.println(Tasks.existsHigher(new Integer[]{4, 3, 3, 3, 2, 2, 2}, 4));

        // task 16
        System.out.println("---------task 16---------");
        System.out.println(Tasks.nameShuffle("Trump Donald"));
        System.out.println(Tasks.nameShuffle("Rosie O'Donnell"));

        // task 17
        System.out.println("---------task 17---------");
        System.out.println(Tasks.canCapture(new String[]{"A8", "E8"}));
        System.out.println(Tasks.canCapture(new String[]{"A1", "B2"}));
        System.out.println(Tasks.canCapture(new String[]{"H4", "H3"}));
        System.out.println(Tasks.canCapture(new String[]{"F5", "C8"}));

        // task 18
        System.out.println("---------task 18---------");
        System.out.println(Tasks.fizzBuzz(15));
        System.out.println(Tasks.fizzBuzz(10));
        System.out.println(Tasks.fizzBuzz(6));
        System.out.println(Tasks.fizzBuzz(61));

        // task 19
        System.out.println("---------task 19---------");
        System.out.println(Tasks.stutter("incredible"));
        System.out.println(Tasks.stutter("enthusiastic"));

        // task 20
        System.out.println("---------task 20---------");
        System.out.println(Tasks.formatPhoneNumber(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));

        // task 21
        System.out.println("---------task 21---------");
        System.out.println(Tasks.sevenBoom(new Integer[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(Tasks.sevenBoom(new Integer[]{8, 6, 33, 100}));
        System.out.println(Tasks.sevenBoom(new Integer[]{2, 55, 60, 97, 86}));

        // task 22
        System.out.println("---------task 22---------");
        System.out.println(Tasks.winRound(new Integer[]{2, 5, 2, 6, 9}, new Integer[]{3, 7, 3, 1, 2}));
        System.out.println(Tasks.winRound(new Integer[]{1, 2, 3, 4, 5}, new Integer[]{9, 8, 7, 6, 5}));
        System.out.println(Tasks.winRound(new Integer[]{4, 3, 4, 4, 5}, new Integer[]{3, 2, 5, 4, 1}));

        // task 23
        System.out.println("---------task 23---------");
        System.out.println(Tasks.largestGap(new Integer[]{9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5}));
        System.out.println(Tasks.largestGap(new Integer[]{14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7}));

        // task 24
        System.out.println("---------task 24---------");
        System.out.println(Tasks.validate("121317"));
        System.out.println(Tasks.validate("1234"));
        System.out.println(Tasks.validate("89abc1"));

        // task 25
        System.out.println("---------task 25---------");
        System.out.println(Tasks.count(12345));
        System.out.println(Tasks.count(-92563));
        System.out.println(Tasks.count(638476));
        System.out.println(Tasks.count(4666));

        // task 26
        System.out.println("---------task 26---------");
        System.out.println(Tasks.cons(new Integer[]{5, 1, 4, 3, 2}));
        System.out.println(Tasks.cons(new Integer[]{5, 1, 4, 3, 2, 8}));
        System.out.println(Tasks.cons(new Integer[]{5, 6, 7, 8, 9, 9}));

        // task 27
        System.out.println("---------task 27---------");
        System.out.println(Tasks.isPalindrome("madam"));
        System.out.println(Tasks.isPalindrome("adieu"));
        System.out.println(Tasks.isPalindrome("rotor"));

        // task 28
        System.out.println("---------task 28---------");
        System.out.println(Tasks.isFactorial(2));
        System.out.println(Tasks.isFactorial(27));
        System.out.println(Tasks.isFactorial(24));

        // task 29
        System.out.println("---------task 29---------");
        System.out.println(Tasks.sum(new Integer[]{1, 2, 3, 4}));
        System.out.println(Tasks.sum(new Integer[]{1, 2}));
        System.out.println(Tasks.sum(new Integer[]{1}));
        System.out.println(Tasks.sum(new Integer[]{}));

        // task 30
        System.out.println("---------task 30---------");
        System.out.println(Tasks.canPartition(new Integer[]{2, 8, 4, 1}));
        System.out.println(Tasks.canPartition(new Integer[]{-1, -10, 1, -2, 20}));
        System.out.println(Tasks.canPartition(new Integer[]{-1, -20, 5, -1, -2, 2}));
        System.out.println(Tasks.canPartition(new Integer[]{3, 2, 1, 6}));
        System.out.println(Tasks.canPartition(new Integer[]{3, 2, 1, 6, 7}));

        // task 31
        System.out.println("---------task 31---------");
        System.out.println(Tasks.isHarShad(75));
        System.out.println(Tasks.isHarShad(171));
        System.out.println(Tasks.isHarShad(481));
        System.out.println(Tasks.isHarShad(89));
        System.out.println(Tasks.isHarShad(516));
        System.out.println(Tasks.isHarShad(200));

        // task 32
        System.out.println("---------task 32---------");
        System.out.println(Tasks.alternateSign(new Integer[]{3, -2, 5, -5, 2, -8}));
        System.out.println(Tasks.alternateSign(new Integer[]{4, 4, -2, 3, -6, 10}));
        System.out.println(Tasks.alternateSign(new Integer[]{-6, 1, -1, 4, -3}));

        // task 33
        System.out.println("---------task 33---------");
        System.out.println(Tasks.primeNumbers(10));
        System.out.println(Tasks.primeNumbers(20));
        System.out.println(Tasks.primeNumbers(30));

        // task 34
        System.out.println("---------task 34---------");
        System.out.println(Tasks.digitRoot(123L));
        System.out.println(Tasks.digitRoot(999888777L));
        System.out.println(Tasks.digitRoot(1238763636555555555L));

        // task 35
        System.out.println("---------task 35---------");
        System.out.println(Tasks.unmix(""));
        System.out.println(Tasks.unmix("badcfeg"));
        System.out.println(Tasks.unmix("123456"));
        System.out.println(Tasks.unmix("hTsii  s aimex dpus rtni.g"));

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Principle...");
        Double principal = input.nextDouble();
        System.out.println(principal);
        if (principal < 1000 || principal > 1000000) {
            throw new IllformedLocaleException("enter a number between 1000 and 1000000");
        }
        System.out.println("Enter Annual Interest Rate:");
        Double rate = input.nextDouble();
        if (rate < 0 || rate > 30) {
            throw new IllformedLocaleException("enter a value greater that zero and less than or equal to 30");
        }
        rate /= 12;
        rate /= 100;
        System.out.println("Enter period yearly");
        Integer period = input.nextInt();
        if (period < 1 || period > 30) {
            throw new IllformedLocaleException("enter a value between 1 and 30");
        }
        period *= 12;
        double result = principal * ((rate * Math.pow((1 + rate), period)) / (Math.pow((1 + rate), period) - 1));
        System.out.println(NumberFormat.getCurrencyInstance().format(result));

        String s;
        while (true) {
            System.out.println("please enter a string...");
            s = new Scanner(System.in).nextLine().toLowerCase();
            if (s.equals("quit")) break;
            System.out.println(s.equals("pass") ? "" : s);
        }
    }
}