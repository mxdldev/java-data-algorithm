package F字符串.A001查找最大的非重复字符串;

/**
 * Description: <><br>
 * Author:      gxl<br>
 * Date:        2018/11/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainAlgorithm {
    public static void main(String[] args){
        String str = "aaibbzoveccyou";
        String[] split = str.split("(.)\\1+");
        int i = 1;
        String max = split[0];
        while(i < split.length){
            if(split[i].compareTo(max) > 1){
                max = split[i];
            }
            i++;
        }
        System.out.println(max);

    }


}
