package Z2021;

import java.util.Arrays;

public class a04删重元 {
    //暴力破解法时间复杂度O（n2）
    //1.两两相比，只要相等则后面的元素往前移位
    //2.移位完毕i--,size--,依次循环
    static int[] removeRepeat(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i; j < length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                i--;
                length--;
            }
        }
        System.out.println(length);
        return nums;
    }
    //1.时间复杂度O(n)
    //2.快慢指针法
    static int[] removeRepeat1(int[] nums){
        int slow = 0;
        for(int fast = 0; fast < nums.length - 1; fast++){
            if (nums[fast] != nums[fast + 1]) {
                nums[++slow] = nums[fast + 1];
            }
        }
        System.out.println(slow + 1);
        return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeRepeat(new int[]{0, 0,0, 1, 1, 2, 2, 3, 3, 4, 4})));
        System.out.println(Arrays.toString(removeRepeat1(new int[]{0, 0,0, 1, 1, 2, 2, 3, 3, 4, 4})));
    }
}
