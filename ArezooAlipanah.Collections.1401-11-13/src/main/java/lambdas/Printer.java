package lambdas;

@FunctionalInterface
public interface Printer {
    void print(String message);
    default void printTwice(String message) {
        System.out.println(message);
    }
}
