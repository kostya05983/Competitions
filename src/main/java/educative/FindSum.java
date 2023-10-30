package educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindSum {
    public static int[] findSum(int[] arr, int n) {
        int[] result = new int[2];

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            int diff = n - arr[i];

            if (set.contains(diff)) {
                result[0] = arr[i];
                result[1] = diff;
                return result;
            }
        }


        // write your code here
        return arr;   // return the elements in the array whose sum is equal to the value passed as parameter
    }
}
