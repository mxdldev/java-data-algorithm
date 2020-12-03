package Z2019.A003;

/**
 * Description: <ReView03ListNode><br>
 * Author:      mxdl<br>
 * Date:        2019/9/1<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class ReView03ListNode {
    //1.判断一个链表有没有后环
    public static boolean isRingListNode(ListNode listNode) {
        ListNode slow = listNode;
        ListNode fast = listNode;
        while (fast != null && fast.next != null) {//*****
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //2.找到链表的入口节点
    public static ListNode getEnterRingListNode(ListNode listNode) {
        ListNode slow = listNode;
        ListNode fast = listNode;
        boolean isRing = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isRing = true;
                break;
            }
        }
        if (!isRing) {
            return null;//*****
        }
        fast = listNode;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //3.翻转一个链表
    public static ListNode revertListNode(ListNode listNode) {
        ListNode currNode = listNode;
        ListNode preNode = null;
        ListNode headNode = null;
        while (currNode != null) {
            ListNode nextNode = currNode.next;//*****
            if (nextNode == null) {
                headNode = currNode;
            }
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        return headNode;
    }

    //4.删除链表的倒数第n个节点
    public static ListNode removeListNodeByN(ListNode listNode, int n) {
        ListNode pa = listNode;
        int i = 0;
        while (i < n) {
            pa = pa.next;
            i++;
        }
        if (pa == null) {
            return listNode.next;
        }
        ListNode pb = listNode;
        while (pa.next != null) {//*****
            pa = pa.next;
            pb = pb.next;
        }
        pb.next = pb.next.next;
        return listNode;
    }
    //5.合并两个有序链表
    public static ListNode mergeTwoListNode(ListNode pa, ListNode pb) {
        ListNode listNode = new ListNode(-1);
        ListNode headNode = listNode;//*****
        while (pa != null && pb != null) {
            if (pa.val < pb.val) {
                listNode.next = pa;
                pa = pa.next;
            } else {
                listNode.next = pb;
                pb = pb.next;
            }
            listNode = listNode.next;
        }
        listNode.next = pa != null ? pa : pb;//*****
        return headNode.next;
    }
    //6.两个链表求和
    public static ListNode sumTowListNode(ListNode pa,ListNode pb){
        ListNode currNode = new ListNode(-1);
        ListNode headNode = currNode;
        int carry = 0;
        while(pa != null && pb != null){
            int sum = carry + pa.val + pb.val;
            currNode.next = new ListNode(sum%10);
            carry = sum/10;
            pa = pa.next;
            pb = pb.next;
            currNode = currNode.next;
        }
        if(carry > 0){
            currNode.next = new ListNode(carry);
        }
        return headNode.next;
    }
    public static ListNode mergeListNode1(ListNode pa, ListNode pb) {
        ListNode currNode = new ListNode(-1);
        ListNode headNode = currNode;
        while (pa != null && pb != null) {
            if (pa.val < pb.val) {
                currNode.next = pa;
                pa = pa.next;
            } else {
                currNode.next = pb;
                pb = pb.next;
            }
            currNode = currNode.next;
        }
        currNode.next = pa != null ? pa : pb;
        return headNode.next;
    }

    public static void main(String[] args) {
//        ListNode listNode = new ListNode(0);
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//
//        listNode.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
        //listNode3.next = listNode2;

        //boolean cricleListNode = isRingListNode(listNode);
        //System.out.println(cricleListNode);
        //ListNode enterRingListNode = getEnterRingListNode(listNode);
        //System.out.println(enterRingListNode.val);
//        ListNode listNode4 = revertListNode(listNode);
//        ListNode listNode4 = removeListNodeByN(listNode, 1);
//        while (listNode4 != null) {
//            System.out.println(listNode4.val);
//            listNode4 = listNode4.next;
//        }
        ListNode listNodea = new ListNode(1);
        ListNode listNode1a = new ListNode(3);
        ListNode listNode2a = new ListNode(5);
        listNodea.next = listNode1a;
        listNode1a.next = listNode2a;


        ListNode listNodeaa = new ListNode(2);
        ListNode listNode1aa = new ListNode(4);
        ListNode listNode2aa = new ListNode(6);
        //ListNode listNode2aaa = new ListNode(7);
        listNodeaa.next = listNode1aa;
        listNode1aa.next = listNode2aa;
        //listNode2aa.next = listNode2aaa;
        ListNode listNode4 = sumTowListNode(listNodea, listNodeaa);
        while (listNode4 != null) {
            System.out.println(listNode4.val);
            listNode4 = listNode4.next;
        }


    }
}
