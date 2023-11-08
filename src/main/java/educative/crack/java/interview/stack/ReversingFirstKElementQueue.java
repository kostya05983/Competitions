package educative.crack.java.interview.stack;


import java.util.ArrayList;
import java.util.Stack;

public class ReversingFirstKElementQueue {
    public static <V> void reverseK(Queue<V> queue, int k) {
        Stack<V> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack.add(queue.dequeue());
        }

        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        int size = queue.getCurrentSize();
        for(int i = 0; i < size - k; i++)
            queue.enqueue(queue.dequeue());
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(5);
        queue.enqueue(5);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(12);
        queue.enqueue(4);

        reverseK(queue, 4);
        System.out.println(queue);
    }
}
