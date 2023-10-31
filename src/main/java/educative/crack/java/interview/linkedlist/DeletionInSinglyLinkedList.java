package educative.crack.java.interview.linkedlist;

public class DeletionInSinglyLinkedList<T> {
    public class Node {
        public T data;
        public Node nextNode;

        public Node() {
        }
    }

    public int size;

    public Node headNode;

    public void deleteByValue(T data) {
        if (headNode == null) return;

        Node previous = null;
        Node current = headNode;

        while (current != null) {
            if (current.data.equals(data)) {
                if (previous == null) {
                    headNode = current.nextNode;
                } else {
                    previous.nextNode = current.nextNode;
                }
                size--;

                return;
            }
            previous = current;
            current = current.nextNode;
        }
    }
}
