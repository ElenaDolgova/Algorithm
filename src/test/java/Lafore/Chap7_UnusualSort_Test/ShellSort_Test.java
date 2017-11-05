package Lafore.Chap7_UnusualSort_Test;

import Lafore.Chap7_UnusualSort.ShellSort;
import org.junit.Test;

public class ShellSort_Test {

    ShellSort<Integer> shellSort = new ShellSort<Integer>(6, 8, 1, 0, 9, 7);

    @Test
    public void shellSort_test() {
        shellSort.displayArray();
        shellSort.shellSort();
        shellSort.displayArray();
    }
}
