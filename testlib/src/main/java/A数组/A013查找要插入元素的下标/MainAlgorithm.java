package A数组.A013查找要插入元素的下标;

/**
 * Description: <MainAlgorithm><br>
 * Author:      mxdl<br>
 * Date:        2021/2/16<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class MainAlgorithm {
    //1.插入到数组所有元素的前面
    //2.插入到数组中所有元素的尾部
    //3.插入到数组的中间位置
    //4.插入的元素为数组的已有元素
    //时间复杂度为O(n)
    static int searchInsert(int[] arr,int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= target){
                return i;
            }
        }
        return arr.length;
    }
    //时间复杂度为O(logn)
    static int searchInsert1(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(target > arr[mid]){
                left = mid + 1;
            }else if(target < arr[mid]){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return right + 1;
    }
    public static void main(String[] args) {
        //System.out.println(searchInsert(new int[]{2,4,6,7,8},30));
        System.out.println(searchInsert1(new int[]{2,4,6,8},5));
    }
}
