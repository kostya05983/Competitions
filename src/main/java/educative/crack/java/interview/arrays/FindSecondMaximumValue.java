package educative.crack.java.interview.arrays;

public class FindSecondMaximumValue {
    public int findSecondMaximum(int[] arr) {
        int firstMax = arr[0];
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstMax) {
                secondMax = firstMax;
                firstMax = arr[i];
            }
            if (arr[i] != firstMax && arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }

        // Write - Your - Code
        return secondMax;
    }
}
