package Z2021.a0306;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import Z2019.A003.TreeNode;

/**
 * Description: <Test><br>
 * Author:      mxdl<br>
 * Date:        2021/3/6<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Test {
    //1.求二叉树的节点数
    //1.1递归法
    static int getTreeNodeCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getTreeNodeCount(node.leftNode) + getTreeNodeCount(node.rightNode);
    }

    //1.2 迭代法
    static int getTreeNodeCount1(TreeNode node) {
        //一层层的计算
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                count++;
                if (currNode.leftNode != null) {
                    queue.offer(currNode.leftNode);
                }
                if (currNode.rightNode != null) {
                    queue.offer(currNode.rightNode);
                }
            }
        }
        return count;
    }

    //2.迭代二叉树的节点
    //2.1递归法
    static void printTreeNodeCount(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printTreeNodeCount(treeNode.leftNode);
        System.out.println(treeNode.val);
        printTreeNodeCount(treeNode.rightNode);
    }

    //2.2.迭代法
    static void printTreeNodeCount1(TreeNode treeNode) {
        //1.前序 后序 中序
        Stack<TreeNode> stack = new Stack();
        stack.push(treeNode);
        List<TreeNode> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek != null) {
                TreeNode pop = stack.pop();
                if (pop.rightNode != null) {
                    stack.push(pop.rightNode);
                }

                stack.push(pop);
                stack.push(null);

                if (pop.leftNode != null) {
                    stack.push(pop.leftNode);
                }
            } else {
                stack.pop();
                list.add(stack.pop());
            }
        }
        for (TreeNode treeNode1 : list) {
            System.out.println(treeNode1.val);
        }
    }

    //3.层序遍历二叉树
    static void printTreeNode2(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        List<List<TreeNode>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list1 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list1.add(poll);
                if (poll.leftNode != null) {
                    queue.offer(poll.leftNode);
                }
                if (poll.rightNode != null) {
                    queue.offer(poll.rightNode);
                }
            }
            list.add(list1);
        }
        for (List<TreeNode> list2 : list) {
            for (TreeNode treeNode1 : list2) {
                System.out.println(treeNode1.val);
            }
        }
    }

    //4.求二叉树的高
    static int getTreeNodeHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = 1 + getTreeNodeCount(treeNode.leftNode);
        int right = 1 + getTreeNodeCount(treeNode.rightNode);
        return (left > right ? left : right) - 1;
    }

    public static int getTreeNodeHeight1(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            return Math.max(getTreeNodeHeight1(treeNode.leftNode), getTreeNodeHeight1(treeNode.rightNode)) + 1;
        }
    }

    //5.翻转一个二叉树
    static TreeNode reverseTreeNode(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek != null) {
                TreeNode pop = stack.pop();
                if (pop.rightNode != null) {
                    stack.push(pop.rightNode);
                }
                if (pop.leftNode != null) {
                    stack.push(pop.leftNode);
                }
                stack.push(pop);
                stack.push(null);
            } else {
                stack.pop();
                TreeNode pop = stack.pop();
                TreeNode temp = pop.leftNode;
                pop.leftNode = pop.rightNode;
                pop.rightNode = temp;
            }
        }
        return treeNode;
    }

    //6.合并两个二叉树
    static TreeNode mergeTreeNode(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode treeNode = new TreeNode(t1.val + t2.val);
        treeNode.leftNode = mergeTreeNode(t1.leftNode, t2.leftNode);
        treeNode.rightNode = mergeTreeNode(t1.rightNode, t2.rightNode);
        return treeNode;
    }

    //7.求两个二叉树是否完全相等
    static boolean isEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 != null) {
            return false;
        }
        if (t1 != null && t2 == null) {
            return false;
        }
        if (t1 == null && t2 == null) {
            return true;
        }
        return t1.val == t2.val && isEqual(t1.leftNode, t2.leftNode) && isEqual(t1.rightNode, t2.rightNode);
    }

    //7.判断是否是对称二叉树
    static boolean isDuiCheng(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 != null) {
            return false;
        }
        if (t1 != null && t2 == null) {
            return false;
        }
        if (t1 == null && t2 == null) {
            return true;
        }
        return t1.val == t2.val && isEqual(t1.leftNode, t2.rightNode) && isEqual(t1.rightNode, t2.leftNode);
    }

    //8.二叉搜索树查找
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

//        TreeNode treeNode = new TreeNode(0);
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode6 = new TreeNode(6);
//        treeNode.leftNode = treeNode1;
//        treeNode.rightNode = treeNode2;
//        treeNode1.leftNode = treeNode3;
//        treeNode1.rightNode = treeNode4;
//        treeNode2.leftNode = treeNode5;
//        treeNode2.rightNode = treeNode6;
//        //System.out.println(getTreeNodeCount(treeNode));
//        //System.out.println(getTreeNodeCount1(treeNode));
//        printTreeNodeCount(treeNode);
//        System.out.println("--------------------------");
//        printTreeNodeCount1(treeNode);
//        System.out.println("--------------------------");
//        printTreeNode2(treeNode);
//        System.out.println("--------------------------");
//        System.out.println(getTreeNodeHeight(treeNode));
//        System.out.println(getTreeNodeHeight1(treeNode));
////        TreeNode x = reverseTreeNode(treeNode);
////        System.out.println(x);
//        TreeNode treeNode7 = mergeTreeNode(treeNode, treeNode);
//        System.out.println(treeNode7);
//        System.out.println("==============================");
//        System.out.println(isEqual(treeNode,treeNode));


//        TreeNode treeNode = new TreeNode(0);
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode11 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//
//        treeNode.leftNode = treeNode1;
//        treeNode.rightNode = treeNode11;
//        treeNode1.leftNode = treeNode2;
//        treeNode1.rightNode = treeNode3;
//        treeNode11.leftNode = treeNode3;
//        treeNode11.rightNode = treeNode2;
//
//        System.out.println(isDuiCheng(treeNode.leftNode,treeNode.rightNode));

    }
}
