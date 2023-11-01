package educative.crack.java.interview.linkedlist;

public class UnionIntersectionLists {
    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();

        SinglyLinkedList.Node current = list1.getHeadNode();

        while (current != null) {
            result.insertAtEnd((T) current.data);
            current = current.nextNode;
        }

        current = list2.getHeadNode();
        while (current != null) {
            result.insertAtEnd((T) current.data);
            current = current.nextNode;
        }

        result.removeDuplicatesWithHashing();

        // Write -- Your -- Code
        return result;
    }

    //performs intersection between list
    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        // Write -- Your -- Code

        SinglyLinkedList.Node current = list1.getHeadNode();

        while (current != null) {
            SinglyLinkedList.Node secondCurrent = list2.getHeadNode();
            while (secondCurrent != null) {
                if (current.data.equals(secondCurrent.data)) {
                    result.insertAtEnd((T) secondCurrent.data);
                }

                secondCurrent = secondCurrent.nextNode;
            }
            current = current.nextNode;
        }

        return result;
    }
}
