package test.yesway.com.testlib.temp;

/**
 * Description: <><br>
 * Author:      gxl<br>
 * Date:        2018/11/13<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class Solution {
    // 设置两个指针(fast, slow)，初始值都指向头，slow每次前进一步，fast每次前进二步，
    // 如果链表存在环，则fast必定先进入环，而slow后进入环，两个指针必定相遇。
    // (当然，fast先行头到尾部为NULL，则为无环链表)程序如下：
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;//缓存node0
        ListNode slow = head;//缓存node0

        //一直遍历下去，如果有环的话，会一直的遍历下去
        while (fast != null && fast.next != null) {
            fast = fast.next.next;//取出node2的值
            slow = slow.next;//取出node1的值
            //如果前后两个值相等就退出
            System.out.println("fast:"+fast.val+";slow:"+slow.val);
            if (slow == fast) {
                break;
            }
        }

        return !(fast == null || fast.next == null);
    }
    public static boolean hasCircle(ListNode L)
    {
        if(L==null) return false;//单链表为空时，单链表没有环
        if(L.next==null) return false;//单链表中只有头结点，而且头结点的next为空，单链表没有环
        ListNode p=L.next;//p表示从头结点开始每次往后走一步的指针
        ListNode q=L.next.next;//q表示从头结点开始每次往后走两步的指针
        while(q!=null) //q不为空执行while循环
        {
            if(p==q) return true;//p与q相等，单链表有环
            p=p.next;
            q=q.next.next;
        }
        return false;
    }
    public static int[] removeDuplicates(int[] A) {

        if (A.length == 0) {
            return null;
        }

        int index = 0;//[0,index]只记录数组中出现的按从小到大的唯一一个数，已经排好序了
        int next = 1;

        // 算法思想：找index之后的比A[index]大的数，如是找到就移动到A[index+1]处，
        // index移动到下一个位置，next移动到下一个位置，再找比A[index]大的数

        while (next < A.length) {
            while (next < A.length && A[index] == A[next] ) { // 找不等于数组中最
                next++;
            }

            if (next < A.length) {
                index++;
                A[index] = A[next];
                next++;
            }
        }
        return A;
    }
}
