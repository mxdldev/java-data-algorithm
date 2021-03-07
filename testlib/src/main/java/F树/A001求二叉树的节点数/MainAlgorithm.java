package F树.A001求二叉树的节点数;

/**
 * Description: <求二叉树的节点数高遍历><br>
 * Author: mxdl<br>
 * Date: 2018/11/21<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode.setLeftNote(treeNode1);
        treeNode.setRightNote(treeNode2);

        treeNode1.setLeftNote(treeNode3);
        treeNode1.setRightNote(treeNode4);

        treeNode3.setLeftNote(treeNode5);
        treeNode3.setRightNote(treeNode2);

        inOrderTraversal(treeNode);
    }

    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        } else {
            inOrderTraversal(node.getLeftNote());
            System.out.println(node.getValue());
            inOrderTraversal(node.getRightNote());
        }
    }

    // 求二叉树节点的个数
    public static int getTreeNodeCount(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            return 1 + getTreeNodeCount(treeNode.getLeftNote())
                    + getTreeNodeCount(treeNode.getRightNote());
        }
    }
}
