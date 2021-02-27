package Z2021.a0205;

import java.util.Arrays;

public class a03删组元 {
    static int[] deleteElement(int[] arr,int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                for(int j = i; j < arr.length - 1; j++){
                    arr[j] = arr[j+1];
                }
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(deleteElement(new int[]{2,4,6,8},4)));
    }
}
