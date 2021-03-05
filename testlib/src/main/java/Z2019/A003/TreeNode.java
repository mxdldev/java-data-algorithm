package Z2019.A003;

/**
 * Description: <TreeNode><br>
 * Author:      mxdl<br>
 * Date:        2019/9/1<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class TreeNode {
    public int val;
    public TreeNode leftNode;
    public TreeNode rightNode;

    public TreeNode(int val) {
        this.val = val;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
