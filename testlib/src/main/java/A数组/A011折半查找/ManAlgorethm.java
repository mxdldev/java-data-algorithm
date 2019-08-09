package A数组.A011折半查找;

/**
 * Description: <ManAlgorethm><br>
 * Author:      mxdl<br>
 * Date:        2019/8/9<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class ManAlgorethm {
    //折半查找
    public static int getIndex(int[] arr,int value){
        int min = 0;
        int max = arr.length -1;
        int mid = 0;
        while (min < max){
            mid = (min + max)/2;
            if(value < arr[mid]){
                max = mid -1;
            }else if(value > arr[mid]){
                min = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    //二分查找法(折半查找法)
    public static int halfSearch(int[] arr,int number){
        int min =0;  //最小下标
        int max =arr.length-1;   //最大下标
        int mid = 0;  //中间下标
        while (min<max){
            //没找到,更新范围继续找
            mid = (min+max)/2;
            if (arr[mid]>number){   //number在mid的左边
                max = mid-1;  //改变最大下标
            }else if(arr[mid]<number){  //number在mid的右边
                min = mid+1;  //改变最小下标
            }else{
                return  mid;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,6,9,19,28};
        int index = getIndex(arr, 1);
        System.out.println(index);

    }
}
