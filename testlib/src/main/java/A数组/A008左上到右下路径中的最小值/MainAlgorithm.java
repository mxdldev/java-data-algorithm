package A数组.A008左上到右下路径中的最小值;

/**
 * Description: <在一个m*n的矩形方格中， 机器人在最左上的格子里，一次只能挪动一步，只能往右往下移动 目标地点在最右下方的方格里，问共有几条路径，求路径中的最小值><br>
 * Author: gxl<br>
 * Date: 2018/11/23<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {
  public static void main(String[] args) {
    int[][] grid = new int[][] {{1, 1, 8}, {3, 1, 4}, {6, 2, 1}};
    int minvalue = getMinvalue(grid);
    System.out.println(minvalue);
  }

  private static int getMinvalue(int[][] grid) {
    int[][] result = new int[grid.length][grid[0].length];
    // 给result[0][0]赋值
    result[0][0] = grid[0][0];
    // 给第一行赋值
    for (int i = 1; i < result[0].length; i++) {
      result[0][i] = result[0][i - 1] + grid[0][i];
    }
    // 给第一列赋值
    for (int i = 1; i < result.length; i++) {
      result[i][0] = result[i - 1][0] + grid[i][0];
    }
    // 给其他元素赋值
    for (int i = 1; i < result.length; i++) {
      for (int j = 1; j < result[0].length; j++) {
        result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j];
      }
    }
    return result[result.length - 1][result[0].length - 1];
  }
}
