package Z2021.a0206;

public class a01判断一个链表有没有环 {
    static public boolean checkLinkedListCycle(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    static public ListNode checkLinkedListCycle1(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = node;
                while(fast != null){
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
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode.next(listNode1);
        listNode1.next(listNode2);
        listNode2.next(listNode3);
        listNode3.next(listNode4);
        listNode4.next(listNode2);
        System.out.println(checkLinkedListCycle(listNode));
        System.out.println(checkLinkedListCycle1(listNode).val);
    }
}
