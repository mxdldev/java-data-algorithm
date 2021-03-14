package Z2021.a0314;

import Z2019.A002.ListNode;
import temp.TreeNode;

/**
 * Description: <Test><br>
 * Author:      mxdl<br>
 * Date:        2021/3/14<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Test {
    static int getMaxNum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] result = new int[m][n];
        result[0][0] = nums[0][0];
        for (int i = 1; i < n; i++) {
            result[0][i] = result[0][i - 1] + nums[0][i];
        }
        for (int i = 1; i < m; i++) {
            result[i][0] = result[i - 1][0] + nums[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + nums[i][j];
            }
        }
        return result[m - 1][n - 1];
    }

    private static int getMinvalue(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];
        // 给result[0][0]赋值
        result[0][0] = grid[0][0];
        // 给第一行赋值
        for (int i = 1; i < result[0].length; i++) {
            result[0][i] = result[0][i - 1] + grid[0][i];
        }
        // 给第一列赋值
        for (int i = 1; i < result.length; i++) {
            result[i][0] = result[i - 1][0] + grid[i][0];
        }
        // 给其他元素赋值
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j];
            }
        }
        return result[result.length - 1][result[0].length - 1];
    }

    //1.删除一个链表的倒数第n个节点
    static ListNode removeListNode(ListNode root, int index) {
        ListNode fast = root;
        for (int i = 0; i < index + 1; i++) {
            fast = fast.next;
        }
        ListNode slow = root;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return root;
    }

    //3.最大回文串
    static String maxHuiwen(String s) {
        String max = "";
        for (int len = 1; len < s.length(); len++) {
            for (int i = 0, j = len; i < s.length() - len; i++, j = i + len) {
                String s1 = s.substring(i,j+1);
                StringBuffer buffer = new StringBuffer(s1);
                if(s1.equals(buffer.reverse().toString()) && s1.length() > max.length()){
                    //return s1;
                    max = s1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(getMaxPathNums(3, 2));
//        int[][] result = new int[][]{{0,1,2},{3,4,5},{6,7,8}};
//        System.out.println(getMaxNum(result));
//        System.out.println(getMinvalue(result));
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(8);

        listNode.next = listNode1;
        //listNode1.next = listNode2;
        //listNode2.next = listNode3;
        //listNode3.next = listNode4;

        ListNode listNode111 = new ListNode(1);
        ListNode listNode11 = new ListNode(3);
        ListNode listNode21 = new ListNode(5);
        ListNode listNode31 = new ListNode(66);
        ListNode listNode41 = new ListNode(88);

        listNode111.next = listNode11;
        //listNode11.next = listNode21;
        //listNode21.next = listNode31;
        //listNode31.next = listNode41;
        //System.out.println(removeListNode(listNode,1));
        //System.out.println(mergeListNode(listNode, listNode111));
        //System.out.println(mergeListNode1(listNode, listNode111));
        System.out.println(maxHuiwen("aafaabaamsdf"));
    }

    //2.合并两个链表
    static ListNode mergeListNode(ListNode t1, ListNode t2) {
        ListNode root = new ListNode(-1);
        ListNode curr = root;
        while (t1 != null && t2 != null) {
            curr.next = new ListNode(t1.val + t2.val);

            t1 = t1.next;
            t2 = t2.next;
            curr = curr.next;
        }
        return root.next;
    }

    static ListNode mergeListNode1(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode curr = root;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return root.next;
    }

    static int getMaxPathNums(int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            result[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result[m - 1][n - 1];
    }
}
