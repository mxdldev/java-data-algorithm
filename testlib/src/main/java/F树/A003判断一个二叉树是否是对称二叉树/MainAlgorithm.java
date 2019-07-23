package F树.A003判断一个二叉树是否是对称二叉树;

import F树.A001求二叉树的高节点数中序遍历.TreeNode;

/**
 * Description: <一个二叉树是否是对称二叉树><br>
 * Author: mxdl<br>
 * Date: 2018/11/23<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {
  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(0);
    TreeNode treeNode1 = new TreeNode(10);
    TreeNode treeNode2 = new TreeNode(10);

    TreeNode treeNode3 = new TreeNode(20);
    TreeNode treeNode4 = new TreeNode(30);

    treeNode.setLeftNote(treeNode1);
    treeNode.setRightNote(treeNode2);

    treeNode1.setLeftNote(treeNode3);
    treeNode1.setRightNote(treeNode4);

    treeNode2.setLeftNote(treeNode4);
    treeNode2.setRightNote(treeNode3);

    boolean duicheng = isDuicheng(treeNode);
    System.out.println(duicheng);

  }

  public static boolean isDuicheng(TreeNode rootNode) {
    if (rootNode == null) {
      return true;
    } else {
      return isDuicheng(rootNode.getLeftNote(), rootNode.getRightNote());
    }
  }

  public static boolean isDuicheng(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    } else if (left != null && right == null || left == null && right != null) {
      return false;
    } else {
      return left.getValue() == right.getValue()
          && isDuicheng(left.getLeftNote(), right.getRightNote())
          && isDuicheng(left.getRightNote(), right.getLeftNote());
    }
  }
}
