package F树.A011最大二叉树;

import Z2019.A003.TreeNode;

public class Soluction {
    //leetcode:654
    static TreeNode createMaxTreeNode(int[] nums) {
        return contruct(nums, 0, nums.length);
    }

    static TreeNode contruct(int[] nums, int l, int r) {
        //递归结束条件
        if (l == r) {
            return null;
        }
        //求最大元素的下标
        int maxIndex = l;
        for (int i = l; i < r; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        //构建根节点
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.leftNode = contruct(nums, l, maxIndex);
        root.rightNode = contruct(nums, maxIndex + 1, r);
        return root;
    }

    public static void main(String[] args) {
        TreeNode maxTreeNode = createMaxTreeNode(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(maxTreeNode);
    }
}
