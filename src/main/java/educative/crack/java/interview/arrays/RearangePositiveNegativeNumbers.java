package educative.crack.java.interview.arrays;

public class RearangePositiveNegativeNumbers {
    public static void reArrange(int[] arr) {
        int left = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 && left < i) {
                while (arr[left] < 0) {
                    left++;
                }
                int temp = arr[left];
                arr[left] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
