package Quiz3;

public class Interrupting extends Thread {
    public static void main(String[] args) throws InterruptedException{
        Interrupting th = new Interrupting();
        th.start();
        Thread.sleep(1000);
        th.interrupt();
    }
    @Override
    public synchronized void run() {
        try {
            wait();
            System.out.println("after wait");
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("resume");
    }
}
