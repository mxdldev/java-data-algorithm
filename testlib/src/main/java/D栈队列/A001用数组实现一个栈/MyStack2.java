package D栈队列.A001用数组实现一个栈;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack2<T> {
    private Deque<T> pushQueue = new LinkedList();
    private Deque<T> pollQueue = new LinkedList();

    public void push(T t){
        while (!pollQueue.isEmpty()){
            pushQueue.offer(pollQueue.pollLast());
        }
        pushQueue.offer(t);
    }
    public T poll(){
        if(pollQueue.isEmpty()){
            while (!pushQueue.isEmpty()){
                pollQueue.offer(pushQueue.pollLast());
            }
        }
        return pollQueue.poll();
    }
    public T peek(){
        if(pollQueue.isEmpty()){
            while (!pushQueue.isEmpty()){
                pollQueue.offer(pushQueue.pollLast());
            }
        }
        return pollQueue.peek();
    }
    public boolean isEmpty(){
        return pollQueue.isEmpty() && pushQueue.isEmpty();
    }
    public static void main(String[] args) {
        MyStack2<Integer> stack2 = new MyStack2<>();
        stack2.push(0);
        stack2.push(1);
        System.out.println(stack2.poll());
        System.out.println(stack2.peek());
        stack2.push(2);
        System.out.println(stack2.poll());
        System.out.println(stack2.poll());
    }

}
