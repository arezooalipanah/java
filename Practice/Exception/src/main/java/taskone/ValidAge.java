package taskone;

import java.util.Scanner;

public class ValidAge {
    public static void getValidAge() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your age");

        int age = 0;
        boolean validAge = false;
        while (!validAge) {
            try {
                String str = input.next();
                age = Integer.parseInt(str);
                validAge = true;
            } catch (Exception e) {
                System.out.println("Enter a valid number:");
            }
        }
        System.out.println("you are" + age + "years old");
    }
}
