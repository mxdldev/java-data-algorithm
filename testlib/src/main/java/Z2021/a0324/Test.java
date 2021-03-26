package Z2021.a0324;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    //查找最小子数组的小标
    //1.滑动窗口：2,3,4,
    //2.快慢指针法
    static int[] getMinArray(int[] nums, int target) {
        int slow = 0;
        int result = 0;
        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        for (int fast = 0; fast < nums.length; fast++) {
            result += nums[fast];
            while (result > target && slow < fast) {
                result -= nums[slow++];
            }
            if (result == target) {
                if (len > fast - slow && slow < fast) {
                    start = slow;
                    end = fast;
                    len = fast - slow;
                }
            }
        }
        return new int[]{start, end};
    }

    //桶排序:核心思想以源数组的值作为新数组的下标，遍历一遍即可
    static int[] buketSort(int[] nums, int max) {
        int[] maxArr = new int[max + 1];
        for (int i : nums) {
            maxArr[i]++;
        }
        int index = 0;
        for (int i = 0; i < maxArr.length; i++) {
            if (maxArr[i] > 0) {
                nums[index++] = i;
            }
        }
        return nums;
    }

    //求二位数组左上到右下的路径数
    static int getPath(int m, int n) {
        try {
            int[][] arr = new int[m][n];
            //1.给第一行赋值
            for (int i = 0; i < n; i++) {
                arr[0][i] = 1;
            }
            //2.给第一列赋值
            for (int i = 0; i < m; i++) {
                arr[i][0] = 1;
            }
            //3.给其他元素赋值
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
            return arr[m - 1][n - 1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //3.求左上到右下的路径的最小值
    static int getMinValue(int[][] nums) {
        try {
            int m = nums.length;
            int n = nums[0].length;
            int[][] result = new int[m][n];
            //1.给元素1赋值
            result[0][0] = nums[0][0];
            //2.给第一行元素赋值
            for (int i = 1; i < n; i++) {
                result[0][i] = nums[0][i] + result[0][i - 1];
            }
            //3.给第一列元素赋值
            for (int i = 1; i < m; i++) {
                result[i][0] = nums[i][0] + result[i - 1][0];
            }
            //4.给其他元素赋值
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + nums[i][j];
                }
            }
            return result[m - 1][n - 1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //4.盛水最大的容器
    static int[] getMaxValue(int[] nums) {
        int result = 0;
        int min = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.min(nums[i], nums[j]) * (j - i) > result) {
                    min = i;
                    max = j;
                    result = Math.min(nums[i], nums[j]) * (j - i);
                }
            }
        }
        System.out.println(result);
        return new int[]{min, max};
    }

    static int getHalfIndx(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int[][] createArray(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[n - j -1][i] = nums[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(getMinArray(new int[]{1,2,3,5,6},5)));
        //System.out.println(Arrays.toString(buketSort(new int[]{5, 25, 2, 19}, 25)));
        //System.out.println(getPath(2, 3));
        //System.out.println(getMinValue(new int[][]{{1,2,3},{4,2,1}}));
        //System.out.println(Arrays.toString(getMaxValue(new int[]{5,25,2,19})));
        //System.out.println(getHalfIndx(new int[]{2, 3, 4, 12, 24, 35}, 12));
        //System.out.println(Arrays.toString(createArray(new int[][]{{0,1,2},{3,4,5},{6,7,8}})));

    }
}
