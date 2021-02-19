package E链表.A009设计一个链表;

public class MyLinkedList2 {
    ListNode head;
    int size;

    public MyLinkedList2() {
        head = new ListNode(-1);
        size = 0;
    }
    public int get(int index){
        if(index < 0 || index > size){
            return -1;
        }
        ListNode prev = head;
        for(int i = 0; i < index + 1; i++){
            prev = prev.next;
        }
        return prev.val;
    }
    public void addAtIndex(int index,int val){
        if(index < 0 || index > size){
            return;
        }
        size++;
        ListNode prev = head;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        ListNode curr = new ListNode(val);
        curr.next = prev.next;
        prev.next = curr;
    }
    public void addAtHead(int val){
        addAtIndex(0,val);
    }
    public void addAtTail(int val){
        addAtIndex(size,val);
    }
    public void removeAdIndex(int index){
        if(index < 0 || index > size){
            return;
        }
        size--;
        ListNode prev = head;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }
    public static void main(String[] args) {
        MyLinkedList2 myLinkedList2 = new MyLinkedList2();
        myLinkedList2.addAtIndex(0,0);
        myLinkedList2.addAtIndex(1,1);
        myLinkedList2.addAtIndex(2,2);
        /*myLinkedList2.addAtIndex(2,2);
        myLinkedList2.addAtTail(3);
        myLinkedList2.addAtTail(4);*/
       // myLinkedList2.addAtHead(-22);
//        System.out.println(myLinkedList2.toString());
//        System.out.println(myLinkedList2.get(2));
       // myLinkedList2.removeAdIndex(0);
        //myLinkedList2.removeAdIndex(0);
       /* System.out.println(myLinkedList2.toString());
        myLinkedList2.removeAdIndex(0);
        System.out.println(myLinkedList2.toString());*/
        ListNode head = myLinkedList2.head.next;
        System.out.println(head);

        ListNode prev = head;
        ListNode curr = prev.next;
        ListNode next = curr.next;
        while(next != null){
            curr.next = prev;
            prev = next;

            prev = curr;
            curr = next;
            next = next.next;
        }
        System.out.println(head);
    }

    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyLinkedList2{" +
                "head=" + head +
                '}';
    }
}
