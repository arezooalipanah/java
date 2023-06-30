package createThread;

class FirstWay extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "in first thread");

        System.out.println("hello");
        System.out.println("Bye");
    }
}