package educative.crack.java.interview.stack;

import java.util.Stack;

public class QueueWithStack<V> {
    private Stack<V> stack;
    private Stack<V> secondStack;

    public QueueWithStack(int maxSize) {
        stack = new Stack<>();
        secondStack = new Stack<>();
        // Write -- Your -- Code
    }

    public void enqueue(V value) {
        stack.push(value);
        // Write -- Your -- Code
    }

    public V dequeue() {
        if (!secondStack.isEmpty()) return secondStack.pop();
        while (!stack.isEmpty()) {
            secondStack.push(stack.pop());
        }

        return secondStack.pop();
    }

    public boolean isEmpty() {
        //Write -- Your -- Code
        return stack.isEmpty() && secondStack.isEmpty();
    }

    public static void main(String[] args) {
        QueueWithStack<Integer> queue = new QueueWithStack<>(1);
        queue.enqueue(1);
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
    }
}