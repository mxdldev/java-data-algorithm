package temp;

/**
 * Description: <Test><br>
 * Author:      mxdl<br>
 * Date:        2021/2/15<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Test {
    public static void main(String[] args) {
        //System.out.println("bcda".indexOf('a',0));
        System.out.println(canConstruct("aaa","bada"));
    }
        static public boolean canConstruct(String ransom, String magazine) {
            if (magazine.length() < ransom.length()) return false;
            int caps[] = new int[26];
            for (char c : ransom.toCharArray()) {
                int index = magazine.indexOf(c,caps[c - 'a']);
                if (index == -1)
                    return false;
                caps[c - 97] = index + 1;
            }
            return true;
        }

}
