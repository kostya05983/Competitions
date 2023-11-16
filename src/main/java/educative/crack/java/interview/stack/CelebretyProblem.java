package educative.crack.java.interview.stack;

public class CelebretyProblem {
    private static boolean knowSecond(int[][] party, int x, int y) {
        return party[x][y] == 1;
    }

    public static int findCelebrity(int[][] party, int numPeople) {
        Stack<Integer> stack = new Stack<>(numPeople);
        for (int i = 0; i < numPeople; i++) {
            stack.push(i);
        }

        int celebrity = -1;
        while (!stack.isEmpty()) {
            int x = stack.pop();

            if (stack.isEmpty()) {
                celebrity = x;
                break;
            }
            int y = stack.pop();

            if (knowSecond(party, x, y)) {
                stack.push(y);
            } else stack.push(x);
        }

        for (int j = 0; j < numPeople; j++) {
            if (celebrity != j && (knowSecond(party, celebrity, j) || !(knowSecond(party, j, celebrity)))) return -1;
        }

        return celebrity;
    }
}
