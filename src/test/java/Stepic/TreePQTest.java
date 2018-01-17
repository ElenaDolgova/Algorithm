package Stepic;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TreePQTest {
    TreePQ treePQ = new TreePQ();
    TreePQ treePQ1 = new TreePQ();

    @Test
    public void insertTest() {
        treePQ.insert(4);
        assertEquals(4, treePQ.getRoot().getPriority());
        assertEquals(4, treePQ.getLast().getPriority());
        treePQ.insert(3);
        assertEquals(4, treePQ.getRoot().getPriority());
        assertEquals(3, treePQ.getLast().getPriority());
        treePQ.insert(20);
        treePQ.insert(7);
        treePQ.insert(8);
        assertEquals(20, treePQ.getRoot().getPriority());
        assertEquals(3, treePQ.getLast().getPriority());

        treePQ1.insert(200);
        treePQ1.insert(10);
        assertEquals(200, treePQ1.extractMax());
        treePQ1.insert(5);
        assertEquals(10, treePQ1.extractMax());
        treePQ1.insert(500);
        assertEquals(500, treePQ1.extractMax());
        treePQ1.insert(2);
        treePQ1.insert(50);
        treePQ1.insert(200);
        treePQ1.insert(10);
        treePQ1.insert(300);
        treePQ1.insert(10);
        assertEquals(300, treePQ1.extractMax());
        assertEquals(200, treePQ1.extractMax());
        assertEquals(50, treePQ1.extractMax());
    }
}
