package test.yesway.com.testlib;

/**
 * Description: <><br>
 * Author: gxl<br>
 * Date: 2018/11/20<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MyListLink {
  private ListNote first;
  private ListNote last;
  private int size;

  public void addLast(int value) {
    ListNote listNote = new ListNote();
    listNote.setVal(value);
    if (first == null) {
      first = listNote;
    } else {
      last.setNext(listNote);
    }
    last = listNote;
    size++;
  }

    public ListNote getFirst() {
        return first;
    }
}
