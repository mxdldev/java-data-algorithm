package test.yesway.com.testlib.temp;

/**
 * Description: <><br>
 * Author:      gxl<br>
 * Date:        2018/11/15<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class TreeNode {
    public int val;
    public TreeNode leftNote;
    public TreeNode rightNode;

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeftNote() {
        return leftNote;
    }

    public void setLeftNote(TreeNode leftNote) {
        this.leftNote = leftNote;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
