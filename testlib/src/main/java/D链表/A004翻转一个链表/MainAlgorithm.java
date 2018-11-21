package D链表.A004翻转一个链表;

import java.util.ArrayList;
import java.util.List;

import D链表.A001用数组实现一个链表.ListNote;
import D链表.A001用数组实现一个链表.MyListLink;

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
    ListNote listNote = reverseListNode(link.getListLink());
    while (listNote != null) {
      System.out.println(listNote.getData());
      listNote = listNote.next;
    }
  }

  // 指针法
  private static ListNote reverseListNode2(ListNote listNote) {
    // 声明的头指针
    ListNote head = listNote;
    // 申明一个尾指针
    ListNote tail = listNote;
    // 声明一个next指针
    ListNote next = listNote.next;
    // 计算链表的长度
    int size = 0;
    ListNote temp = listNote;
    while (temp != null) {
      size++;
      temp = temp.next;
    }
    while (size > 1) {
      // 缓存一个next
      ListNote nextNext = next.next;
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
  private static ListNote reverseListNode(ListNote listNote) {
    // 翻转一个链表
    ListNote tempNode = listNote;
    // 把链表的值都放入List集合里面
    // 通过翻转数组来翻转集合
    List<ListNote> list = new ArrayList<>();
    while (tempNode != null) {
      list.add(tempNode);
      tempNode = tempNode.next;
    }
    ListNote headNode = null;
    for (int i = list.size() - 1; i >= 0; i--) {
      if (headNode == null) {
        headNode = new ListNote();
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
