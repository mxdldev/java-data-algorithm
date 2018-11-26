package temp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description: <><br>
 * Author:      gxl<br>
 * Date:        2018/11/26<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MyStack1 {
    int[] arr;
    int size = 5;
    int count = 0;
    public MyStack1(){
        arr = new int[size];
    }
    public boolean push(int value){
        if(count == size){
            size = size *2;
            arr = Arrays.copyOf(arr,size);
        }
        arr[count++] = value;
        return true;
    }
    public int pop(){
        return arr[--count];
    }
}
