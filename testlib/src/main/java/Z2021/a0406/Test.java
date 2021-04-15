package Z2021.a0406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Test {

    static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n > 0) {
                int tail = n % 10;
                sum += tail * tail;
                n = n / 10;
            }
            n = sum;
        }
        return n == 1;
    }

    static int resverse(int num) {
        int result = 0;
        while (num > 0) {
            int tail = num % 10;
            num = num / 10;
            result = result * 10 + tail;
        }
        return result;
    }

    static int[] getSumIndex(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    static int getCountZero(int[] a, int[] b, int[] c, int[] d) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int k = a[i] + b[j];
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                int k = c[i] + d[j];
                if (map.containsKey(-k)) {
                    count += map.get(-k);
                }
            }
        }
        return count;
    }

    static int getNum(int n) {
        int curr = 0;
        int next = 1;
        while (n - 2 >= 0) {
            int temp = curr + next;
            curr = next;
            next = temp;
            n--;
        }
        return next;
    }

    static String resverseStr(String value) {
        String result = "";
        for (char c : value.toCharArray()) {
            result = c + result;
        }
        return result;
    }

    static String resverseString(String value, int k) {
//        StringBuffer buffer = new StringBuffer();
//        for (int i = 0; i < value.length(); i = i + 2 * k) {
//            int j = i + k;
//            buffer.append(resverseStr(value.substring(i, j)));
//            buffer.append(value.substring(j, i + 2 * k));
//        }
        //|return buffer.toString();
        char[] chars = value.toCharArray();
        for (int i = 0; i < value.length(); i += 2 * k) {
            int j = i + k - 1;
            if (j > value.length() - 1) {
                j = value.length() - 1;
            }
            resverse(chars, i, j);
        }
        return new String(chars);
    }

    static void resverse(char[] chars, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }

    static String replaceSpace(String str) {
        /*int spaceCount = 0;
        int otherCount = 0;
        for(char c : str.toCharArray()){
            if(c == ' '){
                spaceCount++;
            }else{
                otherCount++;
            }
        }
        char[] chars = new char[otherCount + spaceCount * 3];*/
        char[] chars = new char[str.length() * 3];
        int index = 0;
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                chars[index++] = '%';
                chars[index++] = '2';
                chars[index++] = '0';
            } else {
                chars[index++] = c;
            }
        }
        return new String(chars, 0, index);
    }

    static String searchStr(String s) {
        for (int len = s.length(); len > 1; len--) {
            for (int i = 0, j = len; i < s.length() - len; i++, j = i + len) {
                String str = s.substring(i, j);
                HashMap<Character, Integer> map = new HashMap<>();
                for (char c : str.toCharArray()) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
                boolean noRepeat = true;
                for (int value : map.values()) {
                    if (value >= 2) {
                        noRepeat = false;
                        break;
                    }
                }
                if (noRepeat) {
                    return str;
                }
            }
        }
        return null;
    }

    static String searchStr1(String s) {
        for (int len = s.length(); len > 1; len--) {
            for (int i = 0, j = len; i < s.length() - len; i++, j = i + len) {
                HashSet<Character> set = new HashSet<>();
                boolean isRepeat = false;
                for (int start = i; start < j; start++) {
                    if (set.contains(s.charAt(start))) {
                        isRepeat = true;
                        break;
                    } else {
                        set.add(s.charAt(start));
                    }
                }
                if (!isRepeat) {
                    return s.substring(i, j);
                }
            }
        }
        return null;
    }

    static String getMaxStr(String s) {
        for (int len = s.length(); len > 1; len--) {
            for (int i = 0, j = len; i < s.length() - len; i++, j = i + len) {
                boolean flag = true;
                for (int start = i, end = j; start <= end; start++, end--) {
                    if (s.charAt(start) != s.charAt(end)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return s.substring(i, j+1);
                }
            }
        }
        return "";
    }
    //leetcode 1047
    static String removeRepeatElement(String s){
        Deque<Character> stack = new LinkedList();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == ch){
                stack.poll();
            }else{
                stack.push(ch);
            }
        }
        String result = "";
        Character ch  = null;
        while ( (ch = stack.poll()) != null){
            result = ch + result;
        }
        return result;
    }
    static Integer[] getMaxArray(int[] nums,int k){
        try {
            List list = new ArrayList<>();
            for(int i = 0,j = k; i <= nums.length - k; i++,j = i + k){
                int max = nums[i];
                for(int start = i + 1; start < j; start++){
                    if(nums[start] > max){
                        max = nums[start];
                    }
                }
                list.add(max);
            }
            Integer[] ints = new Integer[list.size()];
            list.toArray(ints);
            return ints;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        //return ints;
    }
    static Integer[] getMaxArray1(int[] nums ,int k){
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t0, int[] t1) {
                return t1[0] - t0[0];
            }
        });
        int i = -1;
        while (i++ < k - 1){
            queue.offer(new int[]{nums[i],i});
        }
        int j = k;
        List<Integer> list = new ArrayList<>();
        list.add(queue.peek()[0]);
        while (j < nums.length){
            queue.offer(new int[]{nums[j],j});
            while (queue.peek()[1] <= j - k){
                queue.poll();
            }
            list.add(queue.peek()[0]);
            j++;
        }
        Integer[] ints = new Integer[list.size()];
        list.toArray(ints);
        return ints;
    }
    public static void main(String[] args) {
        //System.out.println(isHappy(12));
        //System.out.println(resverse(123));
        //System.out.println(Arrays.toString(getSumIndex(new int[]{5,25,2,19},30)));
        //System.out.println(getCountZero(new int[]{1,2},new int[]{3,4},new int[]{1,2},new int[]{3,4}));
        ///System.out.println(getNum(6));
        //System.out.println(resverseStr("mxdl"));
        //StringBuffer buffer = new StringBuffer("abcdefg");
        //System.out.println(resverseString("abcdefgh", 2));
        //System.out.println(replaceSpace("i love  you "));
//        System.out.println(searchStr("aabcggffgxll"));
//        System.out.println(searchStr1("aabcggffgxll"));
        //System.out.println(getMaxStr("abcabcdmcfcmdf"));
        //System.out.println(removeRepeatElement("abbacf"));
     /*   Deque<Integer> deque = new LinkedList<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);

        System.out.println(deque.poll());*/
        //System.out.println(Arrays.toString(getMaxArray(new int[]{5,25,2,19},2)));
        System.out.println(Arrays.toString(getMaxArray1(new int[]{5,25,2,19},2)));
    }

}
