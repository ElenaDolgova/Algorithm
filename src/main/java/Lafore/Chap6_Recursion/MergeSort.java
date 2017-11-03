package Lafore.Chap6_Recursion;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public List sort(List array) {
        return mergeSort(array);
    }

    private List mergeSort(List<Long> array) {
        if (array.size() == 1) {
            return array;
        }
        return merge(mergeSort(array.subList(0, array.size() / 2)),
                mergeSort(array.subList(array.size() / 2, array.size())));
    }

    private List merge(List<Long> array1, List<Long> array2) {
        List<Long> array = new ArrayList<>(array1.size() + array2.size());
        int i = 0, j = 0;
        while (i < array1.size() && j < array2.size()) {
            if (array1.get(i) <= array2.get(j)) {
                array.add(array1.get(i++));
            } else {
                array.add(array2.get(j++));
            }
        }
        while (i < array1.size()) {
            array.add(array1.get(i++));
        }

        while (j < array2.size()) {
            array.add(array2.get(j++));
        }
        return array;
    }
}
