package D栈队列.A002用数组实现一个队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue1 {
    //232
    //225
    private Deque<Integer> pushStack;
    private Deque<Integer> popStack;

    public MyQueue1() {
        pushStack = new ArrayDeque<>();
        popStack = new ArrayDeque<>();
    }

    public void push(int x) {
        // 在任何时候都可以向 pushStack 推入元素
        pushStack.addLast(x);
    }

    public int pop() {
        // 从 popStack 取出元素
        if (!popStack.isEmpty()) {
            return popStack.removeLast();
        }
        // 走到这里是因为 popStack 为空，此时需要将 pushStack 里的所有元素依次放入 popStack
        while (!pushStack.isEmpty()) {
            popStack.addLast(pushStack.removeLast());
        }
        return popStack.removeLast();
    }

    public int peek() {
        // 从 popStack 取出元素
        if (!popStack.isEmpty()) {
            return popStack.peekLast();
        }
        // 走到这里是因为 popStack 为空，此时需要将 pushStack 里的所有元素依次放入 popStack
        while (!pushStack.isEmpty()) {
            popStack.addLast(pushStack.removeLast());
        }
        return popStack.peekLast();
    }

    public boolean empty() {
        // 两个栈都为空，才说明队列为空
        return pushStack.isEmpty() && popStack.isEmpty();
    }


    public static void main(String[] args) {
        MyQueue1 myQueue1 = new MyQueue1();
        myQueue1.push(1);
        myQueue1.push(2);
        myQueue1.push(3);

        System.out.println(myQueue1.pop());
        System.out.println(myQueue1.pop());
        System.out.println(myQueue1.pop());
    }
}
