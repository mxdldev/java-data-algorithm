package G字符串.A005字符串空格替换;

public class Test {
    static String replaceBlack(String str) {
        //return str.replace(" ","%20");
        //计算空格的数量
        char[] chars = new char[str.length() * 3];
        int size = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            }else{
                chars[size++] = str.charAt(i);
            }
        }
        return new String(chars,0,size);
    }

    public static void main(String[] args) {
        System.out.println(replaceBlack("we are happay"));
    }
}
