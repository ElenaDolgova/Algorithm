package Lafore.Chap4;

import java.util.ArrayList;

// На основе массива. Медленная вставка.
public class PriorityQueue {
    private int maxSize;
    private ArrayList<Long> pQArray;
    private int anInt;

    public PriorityQueue(int s) {
        maxSize = s;
        pQArray = new ArrayList<>(maxSize);
        anInt = 0;
    }

    public void insert(long item) {
        if (anInt == 0) {
            pQArray.set(anInt++, item);
        } else {
            for (int i = anInt - 1; i >= 0; i++) {
                if (item > pQArray.get(i)) {
                    pQArray.set(i + 1, pQArray.get(i));
                } else {
                    break;
                }
                pQArray.set(i + 1, item);
                anInt++;
            }
        }
    }

    public long remove() {
        return pQArray.get(--anInt);
    }

    public long peekMin() {
        return pQArray.get(anInt - 1);
    }

    public boolean isEmpty() {
        return (anInt == 0);
    }

    public boolean isFull() {
        return (anInt == maxSize);
    }
}
