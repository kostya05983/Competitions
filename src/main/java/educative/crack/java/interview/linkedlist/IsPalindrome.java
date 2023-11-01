package educative.crack.java.interview.linkedlist;

public class IsPalindrome {
    public static <T> boolean isPalindrome(DoublyLinkedList<T> list) {
        DoublyLinkedList.Node head = list.headNode;
        DoublyLinkedList.Node tail = list.tailNode;

        int size = list.getSize();
        while (size > 0 && head.data == tail.data) {
            head = head.nextNode;
            tail = tail.prevNode;
            size -= 2;
        }

        return size <= 0;
    }
}
