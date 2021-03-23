package Z2021.a0322;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    static int[] sortArr(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
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

    static int[] sortArr1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
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

    static int[] bucketArr(int[] nums, int max) {
        int[] source = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            source[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < source.length; i++) {
            if (source[i] > 0) {
                nums[index++] = i;
            }
        }
        return nums;
    }

    static Integer[] removeArrRepeat(Integer[] nums) {
        int len = nums.length;
        int slow = 0;
        slow = 1;//根据排序过后的数据特点进行去重复
        for (int fast = 0; fast < len - 1; fast++) {
            if (nums[fast] != nums[fast + 1]) {
                nums[slow++] = nums[fast + 1];
            }
        }
        return Arrays.copyOf(nums, slow);
    }

    static Integer[] removeArrRepeat1(Integer[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        Integer[] ints = new Integer[set.size()];
        set.toArray(ints);
        return ints;
    }
    static int[] removeArrayRepeat2(int[] nums){
        //暴力法，两两对比，只要发现相等就压缩数组
        loop: for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    while (j < nums.length - 1){
                        nums[j] = nums[j+1];
                        j++;
                    }
                    nums = Arrays.copyOf(nums,nums.length -1);
                    i = 0;
                    continue loop;
                }
            }
        }
        return nums;
    }
    static int[] searchMinArray(int[] nums, int target){
        for(int len = 1; len < nums.length; len++){
            for(int i = 0, j = len; i < nums.length - len; i++,j = i + len){
                int start = i;
                int end = j;
                int result = 0;
                while (start <= end){
                    result += nums[start];
                    start++;
                }
                if(result == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArr(new int[]{5, 25, 2, 19})));
        System.out.println(Arrays.toString(sortArr1(new int[]{5, 25, 2, 19})));
        System.out.println(Arrays.toString(bucketArr(new int[]{5, 25, 2, 19}, 25)));
        System.out.println(Arrays.toString(removeArrRepeat(new Integer[]{2,23,32,23,0, 0, 1, 1, 2, 2, 2, 3, 4})));
        System.out.println(Arrays.toString(removeArrRepeat1(new Integer[]{2,23,32,23,0, 0, 1, 1, 2, 2, 2, 3, 4})));
        //System.out.println(Arrays.toString(removeArrayRepeat2(new int[]{2,23,32,23,0, 0, 1, 1, 2, 2, 2, 3, 4})));
        System.out.println(Arrays.toString(searchMinArray(new int[]{5,25,2,19},27)));

        System.out.println("5+5="+5+5);
   }
}
