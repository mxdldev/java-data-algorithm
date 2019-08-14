package temp;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description: <T2><br>
 * Author:      mxdl<br>
 * Date:        2019/8/12<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class T2 {
    public static void main(String[] args){

      Class<T1> t1Class = T1.class;
        try {
            Constructor<T1> constructor = t1Class.getConstructor();
            T1 o = constructor.newInstance();
            Method ageMethord = t1Class.getMethod("getAge",String.class,float.class);
            String res = (String) ageMethord.invoke(o,"gxl",11112);
            System.out.println("age2:"+res);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    static void test(){
        System.out.println("t2");
    };
}
