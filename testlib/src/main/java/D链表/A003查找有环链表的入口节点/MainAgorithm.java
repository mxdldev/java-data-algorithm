package D链表.A003查找有环链表的入口节点;

import D链表.A001用数组实现一个链表.ListNote;

/**
 * Description: <查找有环链表的入口节点><br>
 * Author: gxl<br>
 * Date: 2018/11/21<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAgorithm {
  public static void main(String[] args) {
    ListNote listNote = new ListNote(0);
    ListNote listNote1 = new ListNote(1);
    ListNote listNote2 = new ListNote(2);
    ListNote listNote3 = new ListNote(3);

    listNote.setNext(listNote1);
    listNote1.setNext(listNote2);
    listNote2.setNext(listNote3);
    listNote3.setNext(listNote1);
    ListNote firstNode = getFirstNode(listNote);
    System.out.println(firstNode.data);
  }

  // 查找有环链表的入口节点
  private static ListNote getFirstNode(ListNote listNote) {
    // 如果链表有环，请找到其入口节点
    ListNote slow = listNote;
    ListNote fast = listNote;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }
    if (fast == null || fast.next == null) {
      return null;
    }
    // 重置slow指针
    slow = listNote;
    // 如果没有相遇则继续往下走
    // 定理:从头结点到入口节点的距离等于从相遇节点到入口节点的距离*****
    // 因为：2(m + x) = m + x + y + x;
    // 所以：2m+2x = m + 2x + y
    // 得出：m = y;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}
