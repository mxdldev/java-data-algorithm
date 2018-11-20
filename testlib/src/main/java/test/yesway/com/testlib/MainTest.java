package test.yesway.com.testlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * Description: <><br>
 * Author: gxl<br>
 * Date: 2018/11/19<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainTest {
  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(0);
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode5 = new TreeNode(5);

    treeNode.setLeftNote(treeNode1);
    treeNode.setRightNote(treeNode2);

    treeNode1.setLeftNote(treeNode3);
    treeNode1.setRightNote(treeNode4);

    treeNode3.setLeftNote(treeNode5);

    System.out.println(getTreeHeight(treeNode));
    System.out.println(getTreeNodeCount(treeNode));
  }

  // 求这个二叉树的高
  public static int getTreeHeight(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    } else {
      int leftHeight = 1 + getTreeHeight(treeNode.getLeftNote());
      int rightHeight = 1 + getTreeHeight(treeNode.getRightNote());
      if (leftHeight > rightHeight) {
        return leftHeight;
      } else {
        return rightHeight;
      }
    }
  }

  // 求这个二叉树的高
  public static void printTreeNote(TreeNode treeNode) {
    if (treeNode == null) {
      return;
    } else {
      System.out.println(treeNode.getValue());
      printTreeNote(treeNode.getLeftNote());
      printTreeNote(treeNode.getRightNote());
    }
  }

  // 求二叉树节点的个数
  public static int getTreeNodeCount(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    } else {
      return 1 + getTreeNodeCount(treeNode.getLeftNote())
          + getTreeNodeCount(treeNode.getRightNote());
    }
  }
  //翻转一个链表：指针法
  private static ListNote reverseListNode2(ListNote listNote) {
    // 声明的头指针
    ListNote head = listNote;
    // 申明一个尾指针
    ListNote tail = listNote;
    // 声明一个next指针
    ListNote next = listNote.next;
    // 计算链表的长度
    int size = 0;
    ListNote temp = listNote;
    while (temp != null) {
      size++;
      temp = temp.next;
    }
    while (size > 1) {
      // 缓存一个next
      ListNote nextNext = next.next;
      // 更改next的next指针
      next.next = head;// 反向了
      // 移动head指针的指向
      head = next;
      // 移动next指针的指向
      next = nextNext;
      size--;
    }
    // 此时链表有环，干掉环
    tail.next = null;
    return head;
  }
  //翻转一个链表：数组法
  private static ListNote reverseListNode(ListNote listNote) {
    // 翻转一个链表
    ListNote tempNode = listNote;
    // 把链表的值都放入List集合里面
    // 通过翻转数组来翻转集合
    List<ListNote> list = new ArrayList<>();
    while (tempNode != null) {
      list.add(tempNode);
      tempNode = tempNode.next;
    }
    ListNote headNode = null;
    for (int i = list.size() - 1; i >= 0; i--) {
      if (headNode == null) {
        headNode = new ListNote();
        headNode = list.get(i);
        headNode.next = list.get(i - 1);
      } else {
        if (i == 0) {
          list.get(i).next = null;
        } else {
          list.get(i).next = list.get(i - 1);
        }
      }
    }
    return headNode;
  }
  //查找有环链表的入口节点
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

  // 判断一个链表有没有环:差速发
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
  //删除集合中的偶数元素
  private static void removeEvenNumber(ArrayList<Integer> myArrayList) {
    Iterator<Integer> iterator = myArrayList.iterator();
    while (iterator.hasNext()) {
      Integer next = iterator.next();
      if (next % 2 == 0) {
        iterator.remove();
      }
    }
  }

  // 查找一个数组里面有没有重复元素，如果有则删除重复元素
  private static int[] removeRepeat(int[] arr) {
    // 取出第一个元素和剩余的其他元素进行对比
    // 一旦发现相等，则后面的元素都往前移动一个，移动完毕数组
    loop: for (int i = 0; i < arr.length; i++) {
      for (int k = i + 1; k < arr.length; k++) {
        // 如果相等则后面的元素同意往前移动
        if (arr[i] == arr[k]) {
          int head = k;
          while (head < arr.length - 1) {
            arr[head] = arr[head + 1];
            head++;
          }
          // 对数组进行压缩处理
          arr = Arrays.copyOf(arr, arr.length - 1);
          i = 0;
          // 压缩完毕，重头开始执行
          continue loop;
        }
      }
    }
    return arr;
  }

  // 查找一个数组里面有没有重复元素
  private static boolean checkRepeat(int[] arr) {
    // 1.声明一个散列表表
    // 2.遍历这个数组
    // 3.对遍历的元素依次进行判断，如果散列表里面没有就往散列表里面塞，有就直接退出了
    HashSet<Integer> hashSet = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      if (hashSet.contains(arr[i])) {
        return true;
      } else {
        hashSet.add(arr[i]);
      }
    }
    return false;
  }

  // 桶排序，声明一个以 最大元素+1 为长度的数组，遍历原数组，桶数组计数
  private static void sortBucket(int[] arr) {
    int[] arr1 = new int[100 + 1];
    for (int i = 0; i < arr.length; i++) {
      arr1[arr[i]]++;
    }
    for (int i = 0; i < arr1.length; i++) {
      int count = arr1[i];
      while (count > 0) {
        System.out.println(i);
        count--;
      }
    }
  }

  // 选择排序，选择第一个元素和剩下的n-1个比较
  private static void sortChange(int[] arr) {
    // 第一轮确定第一个元素，第二轮确定第二个元素
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        // 选择第一i个元素和剩余的元素进行比较
        if (arr[i] > arr[j]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }

  // 冒泡排序：两个循环，通过两两相比，进行排序
  private static void sortBubbling(int[] arr) {
    // 第一轮确定最后一个，第二轮确定倒数第二个...
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        // 两两相比，就像鱼吐水泡一样...
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
}
