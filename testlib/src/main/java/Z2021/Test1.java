package Z2021;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Description: <Test1><br>
 * Author:      mxdl<br>
 * Date:        2021/2/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Test1 {
    static String getIndex(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int key = target - arr[i];
            if (map.containsKey(key)) {
                return i + "," + map.get(key);
            } else {
                map.put(arr[i], i);
            }
        }
        return null;
    }

    static void test(String str) {
        int j = -1;
        int[] next = new int[str.length()];
        next[0] = -1;
        for (int i = 1; i < str.length(); i++) {
            while (j >= 0 && str.charAt(i) != str.charAt(j + 1)) {
                   j = next[j];
            }
            if(str.charAt(i) == str.charAt(j+1)){
                j++;
            }
            next[i] = j;
        }
        System.out.println(next);
    }

    public static void main(String[] args) {
        test("aabaaf");
        LinkedList<Integer> link = new LinkedList<>();
        link.offerFirst(1);
        link.offerLast(1);
        Queue queue = new LinkedBlockingQueue();
        Queue queue1 = new LinkedBlockingDeque();
        Queue queue2 = new PriorityBlockingQueue();
        Stack<Integer> stack = new Stack<>();
    }
//    getNext1(int next, String s) {
//    int j = -1;
//    next[0] = j;
//    for (int i = 1; i < s.size(); i++){ // 注意i从1开始
//        while (j >= 0 && s[i] != s[j + 1]) { // 前后缀不相同了
//            j = next[j]; // 向前回溯
//        }
//        if (s[i] == s[j + 1]) { // 找到相同的前后缀
//            j++;
//        }
//        next[i] = j; // 将j（前缀的长度）赋给next[i]
//    }
//    }

}
