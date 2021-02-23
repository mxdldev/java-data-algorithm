package G字符串.A004原地翻转字符串;

public class Test {
    //这和翻转链表一样的逻辑
    static String reverse(String str) {
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            temp = str.charAt(i) + temp;
        }
        return temp;
    }

    //将字符串转为字符数组
    static String reverse1(String str) {
        char[] chars = str.toCharArray();
        String temp = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            temp += chars[i];
        }
        return temp;
    }

    static String reverse2(String str) {
        char[] chars = str.toCharArray();
        for (int left = 0, right = chars.length - 1; left < right; left++, right--) {
            char l = chars[left];
            chars[left] = chars[right];
            chars[right] = l;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverse("mxdl"));
        System.out.println(reverse1("mxdl"));
        System.out.println(reverse2("mxdl"));
    }
}
