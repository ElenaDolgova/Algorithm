package Lafore.Chap6_Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MergeSort_Test {

    MergeSort mergeSort = new MergeSort();

    @Test
    public void mergeSort_Test(){
        List<Long> list = new ArrayList();
        list.add((long) 3);
        list.add((long) 55);
        list.add((long) 0);
        list.add((long) -2);
//        list.add((long) 36);
        System.out.println(list);
        list=mergeSort.sort(list);
        System.out.println(list);
    }
}
