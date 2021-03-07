package F树.A001求二叉树的节点数;

/**
 * Description: <><br>
 * Author: mxdl<br>
 * Date: 2018/11/20<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class TreeNode {
  private int value;
  private TreeNode leftNote;
  private TreeNode rightNote;

  public TreeNode(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public TreeNode getLeftNote() {
    return leftNote;
  }

  public void setLeftNote(TreeNode leftNote) {
    this.leftNote = leftNote;
  }

  public TreeNode getRightNote() {
    return rightNote;
  }

  public void setRightNote(TreeNode rightNote) {
    this.rightNote = rightNote;
  }
}
