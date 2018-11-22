package D链表.A001用数组实现一个链表;

/**
 * Description: <用数组实现一个链表><br>
 * Author: gxl<br>
 * Date: 2018/11/20<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MyListLink {
  private ListNode first;
  private ListNode last;
  private int size;

  public void addLast(int value) {
    ListNode listNote = new ListNode();
    listNote.setData(value);
    if (first == null) {
      first = listNote;
    } else {
      last.setNext(listNote);
    }
    last = listNote;
    size++;
  }

  public ListNode getListLink() {
    return first;
  }
}
