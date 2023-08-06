package yandex;

public class LongestPalindromicSubsequence {

    public static int LPSLength(String st) {
        int max = -1;
        for (int i = 1; i < st.length(); i++) {
            var first = helper(st, i, i);
            var second = helper(st, i - 1, i);

            max = Math.max(max, first);
            max = Math.max(max, second);
        }
        // write your code here
        return max;
    }

    private static int helper(String st, int left, int right) {
        int count = 0;
        while (left >= 0 && right < st.length() && st.charAt(left) == st.charAt(right)) {
            left--;
            right++;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        var result = LongestPalindromicSubsequence.LPSLength("abdbca");
        System.out.println(result);
    }
}
