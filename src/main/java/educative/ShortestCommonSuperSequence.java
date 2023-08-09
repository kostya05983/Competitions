package educative;

public class ShortestCommonSuperSequence {
    public static int findSCSLength(String str1, String str2) {
        int s1 = str1.length(), s2 = str2.length();
        int[][] lookupTable = new int[s1 + 1][];

        for (int i = 0; i < s1 + 1; i++) {
            lookupTable[i] = new int[s2 + 1];
            for (int j = 0; j < s2 + 1; j++)
                lookupTable[i][j] = 0;
        }
        for (int i = 0; i <= s1; i++)
            lookupTable[i][0] = i;
        for (int j = 0; j <= s2; j++)
            lookupTable[0][j] = j;

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    lookupTable[i][j] = 1 + lookupTable[i - 1][j - 1];
                else
                    lookupTable[i][j] = 1 + Math.min(lookupTable[i - 1][j], lookupTable[i][j - 1]);
            }
        }
        return lookupTable[s1][s2];
    }

    public static void main(String[] args) {
        var length = ShortestCommonSuperSequence.findSCSLength("JavaRocks", "JavaIsFun");
        System.out.println(length);
    }
}
