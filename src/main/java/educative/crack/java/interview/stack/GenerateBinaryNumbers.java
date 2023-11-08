package educative.crack.java.interview.stack;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public static String[] findBin(int number) {
        String[] result = new String[number];
        Queue<String> queue = new LinkedList<String>();

        queue.offer("1");

        for (int i = 0; i < number; i++) {
            result[i] = queue.poll();
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            queue.add(s1);
            queue.add(s2);
        }

        // Write -- Your -- Code
        return result; //For number = 3 , result = {"1","10","11"};
    }
}
