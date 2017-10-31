package Lafore.Chap5_linkedList.DoublyLinkedList;

import Lafore.Chap5_LinkedList.DoubleLinkedList.DoublyLinked;
import Lafore.Chap5_LinkedList.LinkedListException;
import org.junit.Test;

public class DoublyLinkedList_Test {

    DoublyLinked doublyLinked = new DoublyLinked();

    @Test
    public void setDoublyLinked_test() throws LinkedListException {
        doublyLinked.insertFirst(22);
        doublyLinked.insertFirst(44);
        doublyLinked.insertFirst(66);

        doublyLinked.insertLast(11);
        doublyLinked.insertLast(33);
        doublyLinked.insertLast(55);

        doublyLinked.displayForward();
        doublyLinked.displayBackward();

        doublyLinked.deleteFirst();
        doublyLinked.deleteLast();
        doublyLinked.deleteKey(11);

        doublyLinked.displayForward();

        doublyLinked.insertAfter(77,22);
        doublyLinked.insertAfter(88,33);

        doublyLinked.displayForward();
    }
}
