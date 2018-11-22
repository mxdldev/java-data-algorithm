package D链表.A006合并两个排好序的链表;

import D链表.A001用数组实现一个链表.ListNode;
import D链表.A001用数组实现一个链表.MyListLink;

/**
 * Description: <合并两个排好序的链表><br>
 * Author: gxl<br>
 * Date: 2018/11/22<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {
  public static void main(String[] args) {
    MyListLink myListLink = new MyListLink();
    myListLink.addLast(0);
    myListLink.addLast(2);
    myListLink.addLast(4);

    MyListLink myListLink1 = new MyListLink();
    myListLink1.addLast(1);
    myListLink1.addLast(3);
    myListLink1.addLast(40);
    myListLink1.addLast(50);

    ListNode listNode = mergerListNode(myListLink.getListLink(), myListLink1.getListLink());
    while (listNode != null) {
      System.out.println(listNode.data);
      listNode = listNode.next;
    }
  }

  public static ListNode mergerListNode(ListNode listNode1, ListNode listNode2) {
    ListNode head = new ListNode(0);
    ListNode tail = head;
    while (listNode1 != null && listNode2 != null) {
      if (listNode1.data < listNode2.data) {
        tail.next = listNode1;
        listNode1 = listNode1.next;
      } else {
        tail.next = listNode2;
        listNode2 = listNode2.next;
      }
      tail = tail.next;
    }
    tail.next = listNode1 != null ? listNode1 : listNode2;
    return head.next;
  }
}
