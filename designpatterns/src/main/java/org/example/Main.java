package org.example;

class TestInterruptingThread2 extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("task");
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        System.out.println("thread is running...");
    }

    public static void main(String args[]) {
        TestInterruptingThread2 t1 = new TestInterruptingThread2();
        t1.start();
        t1.interrupt();

    }
}


class ABC extends Thread {
    Thread threadToInterrupt;

    public void run() {
        System.out.println(threadToInterrupt + "name is ");
        threadToInterrupt.interrupt();
    }
}


class ThreadJoinExample1 {
    public static void main(String[] argvs) {
        try {
            ABC th1 = new ABC();
            String s = new String();
            th1.threadToInterrupt = Thread.currentThread();
            th1.start();
            th1.join();

        } catch (InterruptedException ex) {
            System.out.println("The exception has been caught. " + ex);
        }
    }
}