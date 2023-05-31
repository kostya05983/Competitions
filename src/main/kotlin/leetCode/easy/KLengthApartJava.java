package leetCode.easy;

import java.util.Arrays;

public class KLengthApartJava {
    public boolean kLengthApart(int[] nums, int k) {
        var index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) continue;

            if (index != -1 && i - index <= k)
                return false;

            index = i;
        }
        return true;
    }
}
