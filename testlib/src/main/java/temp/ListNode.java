package temp;

/**
 * Description: <ListNode><br>
 * Author:      mxdl<br>
 * Date:        2019/8/3<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
    public int val(){
        return val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
