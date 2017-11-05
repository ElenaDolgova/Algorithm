package Lafore.Chap7_UnusualSort;

import java.util.ArrayList;

public class ShellSort<T extends Comparable> {
    private ArrayList<T> arrayList;

    /**
     * Between O(n^(3/2)) and O(n^(7/6))
     * @param args
     */
    public ShellSort(T... args) {
        arrayList = new ArrayList<>(args.length);
        for (int i = 0; i < args.length; i++) {
            arrayList.add(args[i]);
        }
    }

    public void shellSort() {
        int h = 0;
        T temp;
/**
 * h - interval sequence
 * We can choose other interval. For example:
 * if(h < 5) {
 *  h = 1;
 * }else{
 *  h =(5*h-1)/11;
 * }
 */
        while (h <= arrayList.size() / 3) {
            h = 3 * h + 1;
        }

        while (h > 0) {
            for (int i = h; i < arrayList.size(); i++) {
                temp = arrayList.get(i);
                int j = i;
                while (j > (h - 1) && temp.compareTo(arrayList.get(j - h)) == -1) {
                    arrayList.set(j, arrayList.get(j - h));
                    j -= h;
                }
                arrayList.set(j, temp);
            }

            h = (h - 1) / 3;
        }
    }

    public void displayArray() {
        System.out.println(arrayList);
    }
}
