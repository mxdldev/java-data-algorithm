package D栈队列.A001用数组实现一个栈;

import java.util.Arrays;

/**
 * Description: <><br>
 * Author: gxl<br>
 * Date: 2018/11/19<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MyStack {
  private int[] arr;
  private int size = 0;
  private int initsize = 5;

  public MyStack() {
    arr = new int[initsize];
  }

  public void push(int value) {
    if (size == arr.length) {
      arr = Arrays.copyOf(arr, size * 2);
    }
    arr[size++] = value;
  }

  public int pop() {
    if (size == 0) {
      throw new IndexOutOfBoundsException("栈里面数组为空了");
    }
    return arr[--size];
  }

  public int size() {
    return size;
  }
}
