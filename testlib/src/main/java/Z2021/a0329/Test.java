package Z2021.a0329;

import java.util.Arrays;
import java.util.HashSet;

import Z2019.A002.ListNode;

public class Test {
    static int halfSearchIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //逆时针旋转90度
    static int[][] rotationMatrix(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[n - j - 1][i] = nums[i][j];
            }
        }
        return result;
    }

    static ListNode removeListNode(ListNode note, int target) {
        ListNode root = new ListNode(-1);
        root.next = note;
        ListNode prev = root;
        ListNode curr = note;
        while (curr != null) {
            if (curr.val == target) {
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return root.next;
    }

    static boolean isListNodeRing(ListNode head) {
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

    static ListNode isListNodeRing1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow != null) {
                    slow = slow.next;
                    fast = fast.next;
                    if (slow == fast) {
                        return slow;
                    }
                }
            }
        }
        return null;
    }

    static ListNode reverseListNode(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static ListNode reverseListNode1(ListNode head) {
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

    static ListNode removeListNodeIndex(ListNode head, int num) {
        ListNode fast = head;
        for (int i = 0; i < num + 1; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    static ListNode mergeListNode(ListNode list1, ListNode list2) {
        ListNode curr = null;
        ListNode head = null;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                if (curr == null) {
                    curr = list2;
                    head = curr;
                } else {
                    curr.next = list2;
                    curr = curr.next;
                }
                list2 = list2.next;
            } else {
                if (curr == null) {
                    curr = list1;
                    head = curr;
                } else {
                    curr.next = list1;
                    curr = curr.next;
                }
                list1 = list1.next;
            }
        }
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return head;
    }

    static ListNode mergeListNode1(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 != null ? list1 : list2;
        return head.next;
    }
    static ListNode removeListNode1(ListNode list1,int target){
        ListNode head = new ListNode(-1);
        head.next = list1;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null){
            if(curr.val == target){
                break;
            }
            curr = curr.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head.next;
    }
    public static void main(String[] args) {
        //System.out.println(halfSearchIndex(new int[]{2, 5, 19, 25}, 19));
        //int[][] ints = rotationMatrix(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});
        //System.out.println();
//        ListNode listNode = new ListNode(0);
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//
//        listNode.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
        ///listNode3.next = listNode1;

        //System.out.println(removeListNode(listNode,2));
        //System.out.println(isListNodeRing1(listNode).val);
        //System.out.println(listNode.toString());
        //System.out.println(reverseListNode(listNode).toString());
        //System.out.println(reverseListNode1(listNode).toString());
        //System.out.println(removeListNodeIndex(listNode,2).toString());
        ListNode listNode0 = new ListNode(0);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);

        listNode0.next = listNode2;
        listNode2.next = listNode4;

        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);

        listNode1.next = listNode3;
        listNode3.next = listNode5;
        listNode5.next = listNode7;
        listNode7.next = listNode8;

        //System.out.println(mergeListNode(listNode0, listNode1).toString());
        //System.out.println(mergeListNode1(listNode0, listNode1).toString());
        System.out.println(removeListNode1(listNode1,1).toString());

        char c = '~';
        System.out.println((int)c);

        byte a = 127;
        char c1 = '/';
        System.out.println((double) c1);

        int a1 = 98;
        System.out.println((char)a1);

        HashSet<Integer> set = new HashSet<>();
    }
}
