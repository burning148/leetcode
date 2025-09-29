package 多线程;

public class Test {
    int x;

    public static void main(String[] args) {
        Test t = new Test();
        t.x = 5;
        change(t);
        System.out.println(t.x);
    }

    public static void change(Test t) {
        t.x = 3;
    }
}