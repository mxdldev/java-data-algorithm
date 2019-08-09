package F树.A004二叉树的中序遍历;

import temp.TreeNode;

/**
 * Description: <MainAlgorithm><br>
 * Author:      mxdl<br>
 * Date:        2019/8/9<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainAlgorithm {
    //二叉树的中序遍历，先遍历左子树，在遍历根节点，最后遍历右子树
    public static void printTreeNode(TreeNode treeNode){
        if(treeNode == null){
            return;
        }else{
            printTreeNode(treeNode.leftNode);
            System.out.println(treeNode.val);
            printTreeNode(treeNode.rightNdoe);
        }
    }
    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode.leftNode = treeNode1;
        treeNode.rightNdoe = treeNode2;

        treeNode1.leftNode = treeNode3;
        treeNode1.rightNdoe = treeNode4;

        treeNode2.leftNode = treeNode5;
        treeNode2.rightNdoe = treeNode6;

        printTreeNode(treeNode);
    }
}
