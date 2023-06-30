package createThread;

public class Main {
    public static void main(String[] args) {
        // first way to declare thread
        System.out.println("salam");
        FirstWay t = new FirstWay();
        t.start();


        System.out.println("khodahafez");

        // second way to declare thread
        Thread t2 = new Thread(new SecondWay());
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();
    }
}