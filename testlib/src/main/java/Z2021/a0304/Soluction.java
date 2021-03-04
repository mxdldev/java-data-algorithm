package Z2021.a0304;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Soluction {
    static boolean isValid(String s) {
        //1.判断是否是有效的字符串，对碰取消，立马就要想到栈的结构
        //1.法1：哈希表+栈
        //哈希表缓存数据源
        HashMap<Character, Character> map = new HashMap() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        //把左侧的放入栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && map.get(ch) == stack.peek()) {
                //是右侧且找到了则弹栈
                stack.pop();
            } else {
                //左侧的入栈
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    //法2：一个栈即可解决问题
    static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        //遍历字符串，碰到右侧的则把左侧的入栈，否则是右侧的则该字符与栈顶字符比对相等则弹栈，否则就直接returfalse
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    //1.删除相邻的重复元素
    //例：aabbcde cde ; abbacdaabb cd
    static String removeRepeatElement(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuffer buffer = new StringBuffer();
        while (!stack.empty()) {
            buffer.append(stack.pop());
        }
        return buffer.reverse().toString();
    }

    //3.滑动窗口的最大值，优先队列,k为窗口的大小
    //法1：暴力枚举法
    //法2：优先队列法
    static int[] getSlidingWindowMaxValue(int[] nums, int k) {
        //1.构建优先队列
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[0] != n[0] ? n[0] - m[0] : n[1] - m[1];
            }
        });
        //给队列初始化赋值
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        //创建结果数组
        int[] result = new int[nums.length - k + 1];
        result[0] = queue.poll()[0];
        //遍历数组取最大值
        for (int i = k; i < nums.length; i++) {
            //何时弹栈，何时入栈
            //入栈
            queue.offer(new int[]{nums[i], i});
            //干掉滑动窗口之外的大元素
            while (!queue.isEmpty() && queue.peek()[1] <= i - k) {
                queue.poll();
            }
            //把最大值取出来给结果数组赋值上 ***注意：是peek***
            result[i - k + 1] = queue.peek()[0];
        }
        return result;
    }

    //4.求出现频率最高的前k项
    //例子：1,2,1,1,2,3,3,3 => 1,3
    //优先队列，小顶堆，
    static int[] getMaxResult(int[] nums, int k) {
        int[] result = new int[0];
        //把数组的值进行出现次数的统计
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //创建优先队列进行过滤
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1]; //条件写错了，整个结果都是错的
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int data = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k) {
                //干掉小的元素
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{data, count});
                }
            } else {
                queue.offer(new int[]{data, count});
            }
        }
        result = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            result[i++] = queue.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(isValid("([(){}])"));
        //System.out.println(isValid1("([(){}])"));
        //System.out.println(removeRepeatElement("aabbcdabbaf"));
        //System.out.println(Arrays.toString(getSlidingWindowMaxValue(new int[]{1, 5, 3, 10, 7}, 3)));
        System.out.println(Arrays.toString(getMaxResult(new int[]{1, 2, 1, 1, 3, 3, 4,2,2,2,2}, 2)));
    }
}
