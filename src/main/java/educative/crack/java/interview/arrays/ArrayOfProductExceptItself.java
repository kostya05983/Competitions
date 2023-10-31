package educative.crack.java.interview.arrays;

public class ArrayOfProductExceptItself {
    public static int[] findProduct(int arr[]) {
        int product = 1;

        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroCount++;
                continue;
            }

            product *= arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && zeroCount == 1) {
                arr[i] = product;
                continue;
            }
            if (zeroCount > 0) {
                arr[i] = 0;
                continue;
            }
            arr[i] = product / arr[i];
        }

        return arr;
    }
}
