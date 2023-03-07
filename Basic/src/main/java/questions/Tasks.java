package questions;

import java.util.ArrayList;
import java.util.Arrays;

public class Tasks {

    // task 2
    public static Integer warOfNumbers(Integer[] numbers) {
        int sumOdds = 0;
        int sumEvens = 0;

        for (Integer num : numbers) {
            if (num % 2 == 0) {
                sumEvens += num;
            } else {
                sumOdds += num;
            }
        }

        return sumEvens > sumOdds ? sumEvens - sumOdds : sumOdds - sumEvens;
    }

    // task 3
    public static Integer getBudgets(People[] peoples) {
        Integer sumOfBudgets = 0;

        for (People person : peoples) {
            sumOfBudgets += person.budget;
        }

        return sumOfBudgets;
    }

    // task 4
    public static Integer getDecimalPlaces(String number) {
        Integer indexOfPointer = number.indexOf(".");
        return indexOfPointer > 0 ? indexOfPointer : 0;
    }

    // task 5
    public static Boolean isAvgWhole(Integer[] numbers) {
        Integer size = numbers.length;
        Integer sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }

        return (float) sum / size % 1 == 0;
    }

    // task 6
    public static Boolean matchLastItem(String[] items) {
        String lastItem = items[items.length - 1];
        String concatRes = "";

        for (int i = 0; i < items.length - 1; i++) {
            concatRes += items[i];
        }

        return lastItem.equals(concatRes);
    }

    // task 7
    public static String replaceVowels(String str, char character) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                result += character;
            } else {
                result += ch;
            }
        }

        return result;
    }

    // task 8
    public static Boolean isValid(String str) {
        return str.length() <= 5 && !str.contains(" ") && str.matches("[0-9]+");
    }

    // task 9
    static String afterRep(char ch, int num) {
        String result = "";
        for (int i = 0; i < num; i++) {
            result += ch;
        }

        return result;
    }

    public static String repeat(String str, int repeatNum) {
        String result = "";
        for (char ch : str.toCharArray()) {
            result += afterRep(ch, repeatNum);
        }

        return result;
    }

    // task 10
    public static String spaceMeOut(String str) {
        String result = "";
        for (char ch : str.toCharArray()) {
            result += ch + " ";
        }

        return result;
    }

    // task 11
    public static Integer maxTotal(Integer[] numbers) {
        Arrays.sort(numbers);
        Integer sum = 0;

        for (int i = 5; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }

    // task 12
    public static Boolean isSpecialArray(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i += 2) {
            if (arr[i] % 2 != 0 || arr[i + 1] % 2 == 0) {
                return false;
            }
        }

        return true;
    }

    // task 13
    public static Boolean canNest(Integer[] arr1, Integer[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return arr1[0] > arr2[0] && arr1[arr1.length - 1] < arr2[arr2.length - 1];
    }

    // task 14
    public static Boolean factorChain(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i += 2) {
            if (numbers[i + 1] % numbers[i] != 0) {
                return false;
            }
        }

        return true;
    }

    // task 15
    public static Boolean existsHigher(Integer[] numbers, Integer number) {
        for (Integer num : numbers) {
            if (num >= number) return true;
        }

        return false;
    }

    // task 16
    public static String nameShuffle(String fullName) {
        String[] separatedStr = fullName.split(" ");
        return separatedStr[1] + " " + separatedStr[0];
    }

    // task 17
    public static Boolean canCapture(String[] inputs) {
        return inputs[1].contains(inputs[0].substring(0, 1)) || inputs[1].contains(inputs[0].substring(1, 2));
    }

    // task 18
    public static String fizzBuzz(Integer number) {
        return number % 3 == 0 && number % 5 == 0 ? "FizzBuzz" : number % 3 == 0 ? "Fizz" : number % 5 == 0 ? "Buzz" : String.valueOf(number);
    }

    // task 19
    public static String stutter(String input) {
        return input.substring(0, 2) + "... " + input.substring(0, 2) + "... " + input + "?";
    }

    // task 20
    public static String formatPhoneNumber(Integer[] digits) {
        return "(" + digits[0] + digits[1] + digits[2] + ")" + " " + digits[3] + digits[4] + digits[5] + "-" + digits[6] + digits[7] + digits[8] + digits[9];
    }

    // task 21
    public static String sevenBoom(Integer[] numbers) {
        return Arrays.toString(numbers).contains("7") ? "Boom!" : "there is no 7 in the array";
    }

    // task 22
    public static Boolean winRound(Integer[] arr1, Integer[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        Integer cards = arr1[arr1.length - 1] + arr1[arr1.length - 2];
        Integer opponent = arr2[arr2.length - 1] + arr2[arr2.length - 2];

        return cards > opponent;
    }

    // task 23
    public static Integer largestGap(Integer[] numbers) {
        Arrays.sort(numbers);
        Integer[] result = new Integer[numbers.length - 1];
        int index = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            result[index++] = numbers[i + 1] - numbers[i];
        }
        Arrays.sort(result);

        return result[result.length - 1];
    }

    // task 24
    public static Boolean validate(String str) {
        return !str.contains(" ") && (str.length() == 4 || str.length() == 6) && str.matches("[0-9]+");
    }

    // task 25
    public static Integer count(Integer digits) {
        int length = 0;
        long temp = 1;
        while (temp <= Math.abs(digits)) {
            length++;
            temp *= 10;
        }

        return length;
    }

    // task 26
    public static Boolean cons(Integer[] numbers) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1] || numbers[i + 1] - numbers[i] != 1) {
                return false;
            }
        }

        return true;
    }

    // task 27
    public static Boolean isPalindrome(String str) {
        String reverseStr = "";
        int strLength = str.length();
        for (int i = (strLength - 1); i >= 0; --i) {
            reverseStr = reverseStr + str.charAt(i);
        }

        return str.equals(reverseStr);
    }

    // task 28
    public static Boolean isFactorial(Integer number) {
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                number /= i;
            } else {
                break;
            }
        }

        return number == 1;
    }

    // task 29
    public static Integer sum(Integer[] numbers) {
        if (numbers.length == 0) return 0;
        if (numbers.length == 1) return numbers[0];

        Integer sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }

        return sum;
    }

    // task 30
    public static Boolean canPartition(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int multiple = 1;
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                multiple *= numbers[j];
            }
            if (multiple == numbers[i]) return true;

        }

        return false;
    }

    // task 31
    public static Boolean isHarShad(Integer number) {
        String[] digits = Integer.toString(number).split("");
        Integer sum = 0;

        for (int i = 0; i < digits.length; i++) {
            sum += Integer.valueOf(digits[i]);
        }

        return sum > number ? sum % number == 0 : number % sum == 0;
    }

    // task 32
    public static Boolean alternateSign(Integer[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) return false;
            if (numbers[i] > 0 && numbers[i + 1] > 0 || numbers[i] < 0 && numbers[i + 1] < 0) return false;
        }

        return true;
    }

    // task 33
    private static boolean checkIsPrime(Integer number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }

    public static Integer primeNumbers(Integer number) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i <= number; i++) {
            if (checkIsPrime(i)) primes.add(i);
        }

        return primes.size();
    }

    // task 34
    public static Long digitRoot(Long number) {
        String[] digits = Long.toString(number).split("");
        Long sum = 0L;

        for (int i = 0; i < digits.length; i++) {
            sum += Integer.valueOf(digits[i]);
        }
        if (sum >= 10) {
            sum = digitRoot(sum);
        }

        return sum;
    }

    // task 35
    public static String unmix(String str) {
        if (str.length() == 0) return "";

        String[] digits = str.split("");
        String result = "";

        for (int i = 0; i < digits.length - 1; i += 2) {
            if (digits[i + 1] != null) {
                result += digits[i + 1];
            }
            result += digits[i];
        }

        return digits.length % 2 == 0 ? result : result + digits[digits.length - 1];
    }

}