package Z2019.A004;

import temp.TreeNode;

/**
 * Description: <ReView02TreeNode><br>
 * Author:      mxdl<br>
 * Date:        2019/9/2<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class ReView02TreeNode {
    //1.求二叉树的节点数
    public static int getTreeNodeCount(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        return 1 + getTreeNodeCount(treeNode.leftNode) + getTreeNodeCount(treeNode.rightNode);
    }
    //2.而二叉树的高
    public static int getTeeNodeHeight(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        int leftHeight = 1 + getTeeNodeHeight(treeNode.rightNode);
        int rightHeight = 1 + getTeeNodeHeight(treeNode.leftNode);
        return Math.max(leftHeight,rightHeight);
    }
    //3.中序遍历
    public static void printMiddleTreeNode(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        printMiddleTreeNode(treeNode.leftNode);
        System.out.println(treeNode.val);
        printMiddleTreeNode(treeNode.rightNode);
    }
    //4.判断两个二叉树是否完全相等
    public static boolean isEqualTwoTreeNode(TreeNode pa,TreeNode pb){
        if(pa == null && pb == null){
            return true;
        }
        if(pa != null && pb == null){
            return false;
        }
        if(pa == null && pb != null){
            return false;
        }
        return pa.val == pb.val && isEqualTwoTreeNode(pa.leftNode,pb.leftNode) && isEqualTwoTreeNode(pa.rightNode,pb.rightNode);
    }
    //5.判断一个二叉树是否为对称二叉树
    public static boolean isSYMTreeNode(TreeNode treeNode){
        if(treeNode == null){
            return false;
        }else{
            return isSYMTreeNode(treeNode.leftNode,treeNode.rightNode);
        }
    }
    public static boolean isSYMTreeNode(TreeNode leftNode,TreeNode rightNode){
        if(leftNode == null && rightNode == null){
            return true;
        }
        if(leftNode != null && rightNode == null){
            return false;
        }
        if(leftNode == null && rightNode != null){
            return false;
        }
        return leftNode.val == rightNode.val && isSYMTreeNode(leftNode.leftNode,rightNode.rightNode) && isSYMTreeNode(leftNode.rightNode,rightNode.leftNode);
    }
    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(3);
        treeNode.leftNode = treeNode1;
        treeNode.rightNode = treeNode2;

        treeNode1.leftNode = treeNode3;
        treeNode2.rightNode = treeNode3;

        treeNode1.rightNode = treeNode5;
        treeNode2.leftNode = treeNode5;

//        treeNode1.leftNode = treeNode3;
//        treeNode2.rightNode = treeNode3;
//        treeNode1.rightNode = treeNode4;
//        treeNode2.leftNode = treeNode6;
//        treeNode6.leftNode = treeNode5;


        //printMiddleTreeNode(treeNode);
        //System.out.println(treeNodeCount);

        //boolean equalTwoTreeNode = isEqualTwoTreeNode(treeNode1, treeNode1);
        boolean symTreeNode = isSYMTreeNode(treeNode);
        System.out.println(symTreeNode);
    }
}
