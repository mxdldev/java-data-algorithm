package I2019.A004;

/**
 * Description: <ReView03TreeNode><br>
 * Author: mxdl<br>
 * Date: 2019/9/2<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class ReView03TreeNode {
  // 1.翻转一个整数
  public static int revertInt(int num) {
    int result = 0;
    while (num > 0) {
      result = result * 10 + num % 10;
      num = num / 10;
    }
    return result;
  }
  public static void main(String[] args){
      System.out.println(revertInt(1234));
  }
}
