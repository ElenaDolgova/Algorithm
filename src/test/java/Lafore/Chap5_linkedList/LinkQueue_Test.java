package Lafore.Chap5_linkedList;

import Lafore.Chap5_LinkedList.LinkQueue;
import Lafore.Chap5_LinkedList.LinkedListException;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LinkQueue_Test {
    LinkQueue<Integer> linkQueue = new LinkQueue<>();
    @Test
    public void pushPop_Test() throws LinkedListException {
        assertEquals(true,linkQueue.isEmpty());
        linkQueue.insert(55);
        linkQueue.insert(58);
        assertEquals(55,(int)linkQueue.remove());
    }
}
