package temp;

/**
 * Description: <><br>
 * Author:      mxdl<br>
 * Date:        2018/11/26<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MyQueue1 {
    int head = 0;
    int tail = 0;
    int[] arr;
    public MyQueue1(){
        arr = new int[10];
    }
    public boolean push(int value){
        if(head == (tail +1)%arr.length){
            System.out.println("队列已经满了");
            return false;
        }
        arr[tail] = value;
        tail = (tail +1)%arr.length;
        return true;
    }
    public int poll(){
        if(head == tail){
            System.out.println("队列已经空了");
            return 0;
        }
        int value = arr[head];
        arr[head] = 0;
        head = (head + 1)%arr.length;
        return value;

    }
}
