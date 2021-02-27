package Z2021.a0205;

import java.util.Arrays;

public class a05查找最小子组 {
    //1.暴力法
    static int[] searchMinArr(int[] arr, int target) {
        for (int len = 1; len < arr.length; len++) {
            for (int i = 0, j = len; i < arr.length - len; i++, j = i + len) {
                //int j = i + len;
                System.out.println(i + "," + j);
                int result = 0;
                for (int m = i; m <= j; m++) {
                    result += arr[m];
                }
                if (result == target) {
                    return new int[]{i, j};
                }
            }
            System.out.println("--------------------------");
        }
        return null;
    }

    //2.滑动窗口法
    static int[] searchMainArr1(int[] nums, int target) {
        int maxLen = Integer.MAX_VALUE;
        int arr[] = new int[2];
        //1.定位窗口的开始位置
        int start = 0;
        int sum = 0;//窗口内元素的和
        //2.循环窗口的结束位置
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum == target) {
                int len = end - start + 1;
                if(len < maxLen){
                    maxLen = len <= maxLen ? len : maxLen;
                    arr[0] = start;
                    arr[1] = end;
                }
                sum -= nums[start++];//;改变窗口的大小
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchMinArr(new int[]{6, 1, 3, 1, 3, 4, 1, 2, 4, 2, 3}, 7)));
        System.out.println(Arrays.toString(searchMainArr1(new int[]{3,6, 3, 3, 1, 3, 4, 1, 2, 4, 2, 3}, 7)));
    }
}
