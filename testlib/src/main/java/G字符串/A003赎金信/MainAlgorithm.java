package G字符串.A003赎金信;

/**
 * Description: <MainAlgorithm><br>
 * Author:      mxdl<br>
 * Date:        2021/2/16<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class MainAlgorithm {
    public static void main(String[] args) {
        System.out.println(test("gxl","bxlg"));
    }
    static boolean test(String str,String str1){
        if(str.length() > str1.length()){
            return false;
        }
        int[] arr = new int[26];
        for(char c: str.toCharArray()){
            int index = str1.indexOf(c,arr[c-97]);
            if(index == -1){
                return false;
            }
            arr[c-97] = index + 1;
        }
        return true;
    }
}
