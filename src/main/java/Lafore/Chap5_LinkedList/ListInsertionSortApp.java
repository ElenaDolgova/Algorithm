package Lafore.Chap5_LinkedList;

import java.util.Random;

/**
 * Sometimes we can use sortedLinkedList for sort by insertion of massive.
 * Requires less number of copy operations. O(n^2)
 */
public class ListInsertionSortApp {
    public static void main(String[] args) {
        int[] massive = new int[10];
        SortedList<Integer> sortedList = new SortedList<>();
        Random random = new Random();
        for (int i = 0; i < massive.length; i++) {
            massive[i] = random.nextInt();
        }
        for (int i = 0; i < massive.length; i++) {
            System.out.print(massive[i] + " ");
        }

        for (int i = 0; i < massive.length; i++) {
            sortedList.insert(massive[i]);
        }
        for (int i = 0; i < massive.length; i++) {
            try {
                massive[i] = (int) sortedList.removeFirst().iData;
            } catch (LinkedListException e) {
                e.printStackTrace();
            }
        }
        System.out.println();

        for (int i = 0; i < massive.length; i++) {
            System.out.print(massive[i] + " ");
        }
    }
}
