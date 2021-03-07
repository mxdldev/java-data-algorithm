package D栈队列.A001用数组实现一个栈;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack1<T> {
    private Deque<T> main = new LinkedList();
    private Deque<T> help = new LinkedList();

    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(3);
        System.out.println(myStack1.poll());
        System.out.println(myStack1.poll());
        myStack1.push(4);
        System.out.println(myStack1.peek());
        System.out.println(myStack1.poll());
        System.out.println(myStack1.poll());
    }

    public void push(T t) {
        main.offer(t);
    }

    public T poll() {
        //1.将主队列中的所有元素（除了了最后一个元素）导入辅助队列
        int size = main.size();
        size--;
        while (size-- > 0) {
            help.offer(main.poll());
        }
        //2.取出主队列中的元素
        T t = main.poll();
        //3.讲辅助队列中的所有元素赋值给主队列
        while (!help.isEmpty()) {
            main.offer(help.poll());
        }
        //4.清空辅助队列
        help.clear();
        return t;
    }

    public T peek() {
        return main.peekLast();
    }
}
