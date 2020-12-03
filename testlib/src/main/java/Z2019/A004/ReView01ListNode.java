package Z2019.A004;

import temp.ListNode;

/**
 * Description: <ReView01ListNode><br>
 * Author: mxdl<br>
 * Date: 2019/9/2<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class ReView01ListNode {
  // 1.判断一个链表是否有环
  public static boolean isRingListNote(ListNode listNode) {
    ListNode slowNode = listNode;
    ListNode fastNode = listNode;
    while (fastNode != null && fastNode.next != null) {
      slowNode = slowNode.next;
      fastNode = fastNode.next.next;
      if (slowNode == fastNode) {
        return true;
      }
    }
    return false;
  }

  // 2.找到有环链表的入口节点
  public static ListNode getEnterNodeListNode(ListNode listNode) {
    ListNode slowNode = listNode;
    ListNode fastNode = listNode;
    boolean isRing = false;
    while (fastNode != null && fastNode.next != null) {
      slowNode = slowNode.next;
      fastNode = fastNode.next.next;
      if (slowNode == fastNode) {
        isRing = true;
        break;
      }
    }
    if (!isRing) {
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
  public static ListNode revertListNode(ListNode listNode) {
    ListNode currNode = listNode;
    ListNode perNode = null;
    ListNode headNode = null;
    while (currNode != null) {
      ListNode nextNode = currNode.next;
      if (nextNode == null) {
        headNode = currNode;
      }
      currNode.next = perNode;
      perNode = currNode;
      currNode = nextNode;
    }
    return headNode;
  }

  // 4.删除链表的到输入第n个节点
  public static ListNode removeNodeByN(ListNode listNode, int n) {
    ListNode pa = listNode;
    int i = 0;
    while (i < n) {
      pa = pa.next;
      i++;
    }
    if (pa == null) {
      return listNode.next;// *****
    }
    ListNode pb = listNode;
    while (pa.next != null) { // *****
      pa = pa.next;
      pb = pb.next;
    }
    pb.next = pb.next.next;
    return listNode;
  }

  // 5.合并两个有序的链表
  public static ListNode mergeListNode(ListNode pa, ListNode pb) {
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

  // 6.两量表求和
  public static ListNode sumTwoListNode(ListNode pa, ListNode pb) {
    ListNode currNode = new ListNode(-1);
    ListNode headNode = currNode;
    int carry = 0;
    while (pa != null && pb != null) {
      int sum = carry + pa.val + pb.val;
      currNode.next = new ListNode(sum % 10);
      carry = sum / 10;
      pa = pa.next;
      pb = pb.next;
      currNode = currNode.next;
    }
    if (carry > 0) {
      currNode.next = new ListNode(carry);
    }
    return headNode.next;
  }

  public static void main(String[] args) {
    ListNode listNode = new ListNode(0);
    ListNode listNode1 = new ListNode(2);
    ListNode listNode2 = new ListNode(4);
    ListNode listNode3 = new ListNode(6);

    ListNode listNodea = new ListNode(1);
    ListNode listNode1a = new ListNode(3);
    ListNode listNode2a = new ListNode(5);
    ListNode listNode3a = new ListNode(7);


    listNode.next = listNode1;
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    // listNode3.next = listNode2;

    listNodea.next = listNode1a;
    listNode1a.next = listNode2a;
    listNode2a.next = listNode3a;
    // listNode3a.next = listNode2a;


    // boolean isring = isRingListNote(listNode);
    // System.out.println("isRing:" + isring);

    // ListNode enterNodeListNode = getEnterNodeListNode(listNode);
    // System.out.println(enterNodeListNode != null ? enterNodeListNode.val : "null");

    // ListNode listNode4 = revertListNode(listNode);
    // while(listNode4 != null){
    // System.out.println(listNode4.val);
    // listNode4 = listNode4.next;
    // }
    // ListNode listNode4 = removeNodeByN(listNode, 4);
    // while (listNode4 != null) {
    // System.out.println(listNode4.val);
    // listNode4 = listNode4.next;
    // }
    // ListNode listNode4 = mergeListNode(listNode, listNodea);
    // while (listNode4 != null) {
    // System.out.println(listNode4.val);
    // listNode4 = listNode4.next;
    // }
    ListNode listNode4 = sumTwoListNode(listNode, listNodea);
    while (listNode4 != null) {
      System.out.println(listNode4.val);
      listNode4 = listNode4.next;
    }
  }
}
