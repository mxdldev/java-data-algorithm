package I2019.A002;

import java.util.List;

/**
 * Description: <MainTest><br>
 * Author: mxdl<br>
 * Date: 2019/8/2<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainTest {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    ListNode l2 = new ListNode(3);
    ListNode l3 = new ListNode(4);

    l1.next = l2;
    l2.next = l3;

    ListNode l11 = new ListNode(1);
    ListNode l21 = new ListNode(2);
    ListNode l31 = new ListNode(30);

    l11.next = l21;
    l21.next = l31;

    ListNode listNode = addTowNumbers(l1, l11);
    ListNode curr = listNode;
    while (curr != null) {
      System.out.println("val:" + curr.val());
      curr = curr.next;
    }

  }

  public static ListNode addTowNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode currHead = head;
    ListNode p = l1;
    ListNode q = l2;
    int carry = 0;
    while (p != null || q != null) {
      int x = p.val;
      int y = q.val;
      int sum = carry + x + y;
      carry = sum / 10;
      currHead.next = new ListNode(sum % 10);
      currHead = currHead.next;
      if (p != null) {
        p = p.next;
      }
      if (q != null) {
        q = q.next;
      }
    }
    if (carry > 0) {
      currHead.next = new ListNode(carry);
    }
    return head.next;
  }
}
