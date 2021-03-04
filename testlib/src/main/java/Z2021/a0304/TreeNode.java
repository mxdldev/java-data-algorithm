package Z2021.a0304;


import javax.management.openmbean.InvalidOpenTypeException;

public class TreeNode {
    int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static void main(String[] args) {
        /*TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode.setLeft(treeNode1);
        treeNode.setRight(treeNode2);
        treeNode1.setLeft(treeNode3);
        treeNode1.setRight(treeNode4);
        treeNode2.setLeft(treeNode5);
        treeNode2.setRight(treeNode6);*/


        //System.out.println(getTreeNodeCount(treeNode.left , treeNode.right) + 1);
        //System.out.println(getTreeNodeCount(treeNode));
        //printNode(treeNode);
        //System.out.println(getTreeNodeHeight(treeNode));

        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode.setLeft(treeNode1);
        treeNode.setRight(treeNode2);

        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode21 = new TreeNode(4);
        treeNode0.setLeft(treeNode11);
        treeNode0.setRight(treeNode21);

        //System.out.println(sameTreeNode(treeNode,treeNode0));
        System.out.println(sameTreeNode1(treeNode.left,treeNode.right));
    }


    static int getTreeNodeCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getTreeNodeCount(node.left) + getTreeNodeCount(node.right) + 1;
    }
    static void printNode(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        printNode(node.left);
        printNode(node.right);
    }
    static int getTreeNodeHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = 1 + getTreeNodeHeight(node.left);
        int right = 1 + getTreeNodeHeight(node.right);
        return left > right ? left : right;
    }

    static boolean sameTreeNode(TreeNode left,TreeNode right){
        if(left != null && right == null){
            return false;
        }else if(left == null && right != null){
            return false;
        }else if(left == null && right == null){
            return true;
        }
        return left.val == right.val && sameTreeNode(left.left,right.left) && sameTreeNode(left.right,right.right);
    }

    static boolean sameTreeNode1(TreeNode left,TreeNode right){
        if(left != null && right == null){
            return false;
        }else if(left == null && right != null){
            return false;
        }else if(left == null && right == null){
            return true;
        }
        return left.val == right.val && sameTreeNode(left.left,right.right) && sameTreeNode(left.right,right.left);
    }

}
