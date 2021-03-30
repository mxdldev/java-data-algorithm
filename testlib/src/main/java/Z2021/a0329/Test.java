package Z2021.a0329;

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
    static ListNode removeListNode(ListNode note,int target){
        ListNode root = new ListNode(-1);
        root.next = note;
        ListNode prev = root;
        ListNode curr = note;
        while (curr != null){
            if(curr.val == target){
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return root.next;
    }
    static boolean isListNodeRing(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    static ListNode isListNodeRing1(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = head;
                while (slow != null){
                    slow = slow.next;
                    fast = fast.next;
                    if(slow == fast){
                        return slow;
                    }
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        //System.out.println(halfSearchIndex(new int[]{2, 5, 19, 25}, 19));
        //int[][] ints = rotationMatrix(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});
        //System.out.println();
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode1;

        //System.out.println(removeListNode(listNode,2));
        System.out.println(isListNodeRing1(listNode).val);

    }
}
