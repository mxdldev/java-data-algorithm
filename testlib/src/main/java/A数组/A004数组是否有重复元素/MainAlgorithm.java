package A数组.A004数组是否有重复元素;

import java.util.HashSet;

/**
 * Description: <数组是否有重复元素><br>
 * Author: mxdl<br>
 * Date: 2018/11/21<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {
    public static void main(String[] arg) {
        int[] arr = {11, 3, 10, 11, 34, 5, 21};
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

    //解法2：先对数组中的元素进行排序，排序完毕再两两对比
    /* 解法3：
     * 遍历数组，当遍历到下标为i的数字时，首先比较arr[i]是否等于i
     * 如果arr[i]等于i，则遍历下一个数字；
     * 如果arr[i]不等于i，且arr[arr[i]]不等于arr[i]，则交换这两个元素的值；
     * 如果arr[i]不等于i，且arr[arr[i]]等于arr[i]，则该元素为重复数字
     */
    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length < 2 || length < 2 ||
                duplication == null || duplication.length == 0)
            return false;
        boolean hasDuplicate = false;
        int i = 0;
        while (i < length) {
            int m = numbers[i];
            if (m == i) {
                ++i;
            } else if (numbers[m] != m) {
                numbers[i] = numbers[m];
                numbers[m] = m;
            } else {
                hasDuplicate = true;
                duplication[0] = m;
                break;
            }
        }
        return hasDuplicate;
    }
}
