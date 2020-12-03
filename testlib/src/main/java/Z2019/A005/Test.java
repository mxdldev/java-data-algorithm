package Z2019.A005;

import java.util.Random;

/**
 * Description: <Test><br>
 * Author:      mxdl<br>
 * Date:        2019/9/20<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class Test {
    public static int random(){
        Random random = new Random();
        return random.nextInt(100);
    }
    public static void main(String[] args){
        System.out.println(random());
    }
}
