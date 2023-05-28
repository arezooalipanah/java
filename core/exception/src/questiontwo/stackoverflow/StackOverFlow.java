package questiontwo.stackoverflow;

public class StackOverFlow {
    static int count = 1;

    public static void printNum() {
        if (count <= 100000) {
            System.out.println("Hello");
            count++;
            printNum();
        }
    
    }
}