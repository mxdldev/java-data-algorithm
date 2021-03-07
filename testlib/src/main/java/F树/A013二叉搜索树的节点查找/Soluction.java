package F树.A013二叉搜索树的节点查找;

import Z2019.A003.TreeNode;

/**
 * Description: <Soluction><br>
 * Author:      mxdl<br>
 * Date:        2021/3/6<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Soluction {
    //leetcode:700
    //8.二叉搜索树查找
    //8.1递归法
    static TreeNode searchTreeNode(TreeNode treeNode, int target) {
        if (treeNode == null || treeNode.val == target) {
            return treeNode;
        }
        if (target > treeNode.val) {
            return searchTreeNode(treeNode.rightNode, target);
        } else if (target < treeNode.val) {
            return searchTreeNode(treeNode.leftNode, target);
        } else {
            return treeNode;
        }
    }
    //9.迭代法
    static TreeNode searchTreeNode1(TreeNode treeNode,int target){
        while (treeNode != null){
           if(target > treeNode.val) {
                treeNode = treeNode.rightNode;
            } else if (target < treeNode.val) {
                treeNode = treeNode.leftNode;
            }else{
                return treeNode;
            }
        }
        return null;
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

        System.out.println(searchTreeNode(root, 3).val);
        System.out.println("----------------------------");
        System.out.println(searchTreeNode1(root, 3).val);
    }
}
