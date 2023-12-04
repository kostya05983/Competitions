package educative;

public class MinimumWindowSubsequence {
    public static String minWindow(String s, String t) {
        int left;
        int right;
        int pointerT = 0;
        int pointerS = 0;

        String minSubsequnce = "";
        int minLength = Integer.MAX_VALUE;

        while (pointerS < s.length()) {
            if (s.charAt(pointerS) != t.charAt(pointerT)) {
                pointerS++;
                continue;
            }
            pointerT++;
            if (pointerT == t.length()) {
                left = pointerS;
                right = pointerS;
                pointerT--;

                while (pointerT >= 0) {
                    if (s.charAt(left) == t.charAt(pointerT)) {
                        pointerT--;
                    }
                    left -= 1;
                }
                left += 1;

                if ((right - left + 1) < minLength) {
                    minLength = right - left + 1;
                    minSubsequnce = s.substring(left, right + 1);
                }
                pointerS = left;
                pointerT = 0;
            }
            pointerS++;
        }

        return minSubsequnce;
    }
}
