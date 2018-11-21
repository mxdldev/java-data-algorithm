package A001冒泡排序;

/**
 * Description: <冒泡排序><br>
 * Author:      gxl<br>
 * Date:        2018/11/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainAlgorithm {
    public static void main(String[] arg){
        int[] arr = {1,3,10,1,34,5,21};
        sortBubbling(arr);
        int i = 0;
        while (i < arr.length){
            System.out.println(arr[i]);
            i++;
        }
    }
    // 冒泡排序：两个循环，通过两两相比，进行排序
    private static void sortBubbling(int[] arr) {
        // 第一轮确定最后一个，第二轮确定倒数第二个...
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 两两相比，就像鱼吐水泡一样...
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
