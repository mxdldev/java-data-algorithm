package D链表.A002检查链表有没有环;

import java.util.HashSet;
import D链表.A001用数组实现一个链表.ListNote;

/**
 * Description: <检查链表有没有环><br>
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
    boolean loop = checkLoop(listNote);
    System.out.println(loop);
  }

  // 计数法
  public static boolean checkLoop1(ListNote listNote) {
    HashSet<ListNote> hashSet = new HashSet<>();
    ListNote temp = listNote;
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
  private static boolean checkLoop(ListNote listNote) {
    ListNote slow = listNote;
    ListNote fast = listNote;
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
