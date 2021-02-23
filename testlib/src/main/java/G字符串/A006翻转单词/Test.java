package G字符串.A006翻转单词;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    static String reverseWord(String str) {
        String[] arr = str.split(" ");
        String result = "";
        for (String s : arr) {
            result = s + " " + result;
        }
        return result;
    }

    static String reverseWord1(String str) {
        str = str.trim();
        List<String> list = Arrays.asList(str.split("\\s+"));
        Collections.reverse(list);
        String result = String.join(" ", list);
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(reverseWord("wo shi shui"));
        //System.out.println(reverseWord1("  who  are you  "));
        StringBuffer s = removeSpace("  who    are  you    ");
        StringBuffer reverse = reverse(s, 0, s.length() - 1);
        System.out.println(reverse1(reverse));
    }
    //字符串去空格
    static public StringBuffer removeSpace(String str){
        int start = 0;
        int end = str.length() - 1;
        //去除前面的空格
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                break;
            }
            start++;
        }
        //去除后面的空格
        for(int i = end; i > -1; i--){
            if(str.charAt(i) != ' '){
                break;
            }
            end--;
        }
        StringBuffer buffer = new StringBuffer();
        //去除中间的空格
        while(start <= end){
            char c = str.charAt(start++);
            if(c != ' '){
                buffer.append(c);
            }else if(buffer.charAt(buffer.length() - 1) != ' '){
                buffer.append(" ");
            }
        }
        return buffer;
    }
    static StringBuffer reverse(StringBuffer stringBuffer,int start,int end){
        while (start <= end){
            char temp = stringBuffer.charAt(start);
            stringBuffer.setCharAt(start,stringBuffer.charAt(end));
            stringBuffer.setCharAt(end,temp);
            start++;
            end--;
        }
        return stringBuffer;
    }

    static String reverse1(StringBuffer buffer){
        int start = 0;
        int end = 0;
        int n = buffer.length();
        while (end < n){
            while (end < n && buffer.charAt(end) != ' '){
                end++;
            }
            reverse(buffer,start,end-1);
            end = end + 1;
            start = end;
        }
        return buffer.toString();
    }
}
