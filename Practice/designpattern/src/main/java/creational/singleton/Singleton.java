package creational.singleton;

public class Singleton {
    private static Singleton instance;

    public void doSomething() {
        System.out.println("something");
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
