package Z2019.A003;

/**
 * Description: <ReView02ListNode><br>
 * Author:      mxdl<br>
 * Date:        2019/8/31<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class ReView02ListNode {
    //1.判断一个链表有没有环
    public static boolean isCircleListNode(ListNode listNode) {
        //申明一个慢指针
        ListNode slow = listNode;
        //申明一个快指针
        ListNode fast = listNode;

        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //2.如果链表环，找到入口节点
    public static ListNode getEnterNode(ListNode listNode) {
        ListNode slow = listNode;
        ListNode fast = listNode;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        fast = listNode;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    //3.翻转一个链表
    public static ListNode getReversLsitNode(ListNode listNode) {
        ListNode currNode = listNode;
        ListNode preNode = null;
        ListNode headNdoe = null;
        while (currNode != null) {
            ListNode next = currNode.next;
            if (next == null) {
                headNdoe = currNode;
            }
            currNode.next = preNode;
            preNode = currNode;
            currNode = next;
        }
        return headNdoe;
    }

    //4.删除链表当中的倒数第n个节点
    public static ListNode removeListNode(ListNode listNode, int n) {
        ListNode pa = listNode;
        //找到他的整数第n个节点
        int i = 0;
        while (i < n) {
            pa = pa.next;
            i++;
        }
        if (pa == null) {
            return listNode.next;
        }
        ListNode pb = listNode;
        while (pa.next != null) {
            pa = pa.next;
            pb = pb.next;
        }
        pb.next = pb.next.next;
        return listNode;
    }

    //5.合并两个有序的链表
    public static ListNode mergeListNode(ListNode pa, ListNode pb) {
        ListNode listNode = new ListNode(-1);
        ListNode headNode = listNode;
        while (pb != null && pa != null) {
            if (pa.val < pb.val) {
                listNode.next = pa;
                pa = pa.next;
            } else {
                listNode.next = pb;
                pb = pb.next;
            }
            listNode = listNode.next;
        }
        if (pb == null) {
            listNode.next = pa;
        } else {
            listNode.next = pb;
        }
        return headNode.next;
    }

    //6.两个链表求和
    public static ListNode getSumListNode(ListNode pa, ListNode pb) {
        ListNode listNode = new ListNode(-1);
        ListNode headNode = listNode;
        int carry = 0;
        while (pa != null && pb != null) {
            int sum = carry + pa.val + pb.val;
            listNode.next = new ListNode(sum%10);
            carry = sum/10;
            pa = pa.next;
            pb = pb.next;
            listNode = listNode.next;
        }
        if(carry > 0){
            listNode.next =  new ListNode(carry);
        }
        return headNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        //listNode3.next = listNode2;

//        boolean circleListNode = isCircleListNode(listNode);
//        System.out.println(circleListNode);
//
//        ListNode enterNode = getEnterNode(listNode);
//        System.out.println(enterNode.val);
//        ListNode reversLsitNode = reversListNode(listNode);
////        while (reversLsitNode != null) {
////            System.out.println(reversLsitNode.val);
////            reversLsitNode = reversLsitNode.next;
////        }
//        ListNode reversLsitNode = remodeNode(listNode, 4);
//        while (reversLsitNode != null) {
//            System.out.println(reversLsitNode.val);
//            reversLsitNode = reversLsitNode.next;
//        }


        ListNode listNodea = new ListNode(1);
        ListNode listNode1a = new ListNode(2);
        ListNode listNode2a = new ListNode(3);
        listNodea.next = listNode1a;
        listNode1a.next = listNode2a;


        ListNode listNodeaa = new ListNode(1);
        ListNode listNode1aa = new ListNode(1);
        ListNode listNode2aa = new ListNode(8);
        //ListNode listNode3aa = new ListNode(9);

        listNodeaa.next = listNode1aa;
        listNode1aa.next = listNode2aa;
        //listNode2aa.next = listNode3aa;

//        ListNode reversLsitNode = mergeListNode(listNodea, listNodeaa);
//        while (reversLsitNode != null) {
//            System.out.println(reversLsitNode.val);
//            reversLsitNode = reversLsitNode.next;
//        }
        ListNode sumListNode = getSumListNode(listNodea, listNodeaa);
        while (sumListNode != null) {
            System.out.println(sumListNode.val);
            sumListNode = sumListNode.next;
        }
    }
    public static ListNode sumListNode(ListNode pa,ListNode pb){
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

    public static ListNode reversListNode(ListNode listNode) {
        ListNode currNode = listNode;
        ListNode preNode = null;
        ListNode headNode = null;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            if (nextNode == null) {
                headNode = currNode;
            }
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        return headNode;
    }

    public static ListNode remodeNode(ListNode listNode, int n) {
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
        while (pa.next != null) {
            pa = pa.next;
            pb = pb.next;
        }
        pb.next = pb.next.next;
        return listNode;
    }
}
