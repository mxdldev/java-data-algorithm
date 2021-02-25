package Z2021;

public class a02二查找 {
    //查找要插入元素的下标
    //1.枚举法时间复杂度，只要发现target比当前元素小就返回当前元素的下标
    static int insertIndex(int[] arr,int target){
        for(int i = 0;i < arr.length; i++){
            if(target <= arr[i]){
                return i;
            }
        }
        return -1;
    }
    //二分查找法
    static int insertIndex1(int[] arr,int target){
        int start = 0;
        int end = arr.length -1;
        while (start < end){
            int mid = (start + end)/2;
            if(target > arr[mid]){
                start = mid + 1;
            }else if(target < arr[mid]){
                end = mid - 1;
            }else{
                return mid;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        System.out.println(insertIndex(new int[]{2,4,6,8},7));
        System.out.println(insertIndex1(new int[]{2,4,6,8},4));
    }
}
