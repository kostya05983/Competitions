package educative.crack.java.interview.graph;

import educative.crack.java.interview.linkedlist.DoublyLinkedList;
import educative.crack.java.interview.stack.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {


    //Breadth First Traversal of Graph g
    public static String bfs(Graph g) {
        StringBuilder result = new StringBuilder();

        boolean[] visited = new boolean[g.vertices];
        for (int i = 0; i < g.vertices; i++) {
            bfs(g, i, visited, result);
        }

        return result.toString();
    }

    private static void bfs(Graph g, int i, boolean[] visited, StringBuilder sb) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(i);

        while (!queue.isEmpty()) {
            Integer poll = queue.pollFirst();
            if (visited[poll]) continue;
            sb.append(poll);

            visited[poll] = true;

            DoublyLinkedList<Integer> neighbours = g.adjacencyList[poll];
            queue.addAll(collectList(neighbours));
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
