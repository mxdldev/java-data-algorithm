package A004数组是否有重复元素;

import java.util.HashSet;

/**
 * Description: <><br>
 * Author:      gxl<br>
 * Date:        2018/11/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainAlgorithm {
    public static void main(String[] arg){
        int[] arr = {11,3,10,11,34,5,21};
        System.out.println(checkRepeat(arr));
    }
    // 查找一个数组里面有没有重复元素
    private static boolean checkRepeat(int[] arr) {
        // 1.声明一个散列表表
        // 2.遍历这个数组
        // 3.对遍历的元素依次进行判断，如果散列表里面没有就往散列表里面塞，有就直接退出了
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashSet.contains(arr[i])) {
                return true;
            } else {
                hashSet.add(arr[i]);
            }
        }
        return false;
    }
}
