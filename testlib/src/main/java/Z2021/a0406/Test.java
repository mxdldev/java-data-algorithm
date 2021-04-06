package Z2021.a0406;

public class Test {
    static boolean isHappy(int num){
        int result = 0;
        if(num == 1){
            return true;
        }
        while (num > 0){
            int n = num % 10;
            result += n * n;
            num = num/10;
        }
        return isHappy(result);
    }

    public static void main(String[] args) {
        //System.out.println(isHappy(123));
        System.out.println(isHappy(12));
    }
}
