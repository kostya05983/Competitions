package educative;

public class FindMinimumValue {
    public static int findMinimum(int[] arr) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        // Write your code here
        return min;
    }
}
