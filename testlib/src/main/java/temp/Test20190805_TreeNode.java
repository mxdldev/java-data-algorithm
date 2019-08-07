package temp;

import sun.reflect.generics.tree.Tree;

/**
 * Description: <Test20190805_TreeNode><br>
 * Author: mxdl<br>
 * Date: 2019/8/7<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class Test20190805_TreeNode {
  // 1.二叉树的高
  public static int getTreeHeight(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    }
    int leftHeight = 1 + getTreeHeight(treeNode.leftNode);
    int rightHeight = 1 + getTreeHeight(treeNode.rightNdoe);

    return leftHeight > rightHeight ? leftHeight : rightHeight;
  }

  // 2.求二叉树的节点数
  public static int getTreeNodeCount(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    }
    return 1 + getTreeNodeCount(treeNode.leftNode) + getTreeNodeCount(treeNode.rightNdoe);
  }

  // 3.判断两个二叉树是否完全相等
  public static boolean isTreeNodeSame(TreeNode treeNode1, TreeNode treeNode2) {
    if (treeNode1 == null && treeNode2 == null) {
      return true;
    }
    if (treeNode1 != null && treeNode2 == null) {
      return false;
    }
    if (treeNode1 == null && treeNode2 != null) {
      return false;
    }
    return treeNode1.val == treeNode2.val && isTreeNodeSame(treeNode1.leftNode, treeNode2.leftNode)
        && isTreeNodeSame(treeNode1.rightNdoe, treeNode2.rightNdoe);
  }

  //4.判断一个二叉树是否是对等的二叉树
  public static boolean isSymTreeNdoe(TreeNode treeNode){
    if(treeNode == null){
      return true;
    }else{
      return isSymTreeNdoe(treeNode.leftNode,treeNode.rightNdoe);
    }
  }
  public static boolean isSymTreeNdoe(TreeNode leftNode,TreeNode rightNode){
    if(leftNode == null && rightNode == null){
      return true;
    }
    if(leftNode != null && rightNode == null){
      return false;
    }
    if(leftNode == null && rightNode != null){
      return false;
    }
    return leftNode.val == rightNode.val && isSymTreeNdoe(leftNode.leftNode,rightNode.rightNdoe) && isSymTreeNdoe(leftNode.rightNdoe,rightNode.leftNode);
  }
  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(0);
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(1);
    TreeNode treeNode3 = new TreeNode(2);
    TreeNode treeNode4 = new TreeNode(3);
    TreeNode treeNode5 = new TreeNode(3);
    TreeNode treeNode6 = new TreeNode(2);
    treeNode.leftNode = treeNode1;
    treeNode.rightNdoe = treeNode2;

    treeNode1.leftNode = treeNode3;
    treeNode1.rightNdoe = treeNode4;

    treeNode2.leftNode = treeNode5;
    treeNode2.rightNdoe = treeNode6;
    // treeNode1.leftNode = treeNode3;

    int treeHeight = getTreeHeight(treeNode);
    System.out.println("treeHeight:" + treeHeight);

    int treeNodeCount = getTreeNodeCount(treeNode);
    System.out.println("treeNodeCount:" + treeNodeCount);

    boolean treeNodeSame = isTreeNodeSame(treeNode, treeNode1);
    System.out.println("treeNodeSame:" + treeNodeSame);

    boolean symTreeNdoe = isSymTreeNdoe(treeNode);
    System.out.println("symTreeNdoe:" + symTreeNdoe);
  }
}
