package Z2021.a0301;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import Z2021.a0206.ListNode;

public class Soluction {
    //1.新增数组元素找下标
    static int insertArrayElement(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    //2.删除数组中的元素
    static int[] removeArrayElement(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                int start = i;
                while (start < length - 1) {
                    nums[start] = nums[start + 1];
                    start++;
                }
                i--;
                length--;
            }
        }
        return nums;
    }

    //3.删除数组中的重复元素
    static int[] removeRepeatElement(int[] nums) {
        //快慢指针法
        int slow = 0;
        for (int fast = 0; fast < nums.length - 1; fast++) {
            if (nums[fast] != nums[fast + 1]) {
                nums[++slow] = nums[fast + 1];
            }
        }
        return nums;
    }

    //4.查找最小子数组
    static int[] searchMinArray(int[] nums, int target) {
        //滑动窗口
        int slow = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            while (sum >= target) {
                if (fast - slow < len) {
                    len = fast - slow;
                    start = slow;
                    end = fast;
                }
                sum -= nums[slow++];
            }
        }
        return new int[]{start, end};
    }

    //5.创建一个n*n的旋转矩阵
    static int[][] createMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, top = 0, right = n - 1, bottom = n - 1;
        int num = 1;
        while (num < n * n) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        return matrix;
    }

    //1.删除链表中的元素
    static ListNode removeListNodeElement(ListNode head, int val) {
        ListNode virturl = new ListNode(-1);
        virturl.next = head;
        ListNode prev = virturl;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return virturl.next;
    }

    //2.判断一个链表有没有环
    static boolean checkListNodeCycle(ListNode head) {
        //快慢指针法
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //3.查找一个有环链表的入口节点
    static ListNode getListNodeCycleEntry(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != null) {
                    slow = slow.next;
                    fast = fast.next;
                    if (slow == fast) {
                        return fast;
                    }
                }
            }
        }
        return null;
    }

    //4.翻转一个链表
    static ListNode reverseListNode(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //断链
            ListNode next = curr.next;
            //翻转
            curr.next = prev;
            //prev指针移动
            prev = curr;
            //next指针移动
            curr = next;
        }
        return prev;
    }

    //1.判断同母异位词 哈希法
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (char c : s.toCharArray()) {
            table[c - 97]++;
        }
        for (char c : t.toCharArray()) {
            table[c - 97]--;
        }
        for (int i : table) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    //2.赎金信
    static boolean canContruct(String ransom, String magazine) {
        int[] table = new int[26];
        for (char c : magazine.toCharArray()) {
            table[c - 97]++;
        }
        for (char c : ransom.toCharArray()) {
            table[c - 97]--;
            if (table[c - 97] < 0) {
                return false;
            }
        }
        return true;
    }

    //3.分糖果
    static int distributeCandy(int[] candy) {
        int[] table = new int[101];
        for (int i : candy) {
            table[i]++;
        }
        int count = 0;
        for (int i : table) {
            if (table[i] > i) {
                count++;
            }
        }
        int half = candy.length / 2;
        return count > half ? half : count;
    }

    //4.求两个数组的交集
    static int[] intersection(int[] nums1, int[] nums2) {
        int[] max = nums1;
        int[] min = nums2;
        if (nums2.length > nums1.length) {
            max = nums2;
            min = nums1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : max) {
            set.add(i);
        }
        Set<Integer> inter = new HashSet<>();
        for (int i : min) {
            if (set.contains(i)) {
                inter.add(i);
            }
        }
        int[] result = new int[inter.size()];
        int index = 0;
        for (int i : inter) {
            result[index++] = i;
        }
        return result;
    }

    //5.求一个数是否是快乐数
    static boolean isHappy(int n) {
        Set set = new HashSet();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n > 0) {
                int tail = n % 10;
                n = n / 10;
                sum += tail * tail;
            }
            n = sum;
        }
        return n == 1;
    }

    //6.两数字之和求下标
    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    //7.四个数之和为0的次数
    static int fourSum(int[] a, int[] b, int[] c, int[] d) {
        //暴力法n的四次方
        //哈希法n的平方
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            for (int j : b) {
                map.put(i + j, map.getOrDefault(i + j,0) + 1);
            }
        }
        int count = 0;
        for (int i : c) {
            for (int j : d) {
                if (map.containsKey(-i - j)) {
                    count += map.get(-i - j);
                }
            }
        }
        return count;
    }

    //1.翻转一个字符串
    static String reverseString(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    //2.翻转2k的前k个元素
    static String reverseString(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int j = i + k - 1;
            if (j > s.length() - 1) {
                j = s.length() - 1;
            }
            reverse(chars, i, j);
        }
        return new String(chars);
    }

    static void reverse(char[] chars, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }

    //3.翻转单词
    static String reverseWord(String s) {
        //1.去前面的空格
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                start = i;
                break;
            }
        }
        //2.去后面的空格
        int end = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) != ' ') {
                end = i;
                break;
            }
        }
        //3.去中间的空格
        StringBuffer buffer = new StringBuffer();
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != ' ') {
                buffer.append(s.charAt(i));
            } else if (buffer.charAt(buffer.length() - 1) != ' ') {
                buffer.append(' ');
            }
        }
        //4.翻转整个字符串
        char[] chars = buffer.toString().toCharArray();
        System.out.println(new String(chars));
        reverse(chars, 0, buffer.length() - 1);
        System.out.println(new String(chars));
        //5.翻转单词
        for (int start1 = 0, end1 = 0; start1 < chars.length; ) {
            while (end1 < chars.length && chars[end1] != ' ') {
                end1++;
            }
            reverse(chars, start1, end1 - 1);
            start1 = end1 + 1;
            end1 = start1;
        }
        return new String(chars);
    }

    //4.替换空格
    static String replaceSpace(String s) {
        StringBuffer buffer = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                buffer.append(c);
            } else {
                buffer.append("%20");
            }
        }
        return buffer.toString();
    }

    //5.kmp查找
    static int strStr(String source, String needle) {
        int[] next = new int[needle.length()];
        int j = -1;
        next[0] = -1;
        for (int i = 1; i < needle.length(); i++) {
            while (j >= 0 && needle.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if(needle.charAt(i) == needle.charAt(j + 1)){
                j++;
            }
            next[i] = j;
        }

        j = -1;
        for(int i = 0; i < source.length(); i++){
            while (j >= 0 && source.charAt(i) != needle.charAt(j + 1)){
                j = next[j];
            }
            if(source.charAt(i) == needle.charAt(j + 1)){
                j++;
            }
            if(j == needle.length() - 1){
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("aabcababaab","aabaa"));
        //System.out.println(replaceSpace("who are you"));
        //System.out.println(reverseWord("  you   are   who   "));
        //System.out.println("abcdefgh");
        //System.out.println(reverseString("abcdefghf", 2));
        //System.out.println(reverseString("mxdl"));
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2, -1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};
        //System.out.println(fourSum(A, B, C, D));
        //System.out.println(Arrays.toString(twoSum(new int[]{0, 1, 2, 3, 4, 5}, 7)));
        //System.out.println(isHappy(15));
        //System.out.println(Arrays.toString(intersection(new int[]{1, 2, 3, 4, 5}, new int[]{2, 4, 55, 6, 7})));
        //System.out.println(canContruct("mxdl", "axbdcldm"));
        //System.out.println(isAnagram("mxdl", "ldfm"));
        //System.out.println(searchArrayIndex(new int[]{0,1,2,4},3));
        //System.out.println(Arrays.toString(deleteArrayElement(new int[]{0,2,2,1,2,3,4},2)));
        //System.out.println(Arrays.toString(removeRepeatElement(new int[]{0,0,0,1,1,2,3,4,4})));
        //System.out.println(Arrays.toString(searchMinArray(new int[]{0, 2, 5, 1, 2, 2, 3, 1}, 7)));
        //System.out.println(Arrays.toString(createMatrix(4)));
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        //listNode3.next = listNode1;
        //System.out.println(removeListNodeElement(listNode,1).toString());
        //System.out.println(checkListNodeCycle(listNode));
        //System.out.println(getListNodeCycleEntry(listNode).val);
        //System.out.println(listNode.toString());
        //System.out.println(reverseListNode(listNode).toString());
    }
}
