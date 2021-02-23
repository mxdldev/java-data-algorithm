package G字符串.A007字符串翻转2;

public class Test {
    //每间隔2k个字符对前k个字符进行翻转
    static String reverse(String str, int k) {
        char[] chars = str.toCharArray();
        for (int i = 0, j = 0; j < chars.length; i++, j = i * k * 2) {
            System.out.println(j);
            System.out.println("--------------------------");
            int i1 = j + k - 1;
            if(i1 >= chars.length){
                i1 = chars.length - 1;
            }
            System.out.println(j + "," + i1);
            reverse1(chars,j, i1);
        }
        return new String(chars);
    }
    static String reverse2(String str, int k) {
        char[] chars = str.toCharArray();
        for (int i = 0 ;i < chars.length; i+= 2*k) {
            System.out.println("--------------------------");
            int j = i + k - 1;
            if(j >= chars.length){
                j = chars.length - 1;
            }
            System.out.println(i + "," + j);
            reverse1(chars,i, j);
        }
        return new String(chars);
    }
    static void reverse1(char[] chars, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
         char temp = chars[i];
         chars[i] = chars[j];
         chars[j] = temp;
        }

    }

    public static void main(String[] args) {
        System.out.println(reverse("abcdefghijklmn", 2));
    }
}
