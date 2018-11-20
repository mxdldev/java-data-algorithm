package test.yesway.com.testlib.temp;

import java.util.HashSet;

/**
 * Description: <><br>
 * Author: gxl<br>
 * Date: 2018/11/15<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class TestTree {
  public static void main(String[] args) {
//    TreeNode myNode = new TreeNode();
//    myNode.setVal(0);
//
//    TreeNode babaNode = new TreeNode();
//    babaNode.setVal(1);
//
//    TreeNode mamaNode = new TreeNode();
//    mamaNode.setVal(2);
//
//    myNode.setLeftNote(babaNode);
//    myNode.setRightNode(mamaNode);
//
//    TreeNode yeyeNode = new TreeNode();
//    yeyeNode.setVal(3);
//
//    TreeNode nainaiNode = new TreeNode();
//    nainaiNode.setVal(4);
//
//    babaNode.setLeftNote(yeyeNode);
//    babaNode.setRightNode(nainaiNode);
//
//    // System.out.println(getTreeHeight(myNode));
//    printTreeNdoe(myNode);
//
//    TreeSet<String> treeSet = new TreeSet<>();
//    treeSet.add("aaa");
//    treeSet.add("bbb");

    int[] arr = {1, 2, 37, 12, 12, 1, 4};
    boolean repeat = isRepeat(arr);
  }

  private static boolean isRepeat(int[] arr) {
    HashSet<Integer> hashSet = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
        if(hashSet.contains(arr[i])){
          return true;
        }else{
            hashSet.add(arr[i]);
        }
    }
    return false;
  }

  // 求这个二叉树的高度
  public static int getTreeHeight(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    } else {
      int left = getTreeHeight(treeNode.getLeftNote());
      int right = getTreeHeight(treeNode.getRightNode());
      return left > right ? left + 1 : right + 1;
    }
  }

  // 求二叉树共有几个子节点
  public static int getTreeNoteNum(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    } else {
      return 1 + getTreeNoteNum(treeNode.getLeftNote()) + getTreeNoteNum(treeNode.getRightNode());
    }
  }

  // 遍历二叉树的所有节点
  public static void printTreeNdoe(TreeNode treeNode) {
    if (treeNode != null) {
      System.out.println(treeNode.val);
      printTreeNdoe(treeNode.leftNote);
      printTreeNdoe(treeNode.rightNode);
    }
  }
}
