package E链表.A009设计一个链表;

public class MyLinkedList {
    ListNode head;
    public int get(int targetIndex){
        ListNode curr = head;
        int nodeIndex = 0;
        while(head != null){
            if(nodeIndex++ == targetIndex){
                return curr.val;
            }
            curr = curr.next;
        }
        return -1;
    }
    public void addAtHead(int val){
        if(head == null){
            head = new ListNode(val);
        }else{
            ListNode currNode = new ListNode(val);
            currNode.next = head;
            head = currNode;
        }
    }
    public void addAtTail(int val){
        if(head == null){
            head = new ListNode(val);
        }else{
            ListNode currNode = head;
            while (currNode != null){
                if(currNode.next == null){
                    currNode.next = new ListNode(val);
                    break;
                }
                currNode = currNode.next;
            }
        }
    }
    public void addAtIndex(int val,int index){
        if(head == null){
            head = new ListNode(val);
        }else{
            ListNode virtual = new ListNode(-1);
            virtual.next = head;

            ListNode prevNode = virtual;
            ListNode currNode = virtual.next;
            int nodeIndex = 0;
            while (currNode != null){
                if(nodeIndex++ == index){
                    ListNode listNode = new ListNode(val);
                    listNode.next = currNode;
                    prevNode.next = listNode;
                    break;
                }
                prevNode = currNode;
                currNode = currNode.next;
            }
            head = virtual.next;
        }
    }
    public boolean deleteAtIndex(int index){
        if(head == null){
            return false;
        }
        ListNode virtual = new ListNode(-1);
        virtual.next = head;

        ListNode prevNode = virtual;
        ListNode currNode = virtual.next;
        int nodeIndex = 0;
        boolean del = false;
        while (currNode != null){
            if(nodeIndex++ == index){
                prevNode.next = currNode.next;
                del = true;
                break;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        head = virtual.next;
        return del;
    }
    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                '}';
    }

    class ListNode{
        int val;
        public ListNode(int val) {
            this.val = val;
        }
        ListNode next;

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtTail(0);
        linkedList.addAtTail(1);
        linkedList.addAtTail(3);
        linkedList.addAtTail(4);
        System.out.println(linkedList.toString());
        linkedList.addAtIndex(2,2);
        System.out.println(linkedList.toString());
        linkedList.deleteAtIndex(4);
        System.out.println(linkedList.toString());

    }
}
