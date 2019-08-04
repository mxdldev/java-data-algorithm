package temp;

/**
 * Description: <TestInteger20190804><br>
 * Author:      mxdl<br>
 * Date:        2019/8/4<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class TestInteger20190804 {
    public static void main(String[] args){
        int val = 123;
        int ret = reverInt(val);
        System.out.println(ret);
    }

    public static int reverInt(int val){
        int ret = 0;
        while(val > 0){
            ret = ret *10 + val%10;
            val /= 10;
        }
        return ret;
    }
}
