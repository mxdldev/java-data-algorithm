package E链表.A005删除链表中的倒数第N个节点;

import E链表.A001实现一个链表.ListNode;
import E链表.A001实现一个链表.MyListLink;

/**
 * Description: <删除链表中的倒数第N个元素><br>
 * Author:      mxdl<br>
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
    //　定义3个指针，分别指向当前遍历到的结点、它的前一个结点及后一个结点。在遍历过程中，首先记录当前节点的后一个节点，然后将当前节点的后一个节点指向前一个节点，其次前一个节点再指向当前节点，最后再将当前节点指向最初记录的后一个节点，如此反复，直到当前节点的后一个节点为NULL时，则代表当前节点时反转后的头结点了。
    public static temp.ListNode reversListNote(temp.ListNode listNode) {
        temp.ListNode headNode = null;
        temp.ListNode currNode = listNode;
        temp.ListNode preNdoe = null;
        while (currNode != null) {
            //记录当前节点的下一个节点
            temp.ListNode nextNode = currNode.next;
            if (nextNode == null) {
                headNode = currNode;
            }
            //当前节点的下一个节点指向前一个节点
            currNode.next = preNdoe;
            //前一个节点指向当前节点
            preNdoe = currNode;
            //当前节点指向下一个节点
            currNode = nextNode;
        }
        return headNode;
    }

}
