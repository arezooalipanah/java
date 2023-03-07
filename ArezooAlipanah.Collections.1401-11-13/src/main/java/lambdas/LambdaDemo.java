package lambdas;

public class LambdaDemo {
    public static void greet(Printer printer) {
        printer.print("hello world");
    }

    public static void show() {
        greet((String message) -> System.out.println(message) );
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });
    }
}
