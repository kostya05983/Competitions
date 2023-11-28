package educative.crack.java.interview.graph;

import educative.crack.java.interview.linkedlist.DoublyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public static String dfs(Graph g) {
        StringBuilder sb = new StringBuilder();

        boolean[] visited = new boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++) {
            dfs(g, i, visited, sb);
        }

        // Write - Your - Code
        return sb.toString();
    }

    private static void dfs(Graph g, int i, boolean[] visited, StringBuilder sb) {
        if (visited[i]) return;

        sb.append(i);
        visited[i] = true;

        List<Integer> list = collectList(g.adjacencyList[i]);
        for (int j = 0; j < list.size(); j++) {
            dfs(g, list.get(j), visited, sb);
        }
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
