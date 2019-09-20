package A数组.A012逆时针旋转二维数组90度;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description: <MainAlgorithm><br>
 * Author: mxdl<br>
 * Date: 2019/9/20<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {

  // 1.旋转矩阵：逆时针旋转90度 n * n
  /**
   *1 2 3      3 6 9
   4 5 6  ->  2 5 8
   7 8 9      1 4 7
   *
   */
  public static int[][] rotate(int[][] a) {
    // 1.按照原来数组的顺序，从下往上给新数组赋值
    // 2.赋值第一列，赋值第二列，赋值第三列
    // 行数
    int n = a.length;
    // 列数
    int m = a[0].length;
    // 转换后矩阵
    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[m - 1 - j][i] = a[i][j];
      }
    }
    return arr;
  }

  // 2.转置矩阵：行列位置对换 n * n
  /**
   * 1 2 3      1 4 7
   * 4 5 6   -> 2 5 8
   * 7 8 9      3 6 9
   *
   */
  public static int[][] reversArr(int[][] arr) {
    /**
     * 1,2,3 1,3,6 3,4,5 ==> 2,4,7 6,7,8 3,5,8
     */
    int m = arr.length;
    int n = arr[0].length;
    int[][] nums = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        nums[j][i] = arr[i][j];
      }
    }
    return nums;
  }
/**
 * 3.输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵：
 *  1  2  3  4
 *  5  6  7  8
 *  9  10 11 12
 *  13 14 15 16
 *  则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
  public static ArrayList<Integer> printMatrix(int[][] array) {
    ArrayList<Integer> list = new ArrayList<>();
    int n = array.length;
    int m = array[0].length;
    /**
     * 核心
     */
    int c = (Math.min(n, m) - 1) / 2 + 1;// 层数

    for (int i = 0; i < c; i++) {
      for (int j = i; j < m - i; j++)// 左上到右上
        list.add(array[i][j]);
      for (int k = i + 1; k < n - i; k++)// 右上到右下
        list.add(array[k][m - i - 1]);
      for (int o = m - i - 1; o > i; o--)// 右下到左下
        list.add(array[n - i - 1][o - 1]);
      for (int p = n - i - 2; p > i; p--)// 左下到右上
        list.add(array[p][i]);
    }
    return list;
  }

  //4.随机生成1-100不重复元素的数组
  public static int[] createNoRepeatArr(){
    int len = 100;
    //生成一个原始从1到100的数组;
    List<Integer> originList = new ArrayList<Integer>();
    for(int i = 1; i <= len; i++){
      originList.add(i);
    }
    int[] nums = new int[len];
    for(int i = 0; i < len; i ++){
      int index = new Random().nextInt(len - i);//随机取值下标的范围在不断的缩小
      nums[i] = originList.get(index);//根据随机下标赋值
      originList.remove(index);//删除原始容器的值，以免重复取值
    }
    return nums;
  }
  //5.随机生成1-100不重复元素的数组:性能优化
  public static int[] createNoRepeatArr1(){
    int len = 100;
    int[] result = new int[100];
    int[] originArr = new int[len];
    //给原数组赋值
    for(int i = 0; i < len ; i ++){
      originArr[i] = i;
    }
    int end = len - 1;
    //从原数组随机抽取
    for(int i = 0;i < len ;i++){
      int index = new Random().nextInt(len-i);//不断的缩小查找的范围
      result[i] = originArr[index];//给结果数组赋值
      originArr[index] = originArr[end];//最后一个元素覆盖掉已经用过的元素，避免重复，比删除效率要高很多
      end--;//用一个替补一个：末位替补
    }
    return result;
  }
  public static void main(String[] args) {
    int[][] nums = {{1, 2,3}, {4, 5,6}};
    // int[][] nums = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    // int[][] rotate = rotate(nums);
    //int[][] rotate = reversArr(nums);
    //ArrayList<Integer> integers = printMatrix(nums);
//    for (int i = 0; i < rotate.length; i++) {
//      for (int j = 0; j < rotate[0].length; j++) {
//        System.out.println(rotate[i][j]);
//      }
//    }
    int[] integers = createNoRepeatArr1();
    for(int i = 0; i < integers.length; i++){
      System.out.println(integers[i]);
    }
//    for(int i = 0; i < 10; i++){
//      System.out.println(new Random().nextInt(0));
//    }

  }
}
