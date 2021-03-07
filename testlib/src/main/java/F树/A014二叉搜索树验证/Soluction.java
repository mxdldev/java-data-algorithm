package F树.A014二叉搜索树验证;

import Z2019.A003.TreeNode;

/**
 * Description: <Soluction><br>
 * Author:      mxdl<br>
 * Date:        2021/3/6<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Soluction {
    //leetcode : 98
    //中序遍历的次序和二叉树递增的顺序是一直的
    static int min = 0;
    static boolean flag = false;

    static boolean isTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        boolean left = isTreeNode(treeNode.leftNode);

        if (!flag) {
            min = treeNode.val;
            flag = true;
        }else{
            if (treeNode.val > min) {
                min = treeNode.val;
            } else {
                return false;
            }
        }

        boolean right = isTreeNode(treeNode.rightNode);
        return left && right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        root.leftNode = treeNode2;
        root.rightNode = treeNode6;

        treeNode2.leftNode = treeNode1;
        treeNode2.rightNode = treeNode3;

        treeNode6.leftNode = treeNode5;
        treeNode6.rightNode = treeNode7;

        System.out.println(isTreeNode(root));
    }
}
