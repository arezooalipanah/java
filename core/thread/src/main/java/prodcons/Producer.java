package prodcons;

import java.util.List;

public class Producer extends Thread {
    List<Integer> list;

    Producer(List<Integer> l) {
        list = l;
    }

    @Override
    public void run() {
        for (Integer i = 0; i < 100; i++) {
            synchronized (list) {
                Integer num = (int) (Math.random() * 1000);
                System.out.println("Added" + num);
                list.add(num);
                list.notify();
            }
        }
        try {
            Thread.sleep((long) (Math.random() * 10));
        } catch (InterruptedException e) {

        }
    }
}
