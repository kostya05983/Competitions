package educative.crack.java.interview.linkedlist;

import java.util.HashSet;

public class RemoveDuplicates {
    public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
        SinglyLinkedList.Node current = list.getHeadNode();
        SinglyLinkedList.Node previous = null;

        HashSet<Object> set = new HashSet<>();
        while (current != null) {
            if (set.contains(current.data)) {
                previous.nextNode = current.nextNode;
                current = previous;
            }

            set.add(current.data);
            previous = current;
            current = current.nextNode;
        }
    }
}
