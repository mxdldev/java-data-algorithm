package temp;

import java.util.TreeMap;

/**
 * Description: <TestString20190804><br>
 * Author:      mxdl<br>
 * Date:        2019/8/4<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class TestString20190804 {
    public static void main(String[] args){
        String ret = getStr("aa123bb12345666");
        System.out.println(ret);
    }
    //查找非重复字符串
    public static String getStr(String str){
        //重复的的正则表达式
        String reg = "(.)\\1+";
        String[] split = str.split(reg);
        String reult = "";
        for(String temp : split){
            if(temp.length() > reult.length()){
                reult = temp;
            }
        }
        return reult;
    }
}
