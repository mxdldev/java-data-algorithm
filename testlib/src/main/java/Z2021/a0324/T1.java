package Z2021.a0324;

import java.io.IOException;

public class T1 {
    private volatile boolean running = true;
    private void m(){
        System.out.println("m start");
        while (running){

        }
        System.out.println("m end");
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        final T1 t = new T1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        }).start();
        Thread.sleep(1000);
        t.running = false;
    }
}
