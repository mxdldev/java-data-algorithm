package I2019.A003;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Description: <ReView01Array><br>
 * Author:      mxdl<br>
 * Date:        2019/8/31<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class ReView01Array {
    public static void main(String[] args) {
        //int[] nums = {4, 2, 8, 5, 3, 6, 7, 1};
        //int[] nums = {4, 2, 2, 4,5,2,1,4,1};
        //int[] ints = buddleSort(nums);
        //int[] ints = selectSort(nums);
        //int[] ints = bucketSort(nums, 8);
        //System.out.println(Arrays.toString(ints));
//        for(int i = 0; i < ints.length; i++){
//            if(ints[i] > 0){
//                System.out.println(i);
//            }
//        }
        //boolean repeatNum = isRepeatNum(nums);
        //System.out.println(repeatNum);
        //int[] ints1 = removeRepeadNum(nums);
//        int[] nums = {4, 2, 8, 5};
//        int[] ints = searchIndexSum(nums, 9);
//        System.out.println(Arrays.toString(ints));
        //int pathNum = getPathNum(3, 2);
        //System.out.println(pathNum);
        int[][] nums = {{5,4,2},{1,2,3}};
        int minPath = getMinPath(nums);
        System.out.println(minPath);
    }

    //1.冒泡排序
    public static int[] buddleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    //2.选择排序
    public static int[] selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    //3.桶排序
    public static int[] bucketSort(int[] nums, int max) {
        int[] arr = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        return arr;
    }

    //4.查找数组中有没有重复元素
    public static boolean isRepeatNum(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            }
            hashSet.add(nums[i]);
        }
        return false;
    }

    //5.删除数组的中的重负元素；法1：
    public static int[] removeRepeadNum(int[] nums) {
        loop:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    while (j < nums.length - 1) {
                        nums[j] = nums[j + 1];
                        j++;
                    }
                    nums = Arrays.copyOf(nums, nums.length - 1);
                    i = -1;//这是个坑，要注意了 哈哈哈。。。。
                    continue loop;
                }
            }
        }
        return nums;
    }

    //6.两数求和找下标
    public static int[] searchIndexSum(int[] nums, int sum) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = sum - nums[i];
            if (hashMap.containsKey(value)) {
                return new int[]{i, hashMap.get(value)};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

    //7.已知m*n的二维数组，求左上到右下的路径数
    public static int getPathNum(int m, int n) {
        int[][] nums = new int[m][n];
        //给第一行都赋值为；
        for (int i = 0; i < n; i++) {
            nums[0][i] = 1;
        }
        //给第一列赋值
        for (int i = 0; i < m; i++) {
            nums[i][0] = 1;
        }
        //给从小标从1，1开始的元素进行赋值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
            }
        }
        return nums[m - 1][n - 1];
    }

    //8.求左上到右下的最小路径和
    public static int getMinPath(int[][] nums) {
        //创建一个等大的二维数组
        int m = nums.length;
        int n = nums[0].length;
        int[][] arr = new int[m][n];
        //给第一个元素赋值
        arr[0][0] = nums[0][0];
        //给第一行元素赋值
        for (int i = 1; i < n; i++) {
            arr[0][i] = arr[0][i - 1] + nums[0][i];
        }
        //给第一列元素赋值
        for (int i = 1; i < m; i++) {
            arr[i][0] = arr[i - 1][0] + nums[i][0];
        }
        //给从1，1开始的其他元素赋值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = Math.min(arr[i - 1][j], arr[i][j - 1]) + nums[i][j];
            }
        }
        return arr[m - 1][n - 1];
    }

}
