package test.yesway.com.testlib.temp;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.TreeSet;

public class MyClass {


  public static void main(String[] arg) {
    ArrayDeque arrayDeque = new ArrayDeque<>();

    // int[] arr = {1,2};
    // arr = Arrays.copyOf(arr, 5);
    // System.out.println(Arrays.toString(arr));
    //
    // HashSet hashSet = new HashSet();
    // //TreeSet treeSet = new TreeSet();
    // //treeSet.add("afa");
    // hashSet.add("aaa");
    // ArrayList arrayList = new ArrayList();
    // arrayList.contains("");
    // hashSet.contains("");
    // System.out.println(Arrays.toString(arr1));
    // int[] arr = {1,2,3,3,1,12,23,12,2,1};
    // int[] arr = {1,2,1,1,1,3,3,2};
    // int[][][] arr1 = new int[][][]{{{1},{2},{3}},{{1}}};
    // arr = removeArrRepeat(arr);
    // ArrayList arrayList = new ArrayList();
    // arrayList.add("afa");
    // // arr = Arrays.copyOf(arr, 1);
    // System.out.println(Arrays.toString(arr));
    //

    // arr = Solution.removeDuplicates(arr);
    // System.out.println(Arrays.toString(arr));
    // Set<Integer> set = new HashSet();
    // Integer[] integers = arrayRemoveRepeat(arr);
    // System.out.println(Arrays.toString(integers));
    ListNode node0 = new ListNode(0);
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    node0.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node2;
    System.out.println(isCircle(node0));
    //TreeNode treeNode = sortedListToBST(node0);
    //System.out.println("ok");
    //
    // // boolean cycle = Solution.hasCycle(node0);
    // // System.out.println("list:" + cycle);
    // ListNode listNode = detectCircle(node0);
    // System.out.println(listNode != null ? listNode.toString() : null);
    // boolean cycle1 = Solution.hasCircle(node0);
    // System.out.println("list1:" + cycle1);
    // int a = 4;
    // loop:for(int i = 0; i < 12; i++){
    // b: System.out.println("");
    // continue ;
    // }


  }

  public static TreeNode sortedListToBST(ListNode head) {
    // 如果链表为空就直接返回null
    if (head == null) {
      return null;
    }

    // 链表只有一个结点
    if (head.next == null) {
      return new TreeNode(head.val);
    }

    // 快速移动结点，每次移动两个位置
    ListNode fast = head.next.next;
    // 记录中间结点
    ListNode mid = head;
    // 找中间结点
    while (fast != null && fast.next != null) {
      mid = mid.next;
      fast = fast.next.next;
    }

    // 以中间结点的下一个结点作为根结点
    TreeNode root = new TreeNode(mid.next.val);
    // 构建右子树
    root.rightNode = sortedListToBST(mid.next.next);
    // 记录链表要断开的点
    ListNode midNext = mid.next;
    // 断开单链表（会破坏原来单链表的结构）
    mid.next = null;
    // 构建左子树
    root.leftNote = sortedListToBST(head);
    // 重新将链表接好
    mid.next = midNext;
    // 返回结果
    return root;
  }

  private static int[] removeArrRepeat(int[] arr) {
    loop: for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        // 如果相等了，那么就把后面的元素往前移动
        if (arr[i] == arr[j]) {
          for (int k = j; k < arr.length - 1; k++) {
            arr[k] = arr[k + 1];
          }
          // 挪动完毕之后给数组重新赋值
          arr = Arrays.copyOf(arr, arr.length - 1);
          i = -1;
          continue loop;// 重新开始查找
        }
      }
    }
    return arr;
  }

  private static Integer[] arrayRemoveRepeat(int[] arr) {
    // LinkedHashSet<Integer> linkedList = new LinkedHashSet();//去重复，有序
    // HashSet<Integer> linkedList = new HashSet();//去重复，无序
    TreeSet<Integer> linkedList = new TreeSet();// 去重复，排顺
    for (int i = 0; i < arr.length; i++) {
      linkedList.add(arr[i]);
    }
    Integer[] a = new Integer[linkedList.size()];
    return linkedList.toArray(a);
  }

  /**
   * <h1>判断一个链表是否有环</h1>
   * <li>1.设置两个指针（fast，slow），都指向链表头，slow每次向前挪动一步，fast每次向前挪动两步</li>
   * <li>2.fast肯定先进入环，slow后进入环，进入环之后，fast和slow必然相遇</li>
   * <li>3.如果fast为null，或者fast.next为null则为无环链表</li>
   * 
   * @param head
   * @return
   */
  private static boolean isCircle(ListNode head) {
    ListNode slowNote = head;// 慢指针赋值
    ListNode fastNote = head;// 快指针赋值

    // 如果没有环在这里就退出了
    while (fastNote != null && fastNote.next != null) {
      slowNote = slowNote.next;// 每次挪动一步，后进入环
      fastNote = fastNote.next.next;// 每次挪动两步，先进入环
      // 如果有环则两个指针必然相遇，相遇后退出
      if (slowNote == fastNote) {
        System.out.println("相遇了：node，"+fastNote.val);
        break;
      }
    }
    return !(fastNote == null || fastNote.next == null);
  }


  private static ListNode detectCircle(ListNode head) {
    ListNode slowNote = head;// 慢指针赋值
    ListNode fastNote = head;// 快指针赋值

    // 如果没有环在这里就退出了
    while (fastNote != null && fastNote.next != null) {
      slowNote = slowNote.next;// 每次挪动一步，后进入环
      fastNote = fastNote.next.next;// 每次挪动两步，先进入环
      // 如果有环则两个指针必然相遇，相遇后退出
      if (slowNote == fastNote) {
        break;
      }
    }
    if (fastNote == null || fastNote.next == null) {
      return null;
    }
    slowNote = head;
    while (slowNote != fastNote) {
      slowNote = slowNote.next;
      fastNote = fastNote.next;
    }
    return slowNote;
  }
}
