package Quiz4;

public class Scan extends Thread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main starts");
        Scan scan = new Scan();
        Object obj = scan.object = new Object();
        scan.start();
        synchronized (obj) {
            System.out.println(scan.getState());
            obj.wait();
        }
        System.out.println("Main other jobs");
    }

    public Object object;
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("scan");
        synchronized (object) {
            object.notify();
            System.out.println("test");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("scan other jobs");
    }
}
