package educative;

public class RightRotateTheArrayByOneIndex {
    public static void rotateArray(int[] arr) {
        int previous = arr[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            int temp = previous;
            previous = arr[i];
            arr[i] = temp;
        }
    }
}
