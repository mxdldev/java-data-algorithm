package H基本类型.A001翻转一个整数;

/**
 * Description: <翻转一个整数><br>
 * Author:      gxl<br>
 * Date:        2018/11/22<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainAlgorithm {
    public static void main(String[] args){
        int data = 123456;
        System.out.println(reversInt(data));
    }

    private static int reversInt(int data) {
        int result = 0;//-2,147,483,648-2,147,483,647
        while(data > 0){
            result = result * 10 + data%10;
            data = data/10;
            System.out.println(data);
        }
        return result;
    }
}
