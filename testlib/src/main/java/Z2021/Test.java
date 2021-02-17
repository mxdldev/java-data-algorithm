package Z2021;

/**
 * Description: <Test><br>
 * Author:      mxdl<br>
 * Date:        2021/2/16<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Test {
    //1.求x的n次方
    static int test(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int result = test(x, n / 2);
        if (n % 2 == 1) {
            return result * result * x;
        }
        return result * result;
    }

    //2.求第那个培波那期数
    static int test1(int first, int second, int n) {
        if (n <= 0) {
            return 0;
        } else if (n < 3) {
            return 1;
        } else if (n == 3) {
            return first + second;
        } else {
            return test1(second, first + second, n - 1);
        }
    }
    //3.二分查找
    static int test3(int[] arr,int x){
        int start = 0;
        int end = arr.length;
        while (start <= end){
            int mid = (start + end)/2;
            if(x == arr[mid]){
                return mid;
            }else if(x > arr[mid]){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }
    //4.赎金信
    static boolean test4(String str,String str1){
        if(str.length() > str1.length()){
            return false;
        }
        int[] arr = new int[26];
//        for(int i = 0; i < str.length(); i++){
//            char c = str.charAt(i);
//            int index = str1.indexOf(c, arr[c - 97]);
//            if(index == -1){
//                return false;
//            }
//            arr[c-97] = index + 1;
//        }
        for(char c:str.toCharArray()){
            int index = str1.indexOf(c, arr[c - 97]);
            if(index == -1){
                return false;
            }
            arr[c-97] = index + 1;
        }
        return true;
    }
    public static void main(String[] args) {
        //System.out.println(test(2, 4));
        //System.out.println(test3(new int[]{1,2,5,13},13));
        System.out.println(test4("abdmcdhh","habcefdmhd"));
    }
}
