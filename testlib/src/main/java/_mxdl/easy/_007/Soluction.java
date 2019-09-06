package _mxdl.easy._007;

/**
 * Description: <翻转一个整数><br>
 * Author: mxdl<br>
 * Date: 2019/9/5<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class Soluction {
  public int reverse(int x) {
    int result = 0;
    for (; x > 0; x /= 10) {
      result = result * 10 + x % 10;
    }
    return result;
  }

  public int reverse1(int x) {
    int result = 0;
    while (x > 0) {
      result = result * 10 + x % 10;
      x = x / 10;
    }
    return result;
  }

  public static void main(String[] args) {
    Soluction soluction = new Soluction();
    int res = soluction.reverse1(1234);
    System.out.println(res);
  }
}
