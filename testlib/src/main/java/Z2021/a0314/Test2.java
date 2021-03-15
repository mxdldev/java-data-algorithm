package Z2021.a0314;

public class Test2 {
    static int getNum(int prev, int curr, int m, int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (m == n) {
            return curr;
        }
        return getNum(curr, prev + curr, ++m, n);
    }
    static int getNum1(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return getNum1(n-1) + getNum1(n-2);
    }
    static int getXn(int x,int n){
        int result = 1;
        while (n-- > 0){
            result *= x;
        }
        return result;
    }
    public static void main(String[] args) {
//        System.out.println(getNum(0, 1, 2, 6));
//        System.out.println(getNum1(6));
        System.out.println(getXn(2,3));

    }
}
