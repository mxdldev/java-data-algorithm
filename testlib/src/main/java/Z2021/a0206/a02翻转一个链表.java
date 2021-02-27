package Z2021.a0206;

import java.util.List;

public class a02翻转一个链表 {
    static ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null){
            //断链并缓存
            ListNode next = curr.next;
            //翻转
            curr.next = prev;
            //回翻转
            prev = curr;
            //再回翻
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode.next(listNode1);
        listNode1.next(listNode2);
        listNode2.next(listNode3);
        listNode3.next(listNode4);

        System.out.println(reverse(listNode).toString());
    }
}
