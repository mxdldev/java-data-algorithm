package I其他.A001求裴波那契数列第n项的值;

public class MainAlgorithm {
    //0,1,1,2,3,5,...
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(getNum1(6));
        System.out.println(getNum2(1,1,6));
    }
    //时间复杂度为O(n),空间复杂度为O(1)
    static int getNum(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int first = 1;
        int sedond = 1;
        int sum = 0;
        for(int i = 2; i < n; i++){
            sum = first + sedond;
            first = sedond;
            sedond = sum;
        }
        return sum;
    }

    //递归：时间复杂度为O(2^n),空间复杂度为O(n)
    static int getNum1(int n) {
        if (n <= 0) {
            return 0;
        }
        /*if (n == 1 || n == 2) {
            return 1;
        }*/
        if (n == 1) {
            return 1;
        }
        System.out.println(++count);
        int num = getNum(n - 1);
        System.out.println(++count);
        int num1 = getNum(n - 2);
        return num + num1;
    }
    //时间复杂度为O(n),空间复杂度为O(n)
    static int getNum2(int first,int second,int n){
        if(n <= 0){
            return 0;
        }else if(n < 3){
            return 1;
        }else if(n == 3){
            return first + second;
        }else{
            return getNum2(second,first + second,n-1);
        }
    }
}
