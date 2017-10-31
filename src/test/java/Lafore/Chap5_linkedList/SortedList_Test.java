package Lafore.Chap5_linkedList;

import Lafore.Chap5_LinkedList.LinkedListException;
import Lafore.Chap5_LinkedList.SortedList;
import org.junit.Test;

public class SortedList_Test {
    SortedList sT = new SortedList();

    @Test
    public void sortList() throws LinkedListException {
        sT.insert(20);
        sT.insert(40);
        sT.displaySL();
        sT.insert(10);
        sT.insert(30);
        sT.insert(50);
        sT.displaySL();
        sT.removeFirst();
        sT.displaySL();
    }
}
