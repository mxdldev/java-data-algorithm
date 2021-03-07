package F树.A012合并二叉树;

import Z2019.A003.TreeNode;

public class Soluction {
    //leetcode: 617
    static TreeNode getTreeNode(TreeNode t1,TreeNode t2){
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        TreeNode treeNode = new TreeNode(t1.val + t2.val);
        treeNode.leftNode = getTreeNode(t1.leftNode , t2.leftNode);
        treeNode.rightNode = getTreeNode(t1.rightNode,t2.rightNode);
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t0.rightNode = t1;
        t0.leftNode = t2;

        TreeNode t01 = new TreeNode(0);
        TreeNode t11 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        t01.rightNode = t11;
        t01.leftNode = t21;

        TreeNode treeNode = getTreeNode(t0, t01);
        System.out.println(treeNode);
    }
}
