package F树.A002判断两颗二叉树是否完全相同;

import F树.A001求二叉树的高节点数中序遍历.TreeNode;

/**
 * Description: <判断两颗二叉树是否完全相同><br>
 * Author: gxl<br>
 * Date: 2018/11/23<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {
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
    // ===============================
    TreeNode treeNode0 = new TreeNode(0);
    TreeNode treeNode11 = new TreeNode(11);
    TreeNode treeNode22 = new TreeNode(2);
    TreeNode treeNode33 = new TreeNode(3);
    TreeNode treeNode44 = new TreeNode(4);
    TreeNode treeNode55 = new TreeNode(5);

    treeNode0.setLeftNote(treeNode11);
    treeNode0.setRightNote(treeNode22);

    treeNode11.setLeftNote(treeNode33);
    treeNode11.setRightNote(treeNode44);

    treeNode33.setLeftNote(treeNode55);

    boolean sameTree = isSameTree(treeNode, treeNode0);
    System.out.println(sameTree);
  }
  //每个节点对应的值一样就可以
  public static boolean isSameTree(TreeNode treeNode, TreeNode treeNode1) {
    if (treeNode == null && treeNode1 == null) {
      return true;
    }
    if (treeNode != null && treeNode1 == null) {
      return false;
    }
    if (treeNode == null && treeNode1 != null) {
      return false;
    }
    return (treeNode.getValue() == treeNode1.getValue())
        && isSameTree(treeNode.getLeftNote(), treeNode1.getLeftNote())
        && isSameTree(treeNode.getRightNote(), treeNode1.getRightNote());
  }
}
