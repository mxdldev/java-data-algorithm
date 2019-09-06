package _mxdl.easy._010;


/**
 * Description: <判断一个整数是否是回文数><br>
 * Author:      mxdl<br>
 * Date:        2019/9/5<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class Soluction {
    public boolean isPlalindrome(int x){
        int soucre = x;
        int res = 0;
        for(; x > 0 ; x /= 10){
            res = res * 10 + x % 10;
        }
        return res == soucre;
    }
    public static void main(String[] args){
        Soluction solution = new Soluction();
        boolean plalindrome = solution.isPlalindrome(123432112);
        System.out.println(plalindrome);
    }
}
