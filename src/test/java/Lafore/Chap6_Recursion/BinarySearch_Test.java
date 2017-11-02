package Lafore.Chap6_Recursion;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BinarySearch_Test {
    BinarySearch binarySearch = new BinarySearch(3, 4, 5, 6, 7, 2, 0, 33);

    @Test
    public void binarySearch_Test() {
        assertEquals(0,binarySearch.find(0));
        assertEquals(4,binarySearch.find(5));
        assertEquals(7,binarySearch.find(33));
    }
}
