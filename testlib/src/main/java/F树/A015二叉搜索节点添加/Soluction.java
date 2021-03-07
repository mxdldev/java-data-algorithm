package F树.A015二叉搜索节点添加;

import Z2019.A003.TreeNode;

/**
 * Description: <Soluction><br>
 * Author:      mxdl<br>
 * Date:        2021/3/6<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Soluction {
    //leetcode :插入701
    static TreeNode insertTreeNode(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode(target);
        }
        if (target > root.val) {
            root.rightNode = insertTreeNode(root.rightNode, target);
        } else {
            root.leftNode = insertTreeNode(root.leftNode, target);
        }
        return root;
    }

    static TreeNode insertBST(TreeNode root, int target) {
        TreeNode curr = root;
        while (curr != null) {
            if (target > curr.val) {
                if (curr.rightNode == null) {
                    curr.rightNode = new TreeNode(target);
                    break;
                } else {
                    curr = curr.rightNode;
                }
            } else {
                if (curr.leftNode == null) {
                    curr.leftNode = new TreeNode(target);
                    break;
                } else {
                    curr = curr.leftNode;
                }
            }
        }
        return root;
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

        //TreeNode treeNode = insertTreeNode(root, 0);
        //System.out.println(treeNode.val);
        TreeNode treeNode11 = insertBST(root, 10);
        System.out.println(treeNode11.val);
    }
}
