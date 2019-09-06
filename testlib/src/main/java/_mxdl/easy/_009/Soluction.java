package _mxdl.easy._009;


/**
 * Description: <Soluction><br>
 * Author:      mxdl<br>
 * Date:        2019/9/5<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class Soluction {
    public int lengthOfLongestSubstring(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        int preP = 0, max = 0;
        int[] hash = new int[128];
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (hash[c] > preP) {
                preP = hash[c];
            }
            int l = i - preP + 1;
            hash[c] = i + 1;
            if (l > max) {
                max = l;
            }
        }
        return max;
    }
    public static void main(String[] args){
        String str = "abacdeefc";
        Soluction soluction = new Soluction();
        int i = soluction.lengthOfLongestSubstring(str);
        System.out.println(i);
    }
}
