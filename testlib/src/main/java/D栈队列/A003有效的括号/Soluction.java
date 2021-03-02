package D栈队列.A003有效的括号;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Soluction {
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

    public static void main(String[] args) {
        System.out.println(isValid("(){}({[]})"));
    }
}
