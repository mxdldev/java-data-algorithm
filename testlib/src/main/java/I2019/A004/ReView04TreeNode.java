package I2019.A004;

/**
 * Description: <ReView04TreeNode><br>
 * Author: mxdl<br>
 * Date: 2019/9/2<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class ReView04TreeNode {
  // 1.查找最大的非重复字符串
  public static String searchMaxNoRepeatStr(String str) {
    String reg = "(.)\\1+";
    String[] split = str.split(reg);
    String longText = "";
    for (int i = 0; i < split.length; i++) {
      if (split[i].length() > longText.length()) {
        longText = split[i];
      }
    }
    return longText;
  }

  // 2.查到最大的回文字符串
  public static String getMaxHuiWen(String str) {
    boolean[][] arr = new boolean[str.length()][str.length()];
    int maxLen = 0;
    for (int i = 0; i < str.length(); i++) {
      arr[i][i] = true;
      maxLen = 1;
    }

    for (int i = 0; i < str.length() - 1; i++) {
      if (str.charAt(i) == str.charAt(i + 1)) {
        arr[i][i + 1] = true;
        maxLen = 2;
      }
    }
    String maxStr = "";
    for (int len = 3; len < str.length(); len++) {
      for (int i = 0, j = 0; (j = len + i - 1) < str.length(); i++) {
        if (str.charAt(i) == str.charAt(j)) {
          arr[i][j] = arr[i + 1][j - 1];
          if (arr[i][j] && len > maxLen) {
            maxStr = str.substring(i, j + 1);
            maxLen = len;
          }
        }
      }
    }
    return maxStr;
  }

  public static void main(String[] srgs) {
//    String str = "aa1234bbabc1223567bb";
//    String s = searchMaxNoRepeatStr(str);
//    System.out.println(s);
    String str = "abc1234321adfs";
    System.out.println(getMaxHuiWen(str));
  }
}
