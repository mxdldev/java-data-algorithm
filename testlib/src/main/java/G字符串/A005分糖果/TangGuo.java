package G字符串.A005分糖果;

/**
 * Description: <TangGuo><br>
 * Author:      mxdl<br>
 * Date:        2021/2/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class TangGuo {
    public static void main(String[] args) {
            System.out.println(getMaxType(new int[]{1,2,3,1,1,1,1,1}));
    }
    static public int getMaxType(int[] tangguo){
        int[] arr = new int[200001];
        //糖果的种类计数
        for(int i = 0; i < tangguo.length; i++){
            arr[tangguo[i]+100000]++;
        }
        //记录糖果的种类
        int count = 0;
        for(int i = 0; i < arr.length;i++){
            if(arr[i] > 0){
                count++;
            }
        }
        int half = tangguo.length/2;
        return count > half ? half : count;
    }
}
