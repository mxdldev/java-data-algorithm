package Z2021.a0206;

import java.util.LinkedList;

public class MyLinkedList {
    ListNode head;
    int size;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(-1);
    }

    public int get(int index) {
        if (index <= 0 || index >= size) {
            return -1;
        }
        ListNode curr = head;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addHead(int val) {
        addIndex(0, val);
    }

    public void addTail(int val) {
        addIndex(size, val);
    }

    public void addIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        ListNode perv = head;
        for (int i = 0; i <= index - 1; i++) {
            //找到要插入元素的上一个元素
            perv = perv.next;
        }
        ListNode addNode = new ListNode(val);
        ListNode next = perv.next;
        addNode.next = next;
        perv.next = addNode;
        size++;
    }

    public void removeIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode prev = head;
        for (int i = 0; i <= index - 1; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        size--;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    public ListNode getLindedList() {
        return head.next;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addTail(0);
        myLinkedList.addTail(1);
        myLinkedList.addTail(2);
        myLinkedList.addTail(3);
        myLinkedList.addTail(4);

        myLinkedList.addHead(12);
        myLinkedList.removeIndex(0);
        myLinkedList.removeIndex(3);
        System.out.println(myLinkedList.getLindedList().toString());
    }
}
