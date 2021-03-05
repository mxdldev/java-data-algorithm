package F树.A010二叉树的最小深度;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import F树.A001求二叉树的高节点数中序遍历.TreeNode;

public class Soluction {
    static int getMinDepth(TreeNode node){
        if(node == null){
            return 0;
        }
//        if(node.getLeftNote() == null && node.getRightNote() != null){
//            return  1 + getMinDepth(node.getRightNote());
//        }
//        if(node.getLeftNote() != null && node.getRightNote() == null){
//            return  1 + getMinDepth(node.getLeftNote());
//        }
        int left = 1 + getMinDepth(node.getLeftNote());
        int right = 1 + getMinDepth(node.getRightNote());
        System.out.println("left:"+left);
        System.out.println("right:"+right);
        return left < right ? left : right;
    }
    static int getMinDepth1(TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(treeNode);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> nodeList = new ArrayList<>();
            depth++;
            int flat = 0;
            for(int i = 0; i < size; i++){
                TreeNode poll = queue.poll();
                nodeList.add(poll);
                if(poll.getLeftNote() != null){
                    queue.offer(poll.getLeftNote());
                }
                if(poll.getRightNote() != null){
                    queue.offer(poll.getRightNote());
                }
                if(poll.getLeftNote() == null && poll.getRightNote() == null){
                    flat++;
                    break;
                }
            }
            if(flat == 1){
                break;
            }
        }
        return depth;
    }
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode.setLeftNote(treeNode1);
        treeNode.setRightNote(treeNode2);
        treeNode1.setLeftNote(treeNode3);
        treeNode1.setRightNote(treeNode4);
        treeNode2.setLeftNote(treeNode5);
        treeNode3.setRightNote(treeNode6);

        System.out.println(getMinDepth(treeNode));
        System.out.println(getMinDepth1(treeNode));
    }
}
