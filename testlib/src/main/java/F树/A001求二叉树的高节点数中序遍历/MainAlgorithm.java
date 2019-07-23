package F树.A001求二叉树的高节点数中序遍历;

/**
 * Description: <求二叉树的节点数高遍历><br>
 * Author: mxdl<br>
 * Date: 2018/11/21<br>
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

    printTreeNote(treeNode);
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

  // 遍历二叉树的所有节点
  public static void printTreeNote(TreeNode treeNode) {
    if (treeNode == null) {
      return;
    } else {
      System.out.println(treeNode.getValue());
      printTreeNote(treeNode.getLeftNote());
      // System.out.println(treeNode.getValue());//中序遍历
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
}
