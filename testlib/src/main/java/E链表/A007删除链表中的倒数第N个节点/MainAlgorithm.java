package E链表.A007删除链表中的倒数第N个节点;

import E链表.A001实现一个链表.ListNode;
import E链表.A001实现一个链表.MyListLink;

/**
 * Description: <删除链表中的倒数第N个元素><br>
 * Author:      gxl<br>
 * Date:        2018/11/23<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainAlgorithm {
    public static void main(String[] args){
        MyListLink myListLink = new MyListLink();
        myListLink.addLast(0);
        myListLink.addLast(1);
        myListLink.addLast(2);
        myListLink.addLast(3);
        myListLink.addLast(4);

        //删除倒数第2个元素
        ListNode head = removeReIndex(myListLink.getListLink(), 3);

        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    private static ListNode removeReIndex(ListNode listNode, int n) {
        ListNode head = listNode;
        ListNode pb = listNode;
        ListNode pa = listNode;
        int i = 0;
        while(i < n ){
            pa = pa.next;
            i++;
        }
        while(pa.next != null){
            pa = pa.next;
            pb = pb.next;
        }
        pb.next = pb.next.next;
        return head;
    }
}
