package yandex;

import java.io.*;

public class WhieBlackMatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int nInput = Integer.parseInt(reader.readLine());
        int n = 2 * nInput + 1;

        int primaryAmount = n / 2 + 1;
        int lessAmount = n / 2;

        int whiteCounter = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    writer.write("0");
                } else if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                    writer.write(String.format("%d", -getBlackCount(j, i, primaryAmount, lessAmount)));
                } else {
                    writer.write(String.format("%d", whiteCounter));
                    whiteCounter++;
                }
                if (j != n - 1) {
                    writer.write(" ");
                }
            }
            if (i != n - 1) {
                writer.newLine();
            }
        }

        reader.close();
        writer.close();
    }

    private static int getBlackCount(int j, int i, int primaryAmount, int lessAmount) {
        if (j == 0) {
            return i / 2;
        }
        int l = 0;
        int counter = 0;
        while (l < j) {
            if (l % 2 == 0) {
                counter += primaryAmount - 1;
            } else {
                counter += lessAmount - 1;
            }
            l++;
        }
        if (j > i) {
            return counter + (i / 2) + 1;
        } else {
            return counter + (i / 2);
        }
    }
}
