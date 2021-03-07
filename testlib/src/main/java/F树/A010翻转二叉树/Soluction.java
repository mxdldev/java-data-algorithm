package F树.A010翻转二叉树;

import java.util.Stack;

import Z2019.A003.TreeNode;

public class Soluction {
    static TreeNode reverseTreeNode(TreeNode treeNode){
        if(treeNode == null){
            return treeNode;
        }
        TreeNode left = treeNode.leftNode;
        treeNode.leftNode = treeNode.rightNode;
        treeNode.rightNode = left;
        reverseTreeNode(treeNode.leftNode);
        reverseTreeNode(treeNode.rightNode);
        return treeNode;
    }

    static TreeNode reverseTreeNode1(TreeNode root){
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node != null){
                stack.pop();
                if(node.rightNode != null){
                    stack.push(node.rightNode);
                }
                if(node.leftNode != null){
                    stack.push(node.leftNode);
                }
                stack.push(node);
                stack.push(null);
            }else{
                stack.pop();
                TreeNode pop = stack.pop();
                TreeNode temp = pop.leftNode;
                pop.leftNode = pop.rightNode;
                pop.rightNode = temp;
            }
        }
        return root;
    }
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode.setLeftNode(treeNode1);
        treeNode.setRightNode(treeNode2);
        treeNode1.setLeftNode(treeNode3);
        treeNode1.setRightNode(treeNode4);
        treeNode2.setLeftNode(treeNode5);
        treeNode2.setRightNode(treeNode6);

        TreeNode node = reverseTreeNode(treeNode);
        System.out.println(node.toString());
        TreeNode treeNode11 = reverseTreeNode1(node);
        System.out.println(treeNode11.toString());
    }
}
