package Week4;

import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        new BinarySearch().method();
    }

    public void method() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Integer> listn = new ArrayList<>();
        ArrayList<Integer> listk = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            listn.add(s.nextInt());
        }
        int k = s.nextInt();
        for (int i = 0; i < k; i++) {
            listk.add(s.nextInt());
        }
        Collections.sort(listn);

        System.out.println();
        for (int i = 0; i < k; i++) {
            System.out.print(binarySearch(listk.get(i), listn) + " ");
        }
    }

    public int binarySearch(int num, ArrayList<Integer> arrayList) {
        int r;
        int min = 0;
        int max = arrayList.size();
        while (min < max) {
            r = (min + max) / 2;
            if (arrayList.get(r) == num) {
                return r;
            } else if (arrayList.get(r) > num) {
                max = r;
            } else if(arrayList.get(r) < num) {
                min = r + 1;
            }
        }
        return -1;
    }

}
