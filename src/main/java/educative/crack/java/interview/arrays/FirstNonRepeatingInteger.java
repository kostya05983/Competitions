package educative.crack.java.interview.arrays;

public class FirstNonRepeatingInteger {
    public static int findFirstUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    break;
                }
                if (j == arr.length-1) {
                    return arr[i];
                }
            }
        }

        return -1;
    }
}
