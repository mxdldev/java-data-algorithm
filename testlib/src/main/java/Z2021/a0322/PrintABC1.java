package Z2021.a0322;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class PrintABC1 extends Thread {
    ReentrantLock lock;
    Condition curr;
    Condition next;
    String value;

    public PrintABC1(ReentrantLock lock, Condition curr, Condition next, String value) {
        this.lock = lock;
        this.curr = curr;
        this.next = next;
        this.value = value;
    }

    @Override
    public void run() {
        int i = 0;
        while (i++ < 10) {
            try {
                lock.lock();
                System.out.println(value);
                next.signal();
                curr.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();

        PrintABC1 pa = new PrintABC1(lock,a,b,"a");
        PrintABC1 pb = new PrintABC1(lock,b,c,"b");
        PrintABC1 pc = new PrintABC1(lock,c,a,"c");

        pa.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pb.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pc.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
