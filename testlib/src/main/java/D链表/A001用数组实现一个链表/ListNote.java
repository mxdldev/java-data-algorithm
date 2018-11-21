package D链表.A001用数组实现一个链表;

/**
 * Description: <><br>
 * Author: gxl<br>
 * Date: 2018/11/19<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class ListNote {
  public int data;
  public ListNote next;

  public ListNote(int val) {
    this.data = val;
  }

  public ListNote() {
    this.data = data;
  }

  public void setNext(ListNote next) {
    this.next = next;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public ListNote getNext() {
    return next;
  }
}
