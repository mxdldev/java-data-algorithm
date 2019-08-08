package temp;

/**
 * Description: <TestCode><br>
 * Author: mxdl<br>
 * Date: 2019/8/8<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class TestCode {
  public static void main(String[] args) {
    int[] arr = new int[] {1, 5, 6, 2, 3};
    int i = maxArea(arr);
    System.out.println(i);
  }

  public static int maxArea(int[] height) {
    int maxarea = 0;
    for (int i = 0; i < height.length; i++) {
      for (int j = i + 1; j < height.length; j++) {
        maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
      }
    }
    return maxarea;
  }
}
