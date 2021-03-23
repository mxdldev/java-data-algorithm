package Z2021.a0322;

import java.util.concurrent.locks.ReentrantLock;

public class PrintABC extends Thread {
    private Object curr;
    private Object next;
    private String value;
    public PrintABC(Object curr,Object next,String value){
        this.curr = curr;
        this.next = next;
        this.value = value;
    }
    @Override
    public void run() {
        int i = 0;
        while (i++ < 10) {
            synchronized (curr){
                synchronized (next){
                    System.out.println(value);
                    next.notify();
                }
                try {
                    if(i == 10){
                        Thread.currentThread().stop();
                    }
                    curr.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
       /* Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        PrintABC pa = new PrintABC(a,b,"a");
        PrintABC pb = new PrintABC(b,c,"b");
        PrintABC pc = new PrintABC(c,a,"c");

        pa.start();
        Thread.sleep(10);

        pb.start();
        Thread.sleep(10);

        pc.start();
        Thread.sleep(10);*/
        byte[] arr = {98,99,100};
        String s2 = new String(arr,0,arr.length);//将一个字节数组的一部分变成字符串。
        System.out.println("s2="+s2);
    }
}
