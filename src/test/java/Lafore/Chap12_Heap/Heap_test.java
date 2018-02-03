package Lafore.Chap12_Heap;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Heap_test {
    Heap heap = new Heap(100);

    @Test
    public void quickSort_test() {
        heap.insert(200);
        heap.insert(10);
        assertEquals(200, heap.extractMax());
        heap.insert(5);
        heap.insert(500);
        assertEquals(500, heap.extractMax());
    }
}
