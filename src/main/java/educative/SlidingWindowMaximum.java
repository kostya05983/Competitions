package educative;

import java.util.ArrayList;

public class SlidingWindowMaximum {
    public static int[] findMaxSlidingWindow(int[] nums, int w) {
        int[] result = new int[nums.length - w+1];

        int i = 0;
        while (i + w <= nums.length) {
            var max = nums[i];

            for (int j = i; j < i + w; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(SlidingWindowMaximum.findMaxSlidingWindow(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3));
    }
}
