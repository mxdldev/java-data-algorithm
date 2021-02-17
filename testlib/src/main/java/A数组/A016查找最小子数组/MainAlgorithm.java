package A数组.A016查找最小子数组;

import java.util.Arrays;

/**
 * Description: <MainAlgorithm><br>
 * Author:      mxdl<br>
 * Date:        2021/2/17<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class MainAlgorithm {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(test1(new int[]{2, 4, 1, 2, 4, 1}, 7)));
        System.out.println(minSubArrayLen(new int[]{3, 4, 1, 2, 4, 1}, 7));
        System.out.println(minSubArrayLen1(new int[]{3, 2, 1, 1, 3, 0}, 7));
    }
    //1.方法1
    static int[] test1(int[] nums, int target) {
        for (int len = 2; len < nums.length; len++) {
            for (int i = 0, j; (j = i + len - 1) < nums.length; i++) {
                int t = 0;
                int start = i;
                int end = j;
                while (start <= end) {
                    int i1 = start++;
                    if (i1 < nums.length) {
                        t = t + nums[i1];
                    }
                }
                if (t == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    //2.方法2
    static int minSubArrayLen(int[] nums,int target){
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                int len = j - i + 1;
                if(sum >= target){
                    minLen = len < minLen ? len : minLen;
                    break;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    //3.滑动窗口
    static int minSubArrayLen1(int[] nums,int target){
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for(int end = 0; end < nums.length; end++){
            sum += nums[end];
            while (sum >= target){
                int len = end - start + 1;
                minLen = len < minLen ? len: minLen;
                sum -= nums[start++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
