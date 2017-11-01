package Lafore.Chap5_linkedList;

import Lafore.Chap5_LinkedList.Iterator;
import Lafore.Chap5_LinkedList.LinkList;
import Lafore.Chap5_LinkedList.LinkedListException;
import org.junit.Test;

import java.util.ListIterator;

import static junit.framework.Assert.assertEquals;

public class Iterator_Test {

    LinkList<Integer> linkList = new LinkList<>();
    Iterator<Integer> iter = linkList.getIterator();

    @Test
    public void iterator_test() throws LinkedListException {
        iter.insertAfter(20);
        iter.insertAfter(40);
        iter.insertAfter(80);
        iter.insertAfter(60);

        assertEquals(60,iter.getCurrent().iData);
        iter.insertAfter(99);
        linkList.displayList();
        iter.insertBefore(66);
        linkList.displayList();
        iter.insertAfter(0);
        linkList.displayList();
    }
}
