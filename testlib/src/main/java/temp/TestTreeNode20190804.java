package temp;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Description: <TestTreeNode20190804><br>
 * Author:      mxdl<br>
 * Date:        2019/8/4<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class TestTreeNode20190804 {
    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(7);

        treeNode.leftNode = treeNode1;
        treeNode.rightNdoe = treeNode2;

        treeNode1.leftNode = treeNode3;
        treeNode1.rightNdoe = treeNode4;

        treeNode4.leftNode = treeNode5;
        treeNode4.rightNdoe = treeNode6;

        int treeNodeHeight = getTreeNodeHeight(treeNode);
        System.out.println("treeNodeHeight:"+treeNodeHeight);

        int treeNodeCount = getTreeNodeCount(treeNode);
        System.out.println("treeNodeCount:"+treeNodeCount);

        boolean sameTreeNode = isSameTreeNode(treeNode, treeNode);
        System.out.println("sameTreeNode:"+sameTreeNode);

        boolean symTreeNode = isSymTreeNode(treeNode);
        System.out.println("symTreeNode:"+symTreeNode);
    }
    //1.求二叉树的高
    public static int getTreeNodeHeight(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }else{
            int leftHeight = 1 + getTreeNodeHeight(treeNode.leftNode);
            int rightHeight = 1 + getTreeNodeHeight(treeNode.rightNdoe);
            return Math.max(leftHeight,rightHeight);
        }
    }
    //2.求二叉树的节点数
    public static int getTreeNodeCount(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }else{
            return 1 + getTreeNodeCount(treeNode.leftNode) + getTreeNodeCount(treeNode.rightNdoe);
        }
    }

    //3.判断两个二叉树是否完全相同
    public static boolean isSameTreeNode(TreeNode treeNode1,TreeNode treeNode2){
        if(treeNode1 == null && treeNode2 == null){
            return true;
        }
        if(treeNode1 == null && treeNode2 != null){
            return false;
        }
        if(treeNode1 != null && treeNode2 == null){
            return false;
        }
        return treeNode1.val == treeNode2.val && isSameTreeNode(treeNode1.leftNode,treeNode2.leftNode)
                &&isSameTreeNode(treeNode1.rightNdoe,treeNode2.rightNdoe);
    }

    //4.判断一个二叉树是否是对称二叉树
    public static boolean isSymTreeNode(TreeNode treeNode){
        if(treeNode == null){
            return true;
        }else{
            return isSymTreeNode(treeNode.leftNode,treeNode.rightNdoe);
        }
    }
    public static boolean isSymTreeNode(TreeNode leftNode,TreeNode rightNode){
        if(leftNode == null && rightNode == null){
            return true;
        }
        if(leftNode != null && rightNode == null){
            return false;
        }
        if(leftNode == null && rightNode != null){
            return false;
        }
        return leftNode.val == rightNode.val && isSymTreeNode(leftNode.leftNode,rightNode.rightNdoe)
                && isSymTreeNode(leftNode.rightNdoe,rightNode.leftNode);
    }
}
