package I其他.A001求裴波那契数列第n项的值;

public class MainAlgorithm {
    public static void main(String[] args) {
        System.out.println(getNum(6));
    }
    //0,1,1,2,3,5,8...
    public static int getNum(int n){
        int value = 0;
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        return getNum(n-1) + getNum(n-2);
    }
}
