package E链表.A001实现一个链表;

/**
 * Description: <><br>
 * Author: mxdl<br>
 * Date: 2018/11/19<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class ListNode {
  public int data;
  public ListNode next;

  public ListNode(int val) {
    this.data = val;
  }

  public ListNode() {
    this.data = data;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public ListNode getNext() {
    return next;
  }
}
