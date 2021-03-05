package F树.A005迭代法遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Z2019.A003.TreeNode;


public class Soluction {
    static List<TreeNode> createMidTreeNode(TreeNode node) {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode topNode = stack.peek();
            if (topNode != null) {
                //所有元素入栈
                stack.pop();

                if (topNode.rightNode != null) {
                    stack.push(topNode.rightNode);
                }

                stack.push(topNode);
                stack.push(null);

                if (topNode.leftNode != null) {
                    stack.push(topNode.leftNode);
                }

            } else {
                //所有元素弹栈
                stack.pop();
                TreeNode pop = stack.pop();
                list.add(pop);
            }
        }
        return list;
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

        List<TreeNode> midTreeNode = createMidTreeNode(treeNode);
        for (TreeNode node : midTreeNode) {
            System.out.println(node.val);
        }
    }
}
