package Z2021.a0312;

public class Test {
    static void perKmp(int[] next,String needle){
        next[0] = -1;
        int j = -1;
        for(int i = 1; i < needle.length(); i++){
            while (j >= 0 && needle.charAt(i) != needle.charAt(j + 1)){
                j = next[j];
            }
            if(needle.charAt(i) == needle.charAt(j + 1)){
                j++;
            }
            next[i] = j;
        }
    }
    static int strStr(String hpyStack,String needle){
        int[] next = new int[needle.length()];
        perKmp(next,needle);
        int j = -1;
        for(int i = 0; i < hpyStack.length(); i++){
            while (j >= 0 && hpyStack.charAt(i) != needle.charAt(j + 1)){
                j = next[j];
            }
            if(hpyStack.charAt(i) == needle.charAt(j + 1)){
                j++;
            }
            if(j == needle.length() - 1){
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("aabaabaafcd","aabaaf"));
    }
}
