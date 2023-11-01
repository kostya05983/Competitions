package educative.crack.java.interview.linkedlist;

public class ReturnTheNthNodeFromEnd {
    public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
        int size = list.getSize();

        int index = size - n;

        int currentIndex = 0;

        SinglyLinkedList.Node current = list.getHeadNode();

        while (current != null) {
            if (currentIndex == index) return current.data;

            current = current.nextNode;
            currentIndex++;
        }

        // Write -- Your -- Code
        return null;
    }
}
