package 多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印ab，各打印50个，先打印a
 */
public class 交替打印3 {
    private static Lock lock = new ReentrantLock();

    private static Integer count = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            while (count < 50) {
                System.out.println("A");
                count++;
            }
        });
    }

    private static void print(String name, int state) {

    }
}
