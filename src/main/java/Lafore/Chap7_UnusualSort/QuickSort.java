package Lafore.Chap7_UnusualSort;

import java.util.ArrayList;

import static java.util.Collections.sort;
import static java.util.Collections.swap;

public class QuickSort {
    private ArrayList arrayList;

    public QuickSort(int... args) {
        arrayList = new ArrayList(args.length);
        for (int i = 0; i < args.length; i++) {
            arrayList.add(args[i]);
        }
    }

    public void dispayArray() {
        System.out.println(arrayList);
    }

    public void sort() {
        qS(0, arrayList.size() - 1);
    }

    private void qS(int left, int right) {
        if (left >= right) {
            return;
        }
        int m = partition(left, right);
        qS(left, m - 1);
        qS(m + 1, right);
    }

    private int partition(int left, int right) {
        int x = (int) arrayList.get(left);
        int j = left;
        for (int i = left + 1; i < right; i++) {
            if ((int) arrayList.get(i) <= x) {
                j++;
                swap(arrayList, j, i);
            }
            swap(arrayList, left, j);
        }
        return j;
    }
}
