package C散列表.A002快乐数;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: <Test><br>
 * Author:      mxdl<br>
 * Date:        2021/2/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Test {
    public static void main(String[] args) {
        System.out.println(isHappy(10));
    }
    static boolean isHappy(int n){
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;

    }
    static int getNext(int n){
        int sum = 0;
        while(n > 0){
            int d = n % 10;
            n = n/10;
            sum += d * d;
        }
        return sum;
    }
}
