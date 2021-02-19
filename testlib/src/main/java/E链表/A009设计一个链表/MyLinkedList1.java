package E链表.A009设计一个链表;



class MyLinkedList1 {
    int size;
    ListNode head;
    public MyLinkedList1() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode curr = head;
        for(int i = 0; i < index + 1; ++i) curr = curr.next;
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        ++size;
        ListNode pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        ListNode pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;
        pred.next = pred.next.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
