package E链表.A002检查链表有没有环;

import java.util.HashSet;
import E链表.A001实现一个链表.ListNode;

/**
 * Description: <检查链表有没有环><br>
 * Author: mxdl<br>
 * Date: 2018/11/21<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAgorithm {
  public static void main(String[] args) {
    ListNode listNote = new ListNode(0);
    ListNode listNote1 = new ListNode(1);
    ListNode listNote2 = new ListNode(2);
    ListNode listNote3 = new ListNode(3);

    listNote.setNext(listNote1);
    listNote1.setNext(listNote2);
    listNote2.setNext(listNote3);
    listNote3.setNext(listNote1);
    boolean loop = checkLoop(listNote);
    System.out.println(loop);
  }

  // 计数法
  public static boolean checkLoop1(ListNode listNote) {
    HashSet<ListNode> hashSet = new HashSet<>();
    ListNode temp = listNote;
    while (temp != null) {
      if (hashSet.contains(temp)) {
        return true;
      } else {
        hashSet.add(temp);
      }
      temp = temp.next;
    }
    return false;
  }

  // 差速发
  private static boolean checkLoop(ListNode listNote) {
    ListNode slow = listNote;
    ListNode fast = listNote;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      // 只要有环必然会相遇
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }
}
