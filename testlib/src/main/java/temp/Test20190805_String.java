package temp;

/**
 * Description: <Test20190805_String><br>
 * Author: mxdl<br>
 * Date: 2019/8/7<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class Test20190805_String {
  // 1.翻转一个整数
  public static int reversInt(int num) {
    int temp = 0;
    while (num != 0) {
      temp = temp * 10 + num % 10;
      num = num / 10;
    }
    return temp;
  }

  // 2.查找一个数组中最大的非重复字符串
  public static String findMaxString(String str) {
    String reg = "(.)\\1+";
    String[] split = str.split(reg);
    String max = "";
    for (String currstr : split) {
      if (currstr.length() > max.length()) {
        max = currstr;
      }
    }
    return max;
  }

  // 3.查找最大的回文字符串
  public static String getMaxHuiWen(String str) {
    int m = str.length();
    boolean[][] arr = new boolean[m][m];
    int maxlen = 0;
    for (int i = 0; i < m; i++) {
      arr[i][i] = true;
      maxlen = 1;
    }
    String result = "";
    for (int i = 0; i < str.length() - 1; i++) {
      if (str.charAt(i) == str.charAt(i + 1)) {
        arr[i][i + 1] = true;
        result = str.substring(i, i + 1 + 1);
        maxlen = 2;
      }
    }
    for (int len = 3; len < str.length(); len++) {
      for (int i = 0, j; (j = i + len - 1) < str.length(); i++) {
        if (str.charAt(i) == str.charAt(j)) {
          arr[i][j] = arr[i + 1][j - 1];
          if (arr[i][j] && maxlen < len) {
            result = str.substring(i, j + 1);
          }
        } else {
          arr[i][j] = false;
        }
      }
    }
    return result;
  }

  public static String getMaxHuiWen1(String str) {
    boolean[][] arr = new boolean[str.length()][str.length()];
    int maxlen = 0;
    String result = null;
    for (int i = 0; i < str.length(); i++) {
      arr[i][i] = true;
    }
    for (int i = 0; i < str.length()-1; i++) {
      if (str.charAt(i) == str.charAt(i + 1)) {
        maxlen = 2;
        arr[i][i+1] = true;
        result = str.substring(i, i + 1 + 1);
      }
    }
    for (int len = 3; len <= str.length(); len++) {
      for (int i = 0, j; (j = i + len - 1) < str.length(); i++) {
        if(str.charAt(i) == str.charAt(j)){
          arr[i][j] = arr[i+1][j-1];
          if(arr[i][j] && maxlen < len){
            maxlen = len;
            result = str.substring(i,j+1);
          }
        }else{
          arr[i][j] = false;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {

    int i = reversInt(25461);
    System.out.println(i);

    String maxString = findMaxString("11abcdef22asaa789456123");
    System.out.println(maxString);

    String maxHuiWen = getMaxHuiWen1("12abba2");

    System.out.println("maxHuiWen:" + maxHuiWen);
  }

}
