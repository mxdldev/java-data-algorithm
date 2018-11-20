package test.yesway.com.testlib;

/**
 * Description: <><br>
 * Author: gxl<br>
 * Date: 2018/11/19<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MyQueue {
  private int head = 0;
  private int tail = 0;
  private final int[] arr;

  public MyQueue() {
    arr = new int[5];
  }

  // 塞数据
  public boolean put(int value) {
    if (head == (tail + 1) % arr.length) {
      System.out.println("队列已经满了...");
      return false;
    }
    arr[tail] = value;
    tail = (tail + 1) % arr.length;
    return true;
  }

  public int poll() {
    if (head == tail) {
      System.out.println("队列已经空了");
      return -1;
    }
    int item = arr[head];
    arr[head] = 0;
    head = (head + 1) % arr.length;
    return item;
  }
}
