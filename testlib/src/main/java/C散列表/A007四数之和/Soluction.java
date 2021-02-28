package C散列表.A007四数之和;

import java.util.HashMap;

/**
 * Description: <Soluction><br>
 * Author:      mxdl<br>
 * Date:        2021/2/28<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Soluction {
    static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        int count = 0;
        for (int c : C) {
            for (int d : D) {
                if(map.containsKey(-c-d)){
                    count += map.get(-c-d);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};
        System.out.println(fourSumCount(A,B,C,D));
    }
}
