package quiz1;

public class Quiz1 {
    public static void main(String[] args) {
        new Thread(new R()).start();
        new T().start();
        new Thread(new R()).start();
        new T().start();
        for (char c = 'a'; c < 'z'; c++) {
            System.out.println(c);
        }
    }
}

class T extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
        }
    }
}

class R implements Runnable {
    @Override
    public void run() {
        for (char c = 'A'; c < 'Z'; c++) {
            System.out.println(c);
        }
    }
}
