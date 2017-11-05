package Lafore.Chap7_UnusualSort_Test;

import Lafore.Chap7_UnusualSort.ShellSort;
import org.junit.Test;

public class ShellSort_Test {

    ShellSort<Integer> shellSort = new ShellSort<Integer>(1, 2, 4, 7, 13, 0, -5);

    @Test
    public void shellSort_test() {
        shellSort.displayArray();
        shellSort.shellSort();
        shellSort.displayArray();
    }
}
