package Week4;

import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.swap;

public class Sorting {
    ArrayList<Long> arrayList = new ArrayList();

    public static void main(String[] args) {
        new Sorting().run();
    }

    void run() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            arrayList.add(s.nextLong());
        }
        qS(0, arrayList.size() - 1);
        String str = "";
        System.out.println();
        for (Long i : arrayList) {
            System.out.print(i + " ");
        }
    }

    void qS(int l, int r) {
        if (l >= r) {
            return;
        }
        int[] m = partition(l, r);
        qS(l, m[0] - 1);
        qS(m[1] + 1, r);
    }

    int[] partition(int l, int r) {
        long x = arrayList.get(l);
        int j = l;
        int k = l;
        for (int i = l + 1; i <= r; i++) {
            if (arrayList.get(i) > x) {
                continue;
            }
            if (arrayList.get(i) < x) {
                swap(arrayList, j, i);
                j++;
            }
            k++;
            swap(arrayList, k, i);
        }
        int[] mass = new int[2];
        mass[0] = j;
        mass[1] = k;
        return mass;
    }
}
