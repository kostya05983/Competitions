package educative.crack.java.interview.linkedlist;

public class MiddleNodeLinkedList {

    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        SinglyLinkedList.Node current = list.getHeadNode();

        int count = 0;
        while (current != null) {
            count++;
            current = current.nextNode;
        }

        int midIndex = count / 2;
        if (count % 2 == 0) {
            midIndex--;
        }

        int index = 0;
        current = list.getHeadNode();
        while (current != null) {
            if (midIndex == index) {
                return current.data;
            }
            index++;
            current = current.nextNode;
        }

        // Write -- Your -- Code
        return -1;
    }
}
