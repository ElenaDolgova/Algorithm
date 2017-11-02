package Lafore.Chap6_Recursion;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BinarySearch_Test {
    BinarySearch binarySearch = new BinarySearch(3, 4, 5, 6, 7, 2, 0, 33);

    @Test
    public void binarySearch_Test() {
        assertEquals(0,binarySearch.binarySearch(0, 0, binarySearch.getSize()));
        assertEquals(4,binarySearch.binarySearch(5, 0, binarySearch.getSize()));
        assertEquals(7,binarySearch.binarySearch(33, 0, binarySearch.getSize()));
    }
}
