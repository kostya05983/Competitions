package educative.crack.java.interview.linkedlist;

public class SearchNode<T> {
    public class Node {
        public T data;
        public Node nextNode;

        public Node() {
        }
    }

    public Node headNode;

    public boolean searchNode(T data) {
        if (headNode == null) return false;

        Node current = headNode;

        while (current != null) {
            if (current.data.equals(data)) return true;
            current = current.nextNode;
        }

        // Write -- Your -- Code
        return false; //value not found
    }
}
