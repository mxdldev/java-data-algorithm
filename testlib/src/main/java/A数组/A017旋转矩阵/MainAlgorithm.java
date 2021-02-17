package A数组.A017旋转矩阵;

import java.util.Arrays;

/**
 * Description: <MainAlgorithm><br>
 * Author:      mxdl<br>
 * Date:        2021/2/17<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class MainAlgorithm {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generalMaritx(4)));
    }

    static int[][] generalMaritx(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1, tar = n * n;
        int[][] mat = new int[n][n];
        while (num <= tar) {
            for (int i = l; i <= r; i++) mat[t][i] = num++;
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++;
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++;
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++;
            l++;
        }
        return mat;
    }
}
