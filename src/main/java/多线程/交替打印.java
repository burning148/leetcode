package 多线程;

import javax.swing.plaf.TreeUI;

/**
 * 三个线程交替打印abc，打印100个字符
 */
public class 交替打印 {
    private static final Object lock = new Object();
    private static Integer count = 0;

    public static void main(String[] args) {
        new Thread(() -> print("A", 0)).start();
        new Thread(() -> print("B", 1)).start();
        new Thread(() -> print("C", 2)).start();
    }

    private static void print(String name, int state) {
        while (count < 100) {
            synchronized (lock) {
                if (count % 3 == state) {
                    System.out.println(name);
                    count++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}
