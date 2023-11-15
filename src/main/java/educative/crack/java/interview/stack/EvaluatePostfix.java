package educative.crack.java.interview.stack;

import java.util.Stack;

public class EvaluatePostfix {
    public static int evaluatePostFix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            int right;
            int left;
            switch (ch) {
                case '*':
                    left = stack.pop();
                    right = stack.pop();
                    stack.push(right * left);
                    break;
                case '-':
                    left = stack.pop();
                    right = stack.pop();
                    stack.push(right - left);

                    break;
                case '+':
                    left = stack.pop();
                    right = stack.pop();
                    stack.push(right + left);
                    break;
                case '/':
                    left = stack.pop();
                    right = stack.pop();
                    stack.push(right / left);
                    break;

                default:
                    stack.push(Integer.parseInt(Character.toString(ch)));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        evaluatePostFix("921*-8-4+");
    }
}
