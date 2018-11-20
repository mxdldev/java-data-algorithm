package test.yesway.com.testlib;

/**
 * Description: <><br>
 * Author:      gxl<br>
 * Date:        2018/11/19<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class ListNote {
    public int val;
    public ListNote next;

    public ListNote(int val) {
        this.val = val;
    }
    public ListNote() {
        this.val = val;
    }
    public void setNext(ListNote next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNote getNext() {
        return next;
    }
}
