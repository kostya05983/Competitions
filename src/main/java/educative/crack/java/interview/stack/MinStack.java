package educative.crack.java.interview.stack;

import java.util.LinkedList;

public class MinStack {
    int maxSize;
    LinkedList<Integer> inner = new LinkedList<>();
    LinkedList<Integer> min = new LinkedList<>();

    //constructor
    public MinStack(int maxSize) {
        // Write -- Your -- Code
        this.maxSize = maxSize;
    }

    //removes and returns value from stack
    public Integer pop() {
        min.pop();
        return inner.pop();
    }

    //pushes value into the stack
    public void push(Integer value) {
        inner.push(value);

        if (min.isEmpty() || value < min.peek()) {
            min.push(value);
        } else {
            min.push(min.peek());
        }
    }

    //returns minimum value in O(1)
    public int min() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack(10);
        minStack.push(10);
        minStack.push(2);
        minStack.push(3);
        System.out.println(minStack.min());
    }
}
