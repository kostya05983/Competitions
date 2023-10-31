package educative.crack.java.interview.linkedlist;


public class InsertAtEnd<T> {
    public Node headNode;

    public void insertAtEnd(T data) {
        if (headNode == null) {
            headNode = new Node();
            headNode.data = data;
            return;
        }

        Node lastNode = headNode;

        while (lastNode.nextNode != null) {
            lastNode = lastNode.nextNode;
        }

        lastNode.nextNode = new Node();
        lastNode.nextNode.data = data;
    }
}
