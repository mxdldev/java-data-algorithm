package E链表.A004翻转一个链表;

import java.util.ArrayList;
import java.util.List;

import E链表.A001实现一个链表.ListNode;
import E链表.A001实现一个链表.MyListLink;

/**
 * Description: <翻转一个链表><br>
 * Author: gxl<br>
 * Date: 2018/11/21<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {
  public static void main(String[] args) {
    MyListLink link = new MyListLink();
    link.addLast(0);
    link.addLast(1);
    link.addLast(3);
    link.addLast(6);
    ListNode listNote = reverseListNode(link.getListLink());
    while (listNote != null) {
      System.out.println(listNote.getData());
      listNote = listNote.next;
    }
  }

  // 指针法
  private static ListNode reverseListNode2(ListNode listNote) {
    // 声明的头指针
    ListNode head = listNote;
    // 申明一个尾指针
    ListNode tail = listNote;
    // 声明一个next指针
    ListNode next = listNote.next;
    // 计算链表的长度
    int size = 0;
    ListNode temp = listNote;
    while (temp != null) {
      size++;
      temp = temp.next;
    }
    while (size > 1) {
      // 缓存一个next
      ListNode nextNext = next.next;
      // 更改next的next指针
      next.next = head;// 反向了
      // 移动head指针的指向
      head = next;
      // 移动next指针的指向
      next = nextNext;
      size--;
    }
    // 此时链表有环，干掉环
    tail.next = null;
    return head;
  }

  // 数组法
  private static ListNode reverseListNode(ListNode listNote) {
    // 翻转一个链表
    ListNode tempNode = listNote;
    // 把链表的值都放入List集合里面
    // 通过翻转数组来翻转集合
    List<ListNode> list = new ArrayList<>();
    while (tempNode != null) {
      list.add(tempNode);
      tempNode = tempNode.next;
    }
    ListNode headNode = null;
    for (int i = list.size() - 1; i >= 0; i--) {
      if (headNode == null) {
        headNode = new ListNode();
        headNode = list.get(i);
        headNode.next = list.get(i - 1);
      } else {
        if (i == 0) {
          list.get(i).next = null;
        } else {
          list.get(i).next = list.get(i - 1);
        }
      }
    }
    return headNode;
  }
}
