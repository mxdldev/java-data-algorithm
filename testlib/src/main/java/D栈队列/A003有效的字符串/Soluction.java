package D栈队列.A003有效的字符串;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Soluction {
    public static void main(String[] args) {
        System.out.println(isValid("(){}({[]})"));
        System.out.println(isValid1("(){}({[]})"));
    }

    //LeetCode：20
    static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> pairs = new HashMap() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || pairs.get(ch) != stack.peek()) {
                    return false;
                }
                stack.poll();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    static boolean isValid1(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
