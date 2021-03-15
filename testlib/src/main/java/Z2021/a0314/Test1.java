package Z2021.a0314;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Description: <Test1><br>
 * Author:      mxdl<br>
 * Date:        2021/3/14<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Test1 {
    //查找最大的非重复字符串
    static String getMaxStr(String s) {
        for (int len = s.length(); len > 1; len--) {
            for (int i = 0, j = len; i <= s.length() - len; i++, j = i + len) {
                boolean flag = false;
                HashSet<Character> set = new HashSet<>();
                for (int start = i; start <= j; start++) {
                    if (set.contains(s.charAt(start))) {
                        flag = true;
                        break;
                    }else{
                        set.add(s.charAt(start));
                    }
                }
                if (!flag) {
                    return s.substring(i, j+1);
                }
            }
        }
        return null;
    }

    static int getValue(int i){
        int index = 2;
        int prev = 0;
        int curr = 1;
        boolean flag = true;
        while (flag){
            int temp = curr;
            curr = prev + curr;
            prev = temp;
            index++;
            if(index == i){
                flag = false;
                return curr;
            }

        }
        return curr;
    }
    static int resverse(int num){
        int result = 0;
        while (num > 0){
            result = result * 10 + num%10;
            num /= 10;
        }
        return result;
    }
    static int get(int num,int n){
        int result = 1;
        while (n-- > 0){
            result *= num;
        }
        return result;
    }
    public static void main(String[] args) {
        //System.out.println(getMaxStr("aabccdfmmcs"));
        //System.out.println(getMaxStr("ababcddefacc"));
        //System.out.println(getValue(8));
        //System.out.println(resverse(1234));
        System.out.println(get(4,3));
    }
}
