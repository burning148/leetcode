package 多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 交替打印2 {
    private static ReentrantLock lock = new ReentrantLock();

    private static Integer count = 0;

    public static void main(String[] args) {
        Condition printA = lock.newCondition();
        Condition printB = lock.newCondition();
        Condition printC = lock.newCondition();

        new Thread(() -> {
            while (true) {
                lock.lock();
                if (count < 100) {
                    System.out.println("A");
                    count++;
                }

                printB.signal();
                try {
                    printA.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                lock.lock();
                if (count < 100) {
                    System.out.println("B");
                    count++;
                }

                printC.signal();
                try {
                    printB.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
            }
        }).start();


        new Thread(() -> {
            while (true) {
                lock.lock();
                if (count < 100) {
                    System.out.println("C");
                    count++;
                }

                printA.signal();
                try {
                    printC.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
            }
        }).start();


    }
}
