package I2019.A003;

/**
 * Description: <ReView05Int><br>
 * Author:      mxdl<br>
 * Date:        2019/9/1<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class ReView05Int {
    //1.翻转一个整数
    public static int revertInt(int num) {
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num = num / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = revertInt1(123);
        System.out.println(result);
    }

    public static int revertInt1(int num) {
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num = num / 10;
        }
        return result;
    }
}
