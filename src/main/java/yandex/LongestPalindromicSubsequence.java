package yandex;

public class LongestPalindromicSubsequence {

    public static int LPSLength(String st) {
        int size = st.length();
        // Initializing a lookup table of dimensions size * size
        int[][] lookupTable;
        lookupTable = new int[size][];
        for (int i = 0; i < size; i++) {
            lookupTable[i] = new int[size];
            for (int j = 0; j < size; j++)
                lookupTable[i][j] = 0;
        }
        // every sequence with one element is a palindrome of length 1
        for (int i = 0; i < size; i++)
            lookupTable[i][i] = 1;

        for (int startIndex = size - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < size; endIndex++) {
                // case 1: elements at the beginning and the end are the same
                if (st.charAt(startIndex) == st.charAt(endIndex))
                    lookupTable[startIndex][endIndex] = 2 + lookupTable[startIndex + 1][endIndex - 1];
                else // case 2: skip one element either from the beginning or the end
                    lookupTable[startIndex][endIndex] = Math.max(lookupTable[startIndex + 1][endIndex], lookupTable[startIndex][endIndex - 1]);
            }
        }
        return lookupTable[0][size - 1];
    }

    public static void main(String[] args) {
        var result = LongestPalindromicSubsequence.LPSLength("abdba");
        System.out.println(result);
    }
}
