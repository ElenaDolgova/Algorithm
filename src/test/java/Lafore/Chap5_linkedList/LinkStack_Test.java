package Lafore.Chap5_linkedList;

import Lafore.Chap5_LinkedList.LinkStack;
import Lafore.Chap5_LinkedList.LinkedListException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkStack_Test {

    LinkStack<Integer> linkStack = new LinkStack<>();

    @Test
    public void testIsEmpty() {
        System.out.println(linkStack.isEmpty());
    }

    @Test
    public void testPush() throws LinkedListException {
        linkStack.push(20);
        linkStack.push(40);
        linkStack.displayStack();
        linkStack.push(60);
        linkStack.push(80);
        linkStack.displayStack();
        linkStack.pop();
        linkStack.pop();
        linkStack.displayStack();
        assertEquals((int)linkStack.pop(), 40);
    }
}
