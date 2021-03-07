package temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import E链表.A001实现一个链表.ListNode;
import F树.A001求二叉树的节点数.TreeNode;

/**
 * Description: <><br>
 * Author: mxdl<br>
 * Date: 2018/11/26<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm1 {
  static class Note implements Comparable<Note> {
    int index;
    int value;

    public Note(int index, int value) {
      this.index = index;
      this.value = value;
    }

    @Override
    public int compareTo(Note o) {
      return value - o.value;
    }
  }

  public static void main(String[] args) {

    // int[] arr = {2, 17, 3, 21, 3, 12, 201, 15, 12};
    // buddleSort(arr);
    // selectSort(arr);
    // tongSort(arr);
    // System.out.println(isRepeat(arr));
    // removeRepeat(arr);

    // int[][] arr = {{2,2, 17},{3, 21,3},{12, 21, 15}};
    // int pathCount = getMinValue(arr);
    // System.out.println(pathCount);
    // 两数求和
    // int[] index = getIndex(arr);
    // System.out.println(index[0]);
    // System.out.println(index[1]);

    // createArrayList();
    // removeOushu();
    //
    // MyStack1 myStack1 = new MyStack1();
    // myStack1.push(0);
    // myStack1.push(1);
    // myStack1.push(2);
    // myStack1.push(3);
    // System.out.println(myStack1.pop());
    // System.out.println(myStack1.pop());

    // MyQueue1 myQueue1 = new MyQueue1();
    // myQueue1.push(0);
    // myQueue1.push(1);
    // myQueue1.push(2);
    // myQueue1.push(3);
    // System.out.println(myQueue1.poll());
    // System.out.println(myQueue1.poll());
    // System.out.println(myQueue1.poll());
    // System.out.println(myQueue1.poll());
    // System.out.println(myQueue1.poll());
    // System.out.println(myQueue1.poll());

    // int value = 123;
    // reverseInt(value);
    // String source = "345321aaa123abc";
    // getMaxStr(source);

    // 判断一个链表有没有环
    // ListNode listNote = new ListNode(0);
    // ListNode listNote1 = new ListNode(5);
    // ListNode listNote2 = new ListNode(9);
    // ListNode listNote3 = new ListNode(13);
    //
    // listNote.setNext(listNote1);
    // listNote1.setNext(listNote2);
    // //listNote2.setNext(listNote3);
    // //listNote3.setNext(null);
    //
    // ListNode listNote0 = new ListNode(2);
    // ListNode listNote11 = new ListNode(3);
    // ListNode listNote22 = new ListNode(10);
    // ListNode listNote33 = new ListNode(33);
    //
    // listNote0.setNext(listNote11);
    // listNote11.setNext(listNote22);
    // listNote22.setNext(listNote33);
    // listNote33.setNext(null);
    // mergeNode(listNote, listNote0);
    // reverseLinkNode(listNote);
    // checkLinkRukou(listNote);

    // 删除链表的倒数第n个节点
    // int n = 3;
    // delNote(listNote, n);
    TreeNode treeNode = new TreeNode(0);
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(1);
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode4 = new TreeNode(4);
    treeNode.setLeftNote(treeNode1);
    treeNode.setRightNote(treeNode2);

    treeNode1.setLeftNote(treeNode3);
    treeNode1.setRightNote(treeNode4);

    treeNode2.setLeftNote(treeNode4);
    treeNode2.setRightNote(treeNode3);

    // TreeNode treeNode0 = new TreeNode(0);
    // TreeNode treeNode11 = new TreeNode(1);
    // TreeNode treeNode22 = new TreeNode(2);
    // TreeNode treeNode33 = new TreeNode(3);
    // TreeNode treeNode44 = new TreeNode(4);
    // treeNode0.setLeftNote(treeNode11);
    // treeNode0.setRightNote(treeNode22);
    //
    // treeNode11.setLeftNote(treeNode33);
    // treeNode11.setRightNote(treeNode44);
    //
    // System.out.println(isSameTree(treeNode,treeNode0));

    // TreeNode treeNode5 = new TreeNode(5);
    // TreeNode treeNode6 = new TreeNode(6);


    //
    // treeNode3.setLeftNote(treeNode5);
    // treeNode5.setLeftNote(treeNode6);
    // printNode(treeNode);
    System.out.println(isDuichengTree(treeNode));
     }

  public static boolean isDuichengTree(TreeNode treeNode) {
    if (treeNode == null) {
      return true;
    }
    if (treeNode.getLeftNote().getValue() == treeNode.getRightNote().getValue()) {
      return isDuichengTree(treeNode.getLeftNote(), treeNode.getRightNote());
    } else {
      return false;
    }
  }

  public static boolean isDuichengTree(TreeNode treeNode, TreeNode treeNode1) {
    if (treeNode == null && treeNode1 == null) {
      return true;
    } else if (treeNode == null && treeNode1 != null) {
      return false;
    } else if (treeNode != null && treeNode1 == null) {
      return false;
    }
    return (treeNode.getValue() == treeNode1.getValue())
        && isSameTree(treeNode.getLeftNote(), treeNode1.getRightNote())
        && isSameTree(treeNode.getRightNote(), treeNode1.getLeftNote());
  }

  public static boolean isSameTree(TreeNode treeNode, TreeNode treeNode1) {
    if (treeNode == null && treeNode1 == null) {
      return true;
    } else if (treeNode == null && treeNode1 != null) {
      return false;
    } else if (treeNode != null && treeNode1 == null) {
      return false;
    }
    return (treeNode.getValue() == treeNode1.getValue())
        && isSameTree(treeNode.getLeftNote(), treeNode1.getLeftNote())
        && isSameTree(treeNode.getRightNote(), treeNode1.getRightNote());
  }

  public static void printNode(TreeNode treeNode) {
    if (treeNode == null) {
      return;
    }
    printNode(treeNode.getLeftNote());
    System.out.println(treeNode.getValue());
    printNode(treeNode.getRightNote());
  }

  public static int getTreeNodeCount(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    }
    return 1 + getTreeNodeCount(treeNode.getLeftNote()) + getTreeNodeCount(treeNode.getRightNote());
  }

  public static int getTreeHeight(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    }
    int left = 1 + getTreeHeight(treeNode.getLeftNote());
    int right = 1 + getTreeHeight(treeNode.getRightNote());
    return left > right ? left : right;
  }

  private static void mergeNode(ListNode listNote, ListNode listNote0) {
    ListNode newNode = new ListNode(0);
    ListNode tempNode = newNode;
    while (listNote != null && listNote0 != null) {
      if (listNote.data < listNote0.data) {
        tempNode.next = listNote;
        listNote = listNote.next;
      } else {
        tempNode.next = listNote0;
        listNote0 = listNote0.next;
      }
      tempNode = tempNode.next;
    }
    tempNode.next = listNote != null ? listNote : listNote0;
    newNode = newNode.next;
    while (newNode != null) {
      System.out.println(newNode.data);
      newNode = newNode.next;
    }
  }

  private static void delNote(ListNode listNote, int n) {
    ListNode tempNode = listNote;
    for (int i = 0; i < n + 1; i++) {
      tempNode = tempNode.next;
    }
    ListNode delNode = listNote;
    while (tempNode != null) {
      tempNode = tempNode.next;
      delNode = delNode.next;
    }
    delNode.next = delNode.next.next;
    while (listNote != null) {
      System.out.println(listNote.data);
      listNote = listNote.next;
    }
  }

  private static void reverseLinkNode(ListNode listNote) {
    ListNode head = listNote;
    ListNode tail = listNote;
    ListNode next = listNote.next;
    while (next != null) {
      ListNode nextNext = next.next;
      next.next = head;
      head = next;
      next = nextNext;
    }
    tail.next = null;
    while (head != null) {
      System.out.println(head.data);
      head = head.next;
    }
  }

  private static void checkLinkRukou(ListNode listNote) {
    ListNode slow = listNote;
    ListNode fast = listNote;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }
    if (fast == null || fast.next == null) {
      return;
    }
    slow = listNote;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    System.out.println(slow.data);
  }

  private static void getMaxStr(String source) {
    boolean[][] arr = new boolean[source.length()][source.length()];
    int maxlen = 0;
    for (int i = 0; i < source.length(); i++) {
      arr[i][i] = true;
      maxlen = 1;
    }
    for (int i = 0; i < source.length() - 1; i++) {
      if (source.charAt(i) == source.charAt(i + 1)) {
        arr[i][i + 1] = true;
      }
      maxlen = 2;
    }
    String maxstr = null;
    for (int len = 3; len < source.length(); len++) {
      for (int i = 0, j; (j = i + len - 1) < source.length(); i++) {
        // System.out.println(source.substring(i,j+1));
        if (source.charAt(i) == source.charAt(j)) {
          arr[i][j] = arr[i + 1][j - 1];
          if (arr[i][j] && maxlen < len) {
            maxstr = source.substring(i, j + 1);
            maxlen = len;
          }
        }
      }
    }
    System.out.println(maxstr);
  }

  private static void reverseInt(int value) {
    // 翻转一个整形
    int result = 0;
    while (value > 0) {
      result = result * 10 + value % 10;
      value = value / 10;
    }
    System.out.println(result);
  }

  private static void removeOushu() {
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(4);
    Iterator<Integer> iterator = arrayList.iterator();
    while (iterator.hasNext()) {
      Integer next = iterator.next();
      if (next % 2 == 0) {
        iterator.remove();
      }
    }
    for (int i = 0; i < arrayList.size(); i++) {
      System.out.println(arrayList.get(i) + "");
    }
  }

  private static void createArrayList() {
    MyArrayList1 myArrayList = new MyArrayList1();
    myArrayList.add(0);
    myArrayList.add(1);
    myArrayList.add(2);
    myArrayList.add(3);
    myArrayList.add(4);
    myArrayList.add(5);
    System.out.println(myArrayList.get(0));
    System.out.println(myArrayList.get(1));
    System.out.println(myArrayList.get(5));
  }

  private static int[] getIndex(int[] arr) {
    Note[] listNote = new Note[arr.length];
    for (int i = 0; i < arr.length; i++) {
      listNote[i] = new Note(i, arr[i]);
    }
    Arrays.sort(listNote);
    int[] result = {0, 0};
    int source = 38;
    int head = 0;
    int tail = listNote.length - 1;
    while (head < tail) {
      if ((listNote[head].value + listNote[tail].value) == source) {
        result[0] = listNote[head].index;
        result[1] = listNote[tail].index;
        break;
      } else if ((listNote[head].value + listNote[tail].value) < source) {
        head++;
      } else {
        tail--;
      }
    }
    return result;
  }

  // 有一个m*n的矩阵，左上为起点，右下为终点，现在求从起点到终点共有几条路径,求最小值
  private static int getMinValue(int[][] arr) {
    int[][] result = new int[arr.length][arr[0].length];
    result[0][0] = arr[0][0];

    for (int i = 1; i < arr[0].length; i++) {
      result[0][i] = arr[0][i] + result[0][i - 1];
    }

    for (int i = 1; i < arr.length; i++) {
      result[i][0] = arr[i][0] + result[i - 1][0];
    }
    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j < arr[0].length; j++) {
        result[i][j] = Math.min(arr[i - 1][j], arr[i][j - 1]) + arr[i][j];
      }
    }
    return result[arr.length - 1][arr[0].length - 1];
  }

  // 有一个m*n的矩阵，左上为起点，右下为终点，现在求从起点到终点共有几条路径
  private static int getPathCount(int m, int n) {
    int[][] arr = new int[m][n];
    for (int i = 0; i < arr[0].length; i++) {
      arr[0][i] = 1;
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i][0] = 1;
    }
    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j < arr[0].length; j++) {
        arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
      }
    }
    return arr[m - 1][n - 1];
  }

  private static void removeRepeat(int[] arr) {
    // 删除数组中的重复元素
    loop: for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        int k = j;
        if (arr[i] == arr[j]) {
          while (k < arr.length - 1) {
            arr[k] = arr[k + 1];
            k++;
          }
          arr = Arrays.copyOf(arr, arr.length - 1);
          i = 0;
          continue loop;
        }
      }
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  private static boolean isRepeat(int[] arr) {
    // 查找一个数据里面有没有重复元素
    HashSet<Integer> set = new HashSet();
    for (int i = 0; i < arr.length; i++) {
      if (set.contains(arr[i])) {
        return true;
      } else {
        set.add(arr[i]);
      }
    }
    return false;
  }

  // 桶排序
  private static void tongSort(int[] arr) {
    int[] arr1 = new int[21 + 1];
    for (int i = 0; i < arr.length; i++) {
      arr1[arr[i]]++;
    }
    for (int i = 0; i < arr1.length; i++) {
      int j = arr1[i];
      while (j > 0) {
        System.out.println(i);
        j--;
      }
    }
  }

  // 选择排序
  private static void selectSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          int temp = arr[j];
          arr[j] = arr[i];
          arr[i] = temp;
        }
      }
    }
  }

  // 1.冒泡排序
  private static void buddleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
}
