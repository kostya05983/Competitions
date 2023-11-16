package educative.crack.java.interview.stack;

public class BalancedParentheses {
    public static boolean isBalanced(String exp) {
        Stack<Character> stack = new Stack<>(exp.length());

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                default:
                    char last = stack.pop();
                    char expected = reverse(ch);
                    if (last != expected) return false;
                    break;
            }
        }

        return true;
    }

    private static char reverse(char parentheses) {
        switch (parentheses) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
        }
        throw new RuntimeException("unknown parentheses");
    }

    public static void main(String[] args) {
        isBalanced("{()}[{}]");
    }
}
