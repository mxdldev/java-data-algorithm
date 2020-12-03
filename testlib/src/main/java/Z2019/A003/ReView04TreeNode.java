package Z2019.A003;

/**
 * Description: <ReView04TreeNode><br>
 * Author:      mxdl<br>
 * Date:        2019/9/1<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class ReView04TreeNode {
    //1.求二叉树的结点数
    public static int getTreeNodeCount(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return 1 + getTreeNodeCount(treeNode.leftNode) + getTreeNodeCount(treeNode.rightNode);
    }

    //2.求二叉树的高度
    public static int getTreeNodeHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftHeight = 1 + getTreeNodeHeight(treeNode.leftNode);
        int rightHeight = 1 + getTreeNodeHeight(treeNode.rightNode);
        return Math.max(leftHeight, rightHeight);
    }

    //3.中序遍历二叉树
    public static void printMiddleTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printMiddleTreeNode(treeNode.leftNode);
        System.out.println(treeNode.val);
        printMiddleTreeNode(treeNode.rightNode);
    }

    //5.判断两个二叉树是否是完全二叉树
    public static boolean isEqualTreeNode(TreeNode ta, TreeNode tb) {
        if (ta == null && tb == null) {
            return true;
        }
        if (ta == null && tb != null) {
            return false;
        }
        if (ta != null && tb == null) {
            return false;
        }
        return ta.val == tb.val && isEqualTreeNode(ta.leftNode, tb.leftNode) && isEqualTreeNode(ta.rightNode, tb.rightNode);
    }

    //6.判断一个二叉树是否是对称二叉树
    public static boolean isSymsetry(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        } else {
            return isSymserty(treeNode.leftNode, treeNode.rightNode);
        }
    }

    public static boolean isSymserty(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode != null && rightNode == null) {
            return false;
        }

        if (leftNode == null && rightNode != null) {
            return false;
        }
        return leftNode.val == rightNode.val && isSymserty(leftNode.leftNode, rightNode.rightNode) && isSymserty(leftNode.rightNode, rightNode.leftNode);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode.leftNode = treeNode1;
        treeNode.rightNode = treeNode2;

        treeNode1.leftNode = treeNode3;
        treeNode2.rightNode = treeNode3;
        treeNode1.rightNode = treeNode4;
        treeNode2.leftNode = treeNode6;
        //treeNode1.leftNode = treeNode3;
        //treeNode1.rightNode = treeNode4;

        //treeNode2.leftNode = treeNode6;
        //treeNode2.rightNode = treeNode5;

//        int treeNodeCount = getTreeNodeCount(treeNode);
//        System.out.println(treeNodeCount);
        //int treeNodeHeight = getTreeNodeHeight(treeNode);
        //System.out.println(treeNodeHeight);
        //printMiddleTreeNode(treeNode);
        boolean equalTreeNode = isSymsetry(treeNode);
        System.out.println(equalTreeNode);
    }
}
