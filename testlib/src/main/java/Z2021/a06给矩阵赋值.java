package Z2021;

import java.util.Arrays;

public class a06给矩阵赋值 {
    static int[][] createArray(int n) {
        int[][] nums = new int[n][n];
        int left = 0;
        int right = n -1;
        int top = 0;
        int bottom = n -1;

        int num = 1;
        while (num < n * n) {
            for (int i = left; i <= right; i++) {
                nums[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                nums[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                nums[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                nums[i][left] = num++;
            }
            left++;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(createArray(4)));
    }
}
