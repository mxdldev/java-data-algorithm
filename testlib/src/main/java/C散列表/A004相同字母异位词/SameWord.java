package C散列表.A004相同字母异位词;

/**
 * Description: <SameWord><br>
 * Author:      mxdl<br>
 * Date:        2021/2/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class SameWord {
    static boolean sameWord(String str, String str1) {
        if (str.length() != str1.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            System.out.println(arr[str.charAt(i) - 97]+1);
            arr[str.charAt(i) - 97]++;
        }
        for (int i = 0; i < str1.length(); i++) {
            arr[str1.charAt(i) - 97]--;
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(sameWord("abc","bbc"));
    }
}
