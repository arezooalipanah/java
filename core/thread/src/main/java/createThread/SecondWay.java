package createThread;

public class SecondWay implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread()+ "in second way");
        System.out.println("hello");
        System.out.println("bye");
    }
}
