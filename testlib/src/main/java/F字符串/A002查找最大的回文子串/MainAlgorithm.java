package F字符串.A002查找最大的回文子串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: <查找最大的回文子串><br>
 * Author: gxl<br>
 * Date: 2018/11/22<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {
  public static void main(String[] args) {
    String str = "abc3220440223123131abcdefgha101ahgfedcba";
    String s = getLongtext(str);
    System.out.println(s);
    // getStr(str);
  }

  public static  String getLongtext(String str) {
    if (str == null || str.length() < 2) {
      return str;
    }
    String longtxt = null;
    // 使用动态规划法
    // 声明一个boolean类型的二维数组，来记录查找的结果
    boolean[][] arr = new boolean[str.length()][str.length()];
    // 二维数组打底
    int maxlen = 0;
    // 一个字符的都是回文
    for (int i = 0; i < str.length(); i++) {
      arr[i][i] = true;
      maxlen = 1;
    }
    // 两个字符也都是回文
    for (int i = 0; i < str.length() - 1; i++) {
      if (str.charAt(i) == str.charAt(i + 1)) {
        arr[i][i + 1] = true;
      }
      maxlen = 2;
    }
    // 判断三个以上的字符
    // 第一轮循环：三个取一次
    // 第二轮循环：四个取一次
    // 第三轮循环：五个取一次
    // ...
    for (int len = 3; len < arr.length; len++) {
      for (int i = 0, j; (j = i + len - 1) < arr.length; i++) {
        if (str.charAt(i) == str.charAt(j)) {
          arr[i][j] = arr[i + 1][j - 1];
          if (arr[i][j] && maxlen < len) {
            longtxt = str.substring(i, j + 1);
            maxlen = len;
          }
        }else{
          arr[i][j] = false;
        }
      }
    }
    return longtxt;
  }

}
