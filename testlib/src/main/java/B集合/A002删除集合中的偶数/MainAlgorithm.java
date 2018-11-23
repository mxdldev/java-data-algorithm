package B集合.A002删除集合中的偶数;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Description: <删除集合中的偶数><br>
 * Author: gxl<br>
 * Date: 2018/11/21<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {
  public static void main(String[] arg) {
    ArrayList<Integer> list = new ArrayList() {
      {
        add(1);
        add(2);
        add(3);
        add(4);
      }
    };
    removeEvenNumber(list);
    int i = 0;
    while (i < list.size()) {
      System.out.println(list.get(i));
      i++;
    }
  }

  // 删除集合中的偶数元素
  private static void removeEvenNumber(ArrayList<Integer> myArrayList) {
    Iterator<Integer> iterator = myArrayList.iterator();
    while (iterator.hasNext()) {
      Integer next = iterator.next();
      if (next % 2 == 0) {
        iterator.remove();
      }
    }
  }
}
