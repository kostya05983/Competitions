package educative.crack.java.interview.stack;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];

        Stack<Integer> stack = new Stack<>(arr.length);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.top() <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.top();
            }

            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        nextGreaterElement(new int[]{4, 6, 3, 2, 8, 1});
    }
}
