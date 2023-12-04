package educative;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatedSequence {


    public static Set<String> findRepeatedSequences(String s, int k) {
        // Replace this placeholder return statement with your code
        HashSet<String> result = new HashSet<>();
        HashSet<String> temp = new HashSet<>();
        int left = 0;
        int right = k;

        while (right < s.length()) {
            String sub = s.substring(left, right);
            if (temp.contains(sub)) {
                result.add(sub);
            }
            temp.add(sub);

            left++;
            right++;
        }


        return result;
    }
}
