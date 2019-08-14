package temp;

/**
 * Description: <T1><br>
 * Author:      mxdl<br>
 * Date:        2019/8/12<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class T1 implements Runnable{
    private int age;
    public T1(){
        this.age = 88;
    }

    public String getAge(String name,int age) {
        return name+age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    static int a;
    static void test(){
        System.out.println("t1");
        int i = Integer.parseInt("1123");
        String s = Integer.toString(12);
    };

    @Override
    public void run() {

    }
}
