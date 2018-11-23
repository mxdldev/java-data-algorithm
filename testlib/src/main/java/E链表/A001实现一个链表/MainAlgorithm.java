package E链表.A001实现一个链表;

/**
 * Description: <用数组实现一个链表><br>
 * Author: gxl<br>
 * Date: 2018/11/21<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {
  public static void main(String[] args) {
    MyListLink listLink = new MyListLink();
    listLink.addLast(1);
    listLink.addLast(3);
    listLink.addLast(2);
    listLink.addLast(11);
    ListNode headnode = listLink.getListLink();
    while (headnode != null) {
      System.out.println(headnode.data);
      headnode = headnode.next;
    }
  }
}
