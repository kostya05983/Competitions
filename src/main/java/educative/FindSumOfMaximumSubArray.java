package educative;

public class FindSumOfMaximumSubArray {
    public static int findMaxSumSubArray(int[] arr) {
        if (arr.length < 1) return 0;

        int maxSum = arr[0];

        int currentSum = 0;
        for (int i = 1; i < arr.length; i++) {
            if (currentSum < arr[i]) {
                currentSum = arr[i];
            } else {
                currentSum += arr[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
}
