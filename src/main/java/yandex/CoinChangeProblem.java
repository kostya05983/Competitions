package yandex;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeProblem {
    public static int countChange(int denoms[], int amount) {
        int denomsLength = denoms.length;
        if (denomsLength <= 0 || amount <= 0)
            return 0;
        int[] lookupTable = new int[amount + 1];

        // Initialize all table values to 0
        for (int i = 0; i < amount + 1; i++) {
            lookupTable[i] = 0;
        }

        lookupTable[0] = 1;

        for (int denom : denoms)
            for (int j = denom; j <= amount; j++)
                lookupTable[j] += lookupTable[j - denom];

        return lookupTable[amount];
    }

    public static void main(String[] args) {
        var representationNumber = CoinChangeProblem.countChange(new int[]{25, 10, 5, 1}, 10);
        System.out.println(representationNumber);

        System.out.println(CoinChangeProblem.countChange(new int[]{25, 10, 5, 1}, 28));
    }
}
