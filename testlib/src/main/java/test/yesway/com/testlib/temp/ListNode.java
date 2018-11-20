package test.yesway.com.testlib.temp;

/**
 * Description: <><br>
 * Author:      gxl<br>
 * Date:        2018/11/13<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" + "val=" + val +'}';
    }
}
