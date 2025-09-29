package 单调栈;

import java.util.Arrays;
import java.util.Stack;

public class 找到第一个比自己大得元素 {

    public static int[] findFirstGreater(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                Integer index = stack.pop();
                res[index] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 4, 8, 6, 7, 19, 10};
        System.out.println(Arrays.toString(firstGreater2(arr)));
    }

    public static int[] firstGreater2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    res[i] = arr[j];
                    break;
                } else {
                    res[i] = -1;
                }
            }
        }
        res[arr.length - 1] = -1;
        return res;
    }
}
