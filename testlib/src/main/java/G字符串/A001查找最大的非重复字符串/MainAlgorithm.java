package G字符串.A001查找最大的非重复字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: <查找最大的非重复字符串><br>
 * Author:      mxdl<br>
 * Date:        2018/11/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainAlgorithm {
    public static void main(String[] args){
        String str = "ababcddefacc";
        System.out.println(lengthOfLongestSubstring(str));
    }
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

    public static String lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        String result = "";
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            String value = s.substring(i,rk+1);
            if(value.length() > result.length()){
                result = value;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return result;
    }
}
