package A数组.A009左上到右下路径数;

/**
 * Description: <在一个m*n的矩形方格中， 机器人在最左上的格子里，一次只能挪动一步，只能往右往下移动 目标地点在最右下方的方格里，问共有几条路径 ><br>
 * Author: gxl<br>
 * Date: 2018/11/23<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {
  public static void main(String[] args) {

    int path = getPath(3, 3);
    System.out.println(path);
    int[][] arr = new int[2][3];
    System.out.println("length:"+arr.length);
  }

  // 动态规划问题
  public static int getPath(int m, int n) {
    int[][] arr = new int[m][n];
    // 将第一行都赋值为1
    for (int i = 0; i < n; i++) {
      arr[0][i] = 1;
    }
    // 将第一列都赋值为1
    for (int i = 0; i < m; i++) {
      arr[i][0] = 1;
    }
    // 给其他单元格赋值
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
      }
    }
    return arr[m - 1][n - 1];
  }
}
