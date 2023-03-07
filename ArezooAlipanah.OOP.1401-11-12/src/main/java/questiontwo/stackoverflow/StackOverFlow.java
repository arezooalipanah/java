package questiontwo.stackoverflow;

// class StackOverFlow {
//    static int count = 1;
//
////    public static int printNum() {
////             int a = 0;
////             int b = 0;
////             try {
////                 return a / b;
////               } catch (RuntimeException e) {
////                 return -1;
////               } catch (ArithmeticException e) {
////                 return 0;
////               } finally {
////                 System.out.print("done");
////               }
//////  What is the output of the following snippet, assuming a and b are both 0?
////    }
//}

 public class StackOverFlow {
public String name;
public void run() {
    System.out.print("1");
    try {
        System.out.print("2");
        name.toString();
        System.out.print("3");
    } catch (NullPointerException e) {
        System.out.print("4");
        throw e;
    }
    System.out.print("5");
}
 }