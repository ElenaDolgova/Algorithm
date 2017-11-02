package Lafore.Chap6_Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearch {

    private ArrayList<Integer> arrayList;

    public BinarySearch(Integer... args) {
        arrayList = new ArrayList<>(args.length);
        for (int i = 0; i < args.length; i++) {
            arrayList.add(args[i]);
        }
        Collections.sort(arrayList);
    }

    public BinarySearch() {
        Scanner s = new Scanner(System.in);
        arrayList = new ArrayList();
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            arrayList.add(s.nextInt());
        }
        Collections.sort(arrayList);
    }

    public int getSize() {
        return arrayList.size();
    }

    /**
     * @param key        search key
     * @param lowerBound
     * @param upperBound
     * @return -1 if there is no key, otherwise return number of position
     */

    public int binarySearch(int key, int lowerBound, int upperBound) {
        int r;
        r = (lowerBound + upperBound) / 2;
        if (arrayList.get(r) == key) {
            return r;
        } else if (lowerBound > upperBound) {
            return -1;
        } else {
            if (arrayList.get(r) < key) {
                return binarySearch(key, r + 1, upperBound);
            } else {
                return binarySearch(key, lowerBound, r - 1);
            }
        }
    }
}
