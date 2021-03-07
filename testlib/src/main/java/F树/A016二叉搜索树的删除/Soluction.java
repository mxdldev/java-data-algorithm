package F树.A016二叉搜索树的删除;

import Z2019.A003.TreeNode;

/**
 * Description: <Soluction><br>
 * Author:      mxdl<br>
 * Date:        2021/3/7<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Soluction {
    //leetcode :删除450
    static TreeNode removeTreeNode(TreeNode root,int target){
        if(root == null){
            return root;
        }
        if(root.val == target){
            if(root.leftNode == null){
                return root.rightNode;
            }else if(root.rightNode == null){
                return root.leftNode;
            }else{
                TreeNode curr = root.rightNode;
                while (curr.leftNode != null){
                    curr = curr.leftNode;
                }
                curr.leftNode = root.leftNode;
                root = root.rightNode;
                return root;
            }
        }else if(root.val > target){
            root.leftNode = removeTreeNode(root.leftNode,target);
        }else{
            root.rightNode = removeTreeNode(root.rightNode,target);
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
        TreeNode treeNode = removeTreeNode(root, 6);
        System.out.println(treeNode.val);
    }
}
