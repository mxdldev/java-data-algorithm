package A数组.A014删除数组中的元素;

/**
 * Description: <Test><br>
 * Author:      mxdl<br>
 * Date:        2021/2/16<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class MainAlgorithm {
    static int removeElement(int[] nums,int target){
        int length = nums.length;
        for(int i = 0; i < length; i++){
            if(nums[i] == target){
                for(int j = i + 1; j < length; j++){
                    nums[j-1] = nums[j];
                }
                i--;
                length--;
            }
        }
        int[] a = nums;
        return length;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1,3,5,7,8,10},3));
    }
}
