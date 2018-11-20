package test.yesway.com.testlib.temp;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: <><br>
 * Author: gxl<br>
 * Date: 2018/11/15<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class TestLink {
  public static void main(String[] arg) {
    ListNode node0 = new ListNode(0);
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    node0.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;


     ListNode curr2Node = reverseListNode2(node0);
     while (curr2Node != null){
     System.out.println("value："+curr2Node.val);
     curr2Node = curr2Node.next;
     }
  }

  private static ListNode reverseListNode2(ListNode node0) {
    // 通过翻转指针来翻转链表
    // 给头节点赋值
    ListNode first = node0;
    // 给尾节点赋值
    ListNode last = node0;
    // 给Next节点赋值
    ListNode next = node0.next;
    // 计算链表的长度
    ListNode temp = node0;
    int size = 0;
    while (temp != null) {
      size++;
      temp = temp.next;
    }
    // 遍历链表，交换指针
    for (int i = 0; i < size - 1; i++) {
      // 取出下下个节点
      ListNode nextNext = next.next;
      // 改变next的next节点
      next.next = first;
      // 头节点重新赋值
      first = next;
      // next节点重新赋值
      next = nextNext;
    }
    // 给last节点的next重新fuzh
    last.next = null;

    return first;
  }

  // 通过指针翻转
  private static ListNode reverseListNode(ListNode node0) {
    ListNode first = node0;// 头节点赋值
    ListNode last = node0;// 尾节点赋值
    ListNode next = node0.next;// 取出下一个节点
    int size = 0;
    ListNode tempNode = node0;
    while (tempNode != null) {
      size++;
      tempNode = tempNode.next;
    }
    for (int i = 0; i < size - 1; i++) {
      ListNode nextNext = next.next;// 取出下下个节点
      next.next = first;// 节点交换位置
      first = next;// 头节点变了重新赋值
      next = nextNext;// next节点变了重新赋值
    }
    last.next = null;// 尾结点next赋值为null
    return first;
  }

  // 通过数组翻转
  private static ListNode reverseListNode1(ListNode node0) {
    List<ListNode> list = new ArrayList();
    ListNode currNode = node0;
    // 将原链表的数据，赋值到新的集合
    while (currNode != null) {
      list.add(currNode);
      currNode = currNode.next;
    }
    // 通过下标对集合进行翻转，并存入新的链表
    ListNode headNode = null;
    for (int i = list.size() - 1; i >= 0; i--) {
      // 头结点赋初值
      if (headNode == null) {
        headNode = list.get(i);
        headNode.next = list.get(i - 1);
      } else {
        if (i == 0) {
          // 尾节点next赋值为null
          list.get(i).next = null;
        } else {
          // 其他节点赋值
          list.get(i).next = list.get(i - 1);
        }

      }
    }
    return headNode;
  }
}
