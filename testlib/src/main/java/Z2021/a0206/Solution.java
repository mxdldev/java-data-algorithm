package Z2021.a0206;

import java.util.Arrays;

public class Solution {
    //1.查找插入元素的位置
    static int getInsertIndex(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    //2.删除数组中的元素
    static int[] removeNum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int j = i;
                while (j < nums.length - 1) {
                    nums[j] = nums[j + 1];
                    j++;
                }
            }
        }
        return nums;
    }

    //3.删除数组中的重复元素
    //3.1快慢指针法
    //3.2暴力法虐过
    static int[] removeRepeatNum(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length - 1; fast++) {
            if (nums[fast] != nums[fast + 1]) {
                nums[++slow] = nums[fast + 1];
            }
        }
        return nums;
    }

    //4.查找最小子数组的下标
    //4.1暴力法 窗口放大法
    //4.2窗口固定法
    //4.3滑动窗口
    static int[] searchMinArray(int[] nums, int target) {
        //1.控制窗口的大小
        for (int len = 1; len < nums.length; len++) {
            //2.控制累加,i窗口的开始位置，j窗口的结束位置
            for (int i = 0, j = len; i < nums.length - len; i++, j = len + i) {
                //0,1  1,2; 0,2 1,3
                int start = i;
                int end = j;
                int sum = 0;
                while (start <= end) {
                    sum += nums[start++];
                }
                if (sum >= target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    static int[] searchMinArray1(int[] nums, int target) {
        int slow = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int[] arr = {-1, -1};
        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            while (sum >= target) {
                int currLen = fast - slow;
                if (currLen < len) {
                    len = currLen;
                    arr[0] = slow;
                    arr[1] = fast;
                }
                sum -= nums[slow++];
            }
        }
        return arr;
    }

    //1.给一个n*n的旋转矩阵赋值
    static int[][] getArray(int n) {
        int[][] nums = new int[n][n];
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;
        int num = 1;
        while (num < n * n) {
            for (int i = left; i <= right; i++) {
                nums[top][i] = num++;
            }
            top++;
            for(int i = top; i <= bottom; i++){
                nums[i][right] = num++;
            }
            right--;
            for(int i = right; i >= left; i--){
                nums[bottom][i] = num++;
            }
            bottom--;
            for(int i = bottom; i >= top; i--){
                nums[i][left] = num++;
            }
            left++;
        }
        return nums;
    }

    public static void main(String[] args) {
//        System.out.println(getInsertIndex(new int[]{0, 1, 2, 4, 5}, 3));
//        System.out.println(Arrays.toString(removeNum(new int[]{0, 1, 2, 3, 4, 5}, 3)));
//        System.out.println(Arrays.toString(removeRepeatNum(new int[]{0, 0, 1, 1, 2, 2, 3, 3})));
        //System.out.println(Arrays.toString(searchMinArray(new int[]{1, 2, 5, 3, 1, 5, 1}, 7)));
        //System.out.println(Arrays.toString(searchMinArray1(new int[]{1, 2, 4, 3, 1, 5, 1}, 7)));
        getArray(4);
    }
}