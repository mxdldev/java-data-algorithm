package C散列表.A003赎金信;

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
            if(index < 0){
                return false;
            }
            arr[c-97] = index + 1;
        }
        return true;
    }
    static boolean test1(String shujin,String zazhi){
        if(shujin.length() > zazhi.length()){
            return false;
        }
        int[] arr = new int[26];
        for(int i = 0; i < zazhi.length(); i++){
            arr[zazhi.charAt(i)-'a']++;
        }
        for(int i = 0; i < shujin.length(); i++){
            arr[shujin.charAt(i)-'a']--;
            if(arr[shujin.charAt(i)-'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
