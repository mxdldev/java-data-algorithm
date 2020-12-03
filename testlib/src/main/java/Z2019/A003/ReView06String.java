package Z2019.A003;

/**
 * Description: <ReView06String><br>
 * Author:      mxdl<br>
 * Date:        2019/9/1<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class ReView06String {
    //1.查找最大的非重复字符串
    public static String searchMaxStr(String result) {
        //String reg = "\\.(1)+";
        String reg1 = "(.)\\1+";//******************
        String[] split = result.split(reg1);
        String maxStr = "";
        for (String str : split) {
            if (str.length() > maxStr.length()) {
                maxStr = str;
            }
        }
        return maxStr;
    }

    public static String getLongText(String str) {
        boolean[][] arr = new boolean[str.length()][str.length()];
        int maxLen = 0;
        String longText = "";
        for (int i = 0; i < str.length(); i++) {
            arr[i][i] = true;
            maxLen = 1;
        }

        for (int i = 0; i < str.length()-1; i++) {//*****
            if (str.charAt(i) == str.charAt(i + 1)) {
                arr[i][i + 1] = true;
            }
            maxLen = 2;
        }
        for (int len = 3; len < str.length(); len++) {
            for (int i = 0, j = 0; (j = len + i - 1) < str.length(); i++) {//******
                    if(str.charAt(i) == str.charAt(j)){
                        arr[i][j] = arr[i+1][j-1];
                        if(arr[i][j] && maxLen < len){
                            longText = str.substring(i,j+1);
                            maxLen = len;
                        }
                    }else{
                        arr[i][j] = false;
                    }
            }
        }
        return longText;
    }
    public static String getLongText1(String str){
        boolean[][] arr = new boolean[str.length()][str.length()];
        int maxLen = 0;
        String longText = "";
        for(int i = 0;i < str.length();i++){
            arr[i][i] = true;
            maxLen = 1;
        }
        for(int i = 0;i < str.length()-1 ;i++){
            if(str.charAt(i) == str.charAt(i+1)){
                arr[i][i+1] = true;
                maxLen = 2;
            }
        }
        for(int len = 3; len < str.length();len++){
            for(int i = 0,j = 0; (j=len+i-1)<str.length();i++){
                if(str.charAt(i) == str.charAt(j)){
                    arr[i][j] = arr[i+1][j-1];
                    if(arr[i][j] && maxLen < len){
                        longText = str.substring(i,j+1);
                        maxLen = len;                    }
                }else{
                    arr[i][j] = false;
                }
            }
        }
        return longText;
    }
    public static void main(String[] args) {
        //String value = searchMaxStr("abcaabb23435dd987ff");
        //System.out.println(value);
        String result = getLongText1("ac1d2ff2d1db");
        System.out.println(result);

    }
}
