package educative;

public class RearangeSortedArrayInMaxMinForm {
    public static void maxMin(int[] arr) {
        int[] result = new int[arr.length];

        int left = 0;
        int right = arr.length - 1;
        int index = 0;

        while (left <= right) {
            result[index] = arr[right];
            if (index + 1 < arr.length) result[index + 1] = arr[left];
            index += 2;

            left++;
            right--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }
}
