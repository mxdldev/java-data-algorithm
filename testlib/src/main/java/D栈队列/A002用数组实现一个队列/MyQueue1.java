package D栈队列.A002用数组实现一个队列;

import java.util.Stack;

public class MyQueue1<T> {
    //232
    //225
    private Stack<T> pushStack = new Stack<>();
    private Stack<T> pollStack = new Stack<>();

    public void push(T t) {
        pushStack.push(t);
    }

    public T poll() {
        if (pollStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                pollStack.push(pushStack.pop());
            }
        }
        return pollStack.pop();
    }

    public T peek() {
        T t = poll();
        pollStack.push(t);
        return t;
    }

    public boolean isEmpty() {
        return pushStack.isEmpty() && pollStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue1<Integer> myQueue2 = new MyQueue1<>();
        myQueue2.push(1);
        myQueue2.push(2);
        myQueue2.push(3);

        System.out.println(myQueue2.poll());
        System.out.println(myQueue2.poll());

        myQueue2.push(4);
        myQueue2.push(5);
        System.out.println(myQueue2.poll());
        System.out.println(myQueue2.poll());
        //System.out.println(myQueue2.poll());
        System.out.println("----------------------------");
        System.out.println(myQueue2.peek());
        System.out.println(myQueue2.poll());
        myQueue2.push(6);
        System.out.println(myQueue2.poll());
    }
}
