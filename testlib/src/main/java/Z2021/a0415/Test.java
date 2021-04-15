package Z2021.a0415;


import Z2019.A002.ListNode;

public class Test {
    static ListNode reverseListNode(ListNode head) {
        ListNode prev = null;
        try {
            prev = null;
            ListNode curr = head;
            ListNode temp = null;
            int i = 0;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;

                if(temp != null && curr == temp.next){
                    break;
                }
                if(temp == null){
                    temp = head;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode0;

        ListNode o = reverseListNode(listNode0);
        System.out.println(o);
    }
}
