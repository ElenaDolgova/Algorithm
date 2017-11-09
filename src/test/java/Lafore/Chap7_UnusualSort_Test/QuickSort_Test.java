package Lafore.Chap7_UnusualSort_Test;

import Lafore.Chap7_UnusualSort.QuickSort;
import org.junit.Test;

public class QuickSort_Test {
    QuickSort quickSort = new QuickSort(2, 8, 8, 0, 4, 33);

    @Test
    public void quickSort_test() {
        quickSort.dispayArray();
        quickSort.sort();
        quickSort.dispayArray();
    }
}
