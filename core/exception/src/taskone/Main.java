package taskone;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("-----get until valid age-----");
//        ValidAge.getValidAge();

        System.out.println("-----test exception framework workflow-----");
//        FrameworkWorkflow.runner();

        System.out.println("-----test exception try catch finally----");
//        TryCatchFinally.runnerOne(4);
        System.out.println(TryCatchFinally.runnerTwo(2));
    }
}