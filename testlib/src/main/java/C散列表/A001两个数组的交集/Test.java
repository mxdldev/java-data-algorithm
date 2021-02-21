package C散列表.A001两个数组的交集;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Description: <Test><br>
 * Author:      mxdl<br>
 * Date:        2021/2/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Test {
    static int[] test(int[] arr, int[] arr1) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
        }
        if(set.size() > set1.size()){
            Set s = set;
            set = set1;
            set1 = s;
        }
        Iterator<Integer> iterator = set.iterator();
        Set<Integer> temp = new HashSet<>();
        for(Integer num:set){
            if(set1.contains(num)){
                temp.add(num);
            }
        }
        int[] arr3 = new int[temp.size()];
        int i = 0;
        for(Integer num:temp){
          arr3[i++] = num;
        }
        return arr3;
    }

    public static void main(String[] args) {
        int[] test = test(new int[]{1,2,3,4}, new int[]{3,4,5,6,7});
         System.out.println("ok");
    }
}
