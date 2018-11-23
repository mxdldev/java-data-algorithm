package E链表.A005链表相加;

import E链表.A001实现一个链表.ListNode;
import E链表.A001实现一个链表.MyListLink;

/**
 * Description: <><br>
 * Author: gxl<br>
 * Date: 2018/11/21<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {
  public static void main(String[] args) {
    MyListLink link = new MyListLink();
    MyListLink link1 = new MyListLink();

    link.addLast(1);
    link.addLast(2);
    link.addLast(3);

    link1.addLast(4);
    link1.addLast(5);
    link1.addLast(9);

    ListNode listNote = addLink(link, link1);
    ListNode listLink2 = listNote;
    while (listLink2 != null) {
      System.out.println(listLink2.data);
      listLink2 = listLink2.next;
    }
  }

  //1.先翻转
  //2.转化为数字相加
  //3.将结果转化为字符串
  //4.将字符串转换为链表输出
  private static ListNode addLink(MyListLink link, MyListLink link1) {
    ListNode listLink = link.getListLink();
    ListNode listLink1 = link1.getListLink();

    // 翻转链表listLink; 指针翻转
    ListNode listNote = reverseLink(listLink);
    ListNode listNote1 = reverseLink(listLink1);

    StringBuilder s = new StringBuilder();
    while (listNote != null) {
      s.append(listNote.data);
      listNote = listNote.next;
    }
    StringBuilder s1 = new StringBuilder();
    while (listNote1 != null) {
      s1.append(listNote1.data);
      listNote1 = listNote1.next;
    }
    String value = String.valueOf(Integer.valueOf(s.toString()) + Integer.valueOf(s1.toString()));
    System.out.println(value);
    int i = 0;
    MyListLink myListLink = new MyListLink();
    while (i < value.length()) {
      myListLink.addLast(Integer.valueOf(String.valueOf(value.charAt(i))));
      i++;
    }

    return myListLink.getListLink();
  }

  private static ListNode reverseLink(ListNode listLink) {
    ListNode first = listLink;
    ListNode last = listLink;
    ListNode next = listLink.next;
    while (next != null) {
      ListNode temp = next.next;
      next.setNext(first);// 翻转节点
      first = next;// 头指针移位
      next = temp;// next节点移动位置
    }
    last.setNext(null);// 断链
    return first;
  }
}
