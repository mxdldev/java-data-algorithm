package Z2021.a0206;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class a03求两个数组的交集 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getArray(new int[]{1,2,3,4},new int[]{2,4,5,6,1})));
    }

    static int[] getArray(int[] arr, int[] arr1) {
        int[] max = arr;
        int[] min = arr1;
        if (arr.length < arr1.length) {
            max = arr1;
            min = arr;
        }
        Set<Integer> set = new HashSet<>();
        for (Integer num : max) {
            set.add(num);
        }
        Set<Integer> com = new HashSet<>();
        for (Integer num : min) {
            if(set.contains(num)){
                com.add(num);
            }
        }
        int[] arr2 = new int[com.size()];
        int index = 0;
        for(Integer num:com){
            arr2[index++] = num;
        }
        return arr2;
    }
}
