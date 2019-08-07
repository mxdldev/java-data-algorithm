package temp;

import java.util.List;

/**
 * Description: <Test20190805_ListNode><br>
 * Author: mxdl<br>
 * Date: 2019/8/5<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class Test20190805_ListNode {
  // 1.判断链表有没有环
  public static boolean isListNodeRing(ListNode listNode) {
    ListNode slowNode = listNode;
    ListNode fastNode = listNode;
    while (fastNode.next != null) {
      slowNode = slowNode.next;
      fastNode = fastNode.next.next;
      if (slowNode == fastNode) {
        return true;
      }
    }
    return false;
  }

  // 2.判断链表有没有环，有环则找到链表的入口节点
  public static ListNode getRinigEntry(ListNode listNode) {
    ListNode slowNode = listNode;
    ListNode fastNode = listNode;
    boolean isring = false;
    while (fastNode.next != null) {
      slowNode = slowNode.next;
      fastNode = fastNode.next.next;
      if (slowNode == fastNode) {
        isring = true;
        break;
      }
    }
    if (!isring) {
      return null;
    }
    fastNode = listNode;
    while (slowNode != fastNode) {
      slowNode = slowNode.next;
      fastNode = fastNode.next;
    }
    return fastNode;
  }

  // 3.翻转一个链表
  public static ListNode reversListNode(ListNode listNode) {
    ListNode reversNode = null;
    ListNode currNode = listNode;
    ListNode preNdoe = null;
    while (currNode != null) {
      ListNode nextNode = currNode.next;
      if (nextNode == null) {
        reversNode = currNode;
      }
      currNode.next = preNdoe;
      preNdoe = currNode;
      currNode = nextNode;
    }
    return reversNode;
  }

  // 4.删除链表的倒数第n个节点
  public static ListNode deleteListNode(ListNode listNode, int n) {
    ListNode pa = listNode;
    ListNode pb = listNode;
    int i = 1;
    while (i <= n) {
      pa = pa.next;
      i++;
    }
    while (pa.next != null) {
      pa = pa.next;
      pb = pb.next;
    }
    pb.next = pb.next.next;
    return listNode;
  }

  // 5.合并两个有序链表
  public static ListNode mergeListNode(ListNode pa, ListNode pb) {
    ListNode listNode = new ListNode(0);
    ListNode currNode = listNode;
    while (pa != null && pb != null) {
      if (pa.val > pb.val) {
        currNode.next = pb;
        pb = pb.next;
      } else {
        currNode.next = pa;
        pa = pa.next;
      }
      currNode = currNode.next;
    }
    currNode.next = pa != null ? pa : pb;
    return listNode.next;
  }

  public static void main(String[] args) {
    ListNode listNode = new ListNode(1);
    ListNode listNode1 = new ListNode(3);
    ListNode listNod2 = new ListNode(5);

    ListNode listNode3 = new ListNode(2);
    ListNode listNode4 = new ListNode(4);
    ListNode listNode5 = new ListNode(6);
    listNode.next = listNode1;
    listNode1.next = listNod2;

    listNode3.next = listNode4;
    listNode4.next = listNode5;
    // listNode4.next = listNode3;
    // boolean isRing = isListNodeRing(listNode);
    // System.out.println("isRing:"+isRing);

    // ListNode rinigEntry = getRinigEntry(listNode);
    // System.out.println("entry:"+(rinigEntry != null ? rinigEntry.val:" is null"));

    // ListNode reversNode = reversListNode(listNode);
    // while(reversNode != null){
    // System.out.println("val:"+reversNode.val);
    // reversNode = reversNode.next;
    // }
    ListNode reversNode = mergeListNode(listNode, listNode3);
    while (reversNode != null) {
      System.out.println("val:" + reversNode.val);
      reversNode = reversNode.next;
    }

  }
}
