package Stepic.TheoryAndPractise_DataStructure.Lesson_2.Parallel;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Processor {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(System.in);
        BufferedReader r = new BufferedReader(
                new InputStreamReader(bis, StandardCharsets.UTF_8));

        String[] nm = r.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] time = r.readLine().split(" ");
        int i;

        MinHeap minHeapOfProcess = new MinHeap(n);
        for (i = 0; i < n; i++) {
            minHeapOfProcess.insert(i, 0);
        }
        i = 0;
        Proc pp;
        while (i < m) {
            pp = minHeapOfProcess.extractMin();
            System.out.println(pp.number + " " + pp.time);
            minHeapOfProcess.insert(pp.number, pp.time + Long.parseLong(time[i]));
            i++;
        }
    }


}


class Proc implements Comparable {
    long number;
    long time;

    Proc(long number, long time) {
        this.number = number;
        this.time = time;
    }


    @Override
    public int compareTo(Object o) {
        Proc p1 = (Proc) o;
        if (p1.time < this.time) {
            return -1;
        } else if (p1.time == this.time) {
            if (p1.number < this.number) {
                return -1;
            } else
                return 1;
        } else {
            return 1;
        }
    }
}

class MinHeap {
    private Proc[] procs;
    private int maxSize;
    private int currentSize;

    MinHeap(int size) {
        this.procs = new Proc[size];
        this.currentSize = 0;
        this.maxSize = size;
    }

    public boolean insert(long number, long time) {
        if (currentSize == maxSize) {
            return false;
        } else {
            Proc node = new Proc(number, time);
            procs[currentSize] = node;
            siftUp(currentSize++);
            return true;
        }
    }

    private void siftUp(int index) {
        int parent = (index - 1) / 2;
        Proc node = procs[index];

        while (index > 0 &&
                procs[parent].compareTo(node) < 0) {
            procs[index] = procs[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        procs[index] = node;
    }

    public Proc extractMin() {
        Proc root = procs[0];
        procs[0] = procs[--currentSize];
        siftDown(0);
        return root;
    }

    private void siftDown(int index) {
        int largeChild;
        Proc top = procs[index];
        while (index < currentSize / 2) { // Are there descendants?
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize &&
                    procs[leftChild].compareTo(procs[rightChild]) < 0) { // больше
                largeChild = rightChild;
            } else {
                largeChild = leftChild;
            }

            if (procs[largeChild].compareTo(top) < 0 ||
                    (procs[largeChild].compareTo(top) != -1 && procs[largeChild].compareTo(top) != 1)) {
                break;
            }
            procs[index] = procs[largeChild];
            index = largeChild;
        }
        procs[index] = top;
    }
}
