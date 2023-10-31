package educative.crack.java.interview.linkedlist;

public class LengthOfLinkedList<T> {

    public Node headNode;

    public int length() {
        int count = 0;

        Node current = headNode;

        while (current != null) {
            count++;
            current = current.nextNode;
        }

        // Write -- Your -- Code
        return count;
    }
}
