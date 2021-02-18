package E链表.A008删除节点;

import temp.ListNode;

public class DeleteNode {
    static ListNode deleteNode(ListNode head,int val){
        ListNode virtual = new ListNode(0);
        virtual.next = head;
        ListNode prev = virtual;
        ListNode curr = head;
        while (curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;

        }
        return virtual.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(deleteNode(a,3));
    }
}
