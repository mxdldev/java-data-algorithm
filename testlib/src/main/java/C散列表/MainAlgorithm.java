package C散列表;

import java.util.HashSet;

/**
 * Description: <><br>
 * Author:      mxdl<br>
 * Date:        2018/11/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainAlgorithm {
    public static void main(String[] args) {
        System.out.println(test1(7));
    }
    static public boolean test1(int n){
        HashSet set = new HashSet();
        while (n != 1 && !set.contains(n)){
            n = test(n);
        }
        return n == 1;
    }
    static int test(int num){
        int sum = 0;
        while (num > 0) {
            int n = num % 10;
            num = num / 10;
            System.out.println(n);
            sum += n * n;
        }
        return sum;
    }
}
