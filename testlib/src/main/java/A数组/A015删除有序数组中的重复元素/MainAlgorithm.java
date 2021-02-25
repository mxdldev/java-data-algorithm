package A数组.A015删除有序数组中的重复元素;

import java.util.Arrays;

/**
 * Description: <MainAlgorithm><br>
 * Author:      mxdl<br>
 * Date:        2021/2/16<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class MainAlgorithm {
    //快慢指针法
    static int removeRepeatElement(int[] nums){
        int slowIdnex = 0;
        for(int fastIndex = 0; fastIndex < nums.length - 1; fastIndex++){
            if(nums[fastIndex] != nums[fastIndex + 1]){
                nums[++slowIdnex] = nums[fastIndex + 1];
            }
        }
        System.out.println(Arrays.toString(nums));
        return slowIdnex + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeRepeatElement(new int[]{0,0,0,2,2,3,3}));
    }

}
