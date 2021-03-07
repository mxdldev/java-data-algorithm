package F树.A002二叉树遍历_递归;

import F树.A001求二叉树的节点数.TreeNode;

/**
 * Description: <Soluction><br>
 * Author:      mxdl<br>
 * Date:        2021/3/7<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Soluction {
    //二叉树的中序遍历，先遍历左子树，在遍历根节点，最后遍历右子树 144 94 145
    public static void printTreeNote(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        } else {
            printTreeNote(treeNode.getLeftNote());
            System.out.println(treeNode.getValue());// 中序遍历
            printTreeNote(treeNode.getRightNote());
        }
    }
}
