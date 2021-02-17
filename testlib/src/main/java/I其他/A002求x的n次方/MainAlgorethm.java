package I其他.A002求x的n次方;

/**
 * Description: <MainAlgorethm><br>
 * Author:      mxdl<br>
 * Date:        2021/2/14<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class MainAlgorethm {
    //求x的n次方
    //1.枚举法实现，时间复杂度为O(n)
    static long test(int x,int n){
        long result = 1;
        for(int i = 0; i < n; i++){
            result = result * x;
        }
        return result;
    }
    //2.递归实现,时间复杂度为O(n)
    //test(2,0) = 1
    //test(2,1) = test(2,0) * 2 = 1 * 2 = 2
    //test(2,2) = test(2,1) * 2 = test(2,0) * 2 * 2 =  1 * 2 * 2
    static long test1(int x,int n){
        if(n == 0){
            return 1;
        }
        return test1(x,n-1) * x;
    }
    //3.递归实现，时间复杂度为O(n)
    static int count = 0;
    static long test2(int x,int n){
        if(n == 0){
            return 1;
        }
        if(n % 2 == 1){
            System.out.println(++count);
            return test2(x,n/2) * test2(x,n/2)* x;
        }
        System.out.println(++count);
        return test2(x,n/2) * test2(x,n/2);
    }
    //4.递归实现，时间复杂度为O(logn)
    static long test3(int x,int n){
        if(n == 0){
            return 1;
        }
        System.out.println(++count);
        long result = test3(x, n / 2);
        if(n % 2 == 1){
            return result * result * x;
        }
        return result * result;
    }
    public static void main(String[] args) {
//        long startTime = System.nanoTime();
//        System.out.println(test(2,60));
//        long endTime = System.nanoTime();
//        System.out.println("time0:"+(endTime - startTime));
//
//        long startTime1 = System.nanoTime();
//        System.out.println(test1(2,60));
//        long endTime1 = System.nanoTime();
//        System.out.println("time1:"+(endTime1 - startTime1));
//
        long startTime2 = System.nanoTime();
        System.out.println(test2(2,16));
        long endTime2 = System.nanoTime();
        System.out.println("time2:"+(endTime2 - startTime2));

//        long startTime3 = System.nanoTime();
//        System.out.println(test3(2,16));
//        long endTime3 = System.nanoTime();
//        System.out.println("time3:"+(endTime3 - startTime3));
        //System.out.println(test1(2,10));

    }
}
