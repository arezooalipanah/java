package taskone;

import java.io.IOException;

public class TryCatchFinally {

    public static void runnerOne(int n) {
        try {
            switch (n) {
                case 1:
                    System.out.println("1st case");
                    return;
                case 3:
                    System.out.println("3rd case");
                    throw new RuntimeException("3!");
                case 4:
                    System.out.println("4th case");
                    throw new Exception("4!");
                case 2:
                    System.out.println("2nd case");
            }
        } catch (RuntimeException e) {
            System.out.println("RuntimeException");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("try-block entered");
        }
    }

    static void throwMyException() throws IOException {
        throw new IOException();
    }

    public static int runnerTwo(int n) {
        try {
            switch (n) {
                case 1:
                    System.out.println("one");
                    return 1;
                case 2:
                    System.out.println("two");
                    throwMyException();
                case 3:
                    System.out.println("three");
            }
            return 4;
        } catch (Exception e) {
            System.out.println("CATCh");
            return 5;
        } finally {
            System.out.println("finally");
            return 6;
        }
    }

}

class MyException extends Exception {
}
