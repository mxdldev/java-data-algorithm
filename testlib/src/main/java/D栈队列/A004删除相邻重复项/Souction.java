package D栈队列.A004删除相邻重复项;

import java.util.Deque;
import java.util.LinkedList;

public class Souction {
    //leetcode 1047
    static String removeRepeatElement(String s){
        Deque<Character> stack = new LinkedList();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == ch){
                stack.poll();
            }else{
                stack.push(ch);
            }
        }
        String result = "";
        Character ch  = null;
        while ( (ch = stack.poll()) != null){
            result = ch + result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(removeRepeatElement("aaffbbaabcfaamaam"));
    }
}
