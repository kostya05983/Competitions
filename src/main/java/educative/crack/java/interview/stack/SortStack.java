package educative.crack.java.interview.stack;


import java.util.Arrays;
import java.util.Collections;

public class SortStack {
    public static void sortStack(Stack<Integer> stack) {
        // Write -- Your -- Code
        Integer[] array = new Integer[stack.getCurrentSize()];

        int index = 0;
        while (!stack.isEmpty()) {
            array[index] = stack.pop();
            index++;
        }

        Arrays.sort(array, Collections.reverseOrder());

        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
    }
}
