package creational.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        instance.doSomething();
        Singleton2 instance1 = Singleton2.INSTANCE;
        instance.doSomething();
    }
}