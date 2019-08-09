package A数组.A010三数求和为0找下标;

/**
 * Description: <MainAlgorethm><br>
 * Author: mxdl<br>
 * Date: 2019/8/8<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorethm {
  public static int[] getIndex(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          if ((arr[i] + arr[j] + arr[k]) == 0) {
            System.out.println("i:"+i+"j:"+j+"k:"+k);
            return new int[] {i, j, k};
          }
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {2, 5, -2, 0, 3};
    int[] index = getIndex(arr);
    for (int i = 0; i < index.length; i++) {
      System.out.println(index[i]);
    }
  }
}
