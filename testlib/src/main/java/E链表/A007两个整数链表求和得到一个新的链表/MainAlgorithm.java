package E链表.A007两个整数链表求和得到一个新的链表;

import temp.ListNode;

/**
 * Description: <MainAlgorithm><br>
 * Author:      mxdl<br>
 * Date:        2019/8/8<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainAlgorithm {
    public static ListNode addSumListNode(ListNode l1,ListNode l2){
        //声明一个新链表来存储计算结果
        ListNode dummyNode = new ListNode(0);
        ListNode currNode = dummyNode;
        int carry = 0;//进位
        while(l1 != null && l2 != null){
            int sum = carry + l1.val + l2.val;
            currNode.next = new ListNode(sum%10);
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
            currNode = currNode.next;
        }
        if(carry > 0){
            currNode.next = new ListNode(carry);
        }
        return dummyNode.next;
    }
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(9);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode5;
        listNode5.next = listNode6;
        //123
        //499 5 1 3 1
        ListNode listNode = addSumListNode(listNode1, listNode4);
        while (listNode != null){
            System.out.println("val:"+listNode.val);
            listNode = listNode.next;
        }

    }
}
