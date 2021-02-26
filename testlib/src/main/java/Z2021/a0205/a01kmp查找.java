package Z2021.a0205;

import java.util.Arrays;

public class a01kmp查找 {
    //查找一个字符串是否在另外一个
    public static void main(String[] args) {
        String needle = "aabaa";
        String haystack = "abcdaabaae";
        System.out.println(searchStr1(needle, haystack));
        //System.out.println(1/0);
    }

    //1.暴力查找法，时间复杂度为O(n)
    private static int searchStr(String needle, String haystack) {
        for (int i = 0; i < haystack.length(); i++) {
            int j = i + needle.length();
            if (j < haystack.length() && needle.equals(haystack.substring(i, j))) {
                return i;
            }
        }
        return -1;
    }
    //时间复杂度为O（n+m）
    static int searchStr1(String needle, String haystack) {
        //构建next数组
        int[] next = new int[needle.length()];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < needle.length(); i++) {
            while (j >= 0 && needle.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (needle.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        System.out.println(Arrays.toString(next));

        j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && needle.charAt(j + 1) != haystack.charAt(i)) {
                j = next[j];//回溯
            }
            if (needle.charAt(j + 1) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

}
