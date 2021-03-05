package F树.A009二叉树的最大深度;

import F树.A001求二叉树的高节点数中序遍历.TreeNode;

public class Soluction {
    //leetcode:104
    //leetcode:111.最小深度
    //leetcode:222 节点个数
    static int getMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = 1 + getMaxDepth(node.getLeftNote());
        int right = 1 + getMaxDepth(node.getRightNote());
        return left > right ? left : right;
    }

}
