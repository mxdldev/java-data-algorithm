package Z2021;

import java.util.HashMap;

/**
 * Description: <Test1><br>
 * Author:      mxdl<br>
 * Date:        2021/2/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Test1 {
    static String getIndex(int[] arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int key = target - arr[i];
            if(map.containsKey(key)){
                return i+","+map.get(key);
            }else{
                map.put(arr[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getIndex(new int[]{1,2,3,4},5));
    }
}
