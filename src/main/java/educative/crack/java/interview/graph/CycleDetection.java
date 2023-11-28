package educative.crack.java.interview.graph;

import educative.crack.java.interview.linkedlist.DoublyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class CycleDetection {
    public static boolean detectCycle(Graph g) {
        for (int i = 0; i < g.vertices; i++) {
            boolean[] visited = new boolean[g.vertices];
            boolean[] stackFlag = new boolean[g.vertices];
            if (dfs(g, i, visited, stackFlag)) return true;
        }

        // Write -- Your -- Code
        return false;
    }

    private static boolean dfs(Graph g, int i, boolean[] visited, boolean[] stackFlag) {
        if (stackFlag[i]) return true;
        if (visited[i]) return false;

        visited[i] = true;
        stackFlag[i] = true;

        List<Integer> list = collectList(g.adjacencyList[i]);
        boolean result = false;
        for (int j = 0; j < list.size(); j++) {
            result = result || dfs(g, list.get(j), visited, stackFlag);
        }
        stackFlag[i] = false;

        return result;
    }

    private static List<Integer> collectList(DoublyLinkedList<Integer> start) {
        ArrayList<Integer> result = new ArrayList<>();
        DoublyLinkedList<Integer>.Node head = start.headNode;
        while (head != null) {
            result.add(head.data);

            head = head.nextNode;
        }

        return result;
    }
}
