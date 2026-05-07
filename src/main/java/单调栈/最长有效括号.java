package 单调栈;

import java.util.Stack;

public class 最长有效括号 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else  {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else  {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    // 有效的括号
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')')
            } else if (c == '[') {
                stack.push(']')
            } else if (c == '{') {
                stack.push('}')
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    // 有效的括号 增加了一个优先级限制：大括号 {} 只能包含中括号 [] 或小括号 ()，中括号 [] 只能包含小括号 ()，而小括号 () 内部不能再包含更高优先级的括号。
    public boolean isValid2(String s) {
        if (s == null || s.length() == 0) return true;

        Stack<Integer> stack = new Stack<>();
        // 定义括号的优先级
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('(', 1);
        priority.put('[', 2);
        priority.put('{', 3);

        // 定义匹配关系
        Map<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 如果是左括号
            if (priority.containsKey(c)) {
                int currentP = priority.get(c);
                
                // 优先级检查：新入栈的括号优先级必须 <= 栈顶括号优先级
                if (!stack.isEmpty()) {
                    int topP = priority.get(s.charAt(stack.peek()));
                    if (currentP > topP) {
                        return false; // 违反优先级规则，例如 ([])
                    }
                }
                stack.push(i);
            } 
            // 如果是右括号
            else if (pair.containsKey(c)) {
                if (stack.isEmpty()) return false;
                
                char leftChar = s.charAt(stack.pop());
                // 检查括号是否匹配
                if (leftChar != pair.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
