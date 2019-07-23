package temp;

import java.util.Arrays;

/**
 * Description: <><br>
 * Author:      mxdl<br>
 * Date:        2018/11/26<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MyArrayList1 {
    int[] arr;
    int size = 5;
    int count = 0;
    public MyArrayList1(){
        arr = new int[size];
    }
    public void add(int value){
        if(count == arr.length){
            size = size * 2;
            arr = Arrays.copyOf(arr,size);
            System.out.println("扩容了...");
        }
        arr[count++] = value;
    }
    public int get(int index){
        return arr[index];
    }
}
