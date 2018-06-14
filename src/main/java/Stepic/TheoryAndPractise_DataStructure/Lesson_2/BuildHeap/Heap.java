package Stepic.TheoryAndPractise_DataStructure.Lesson_2.BuildHeap;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Heap {
    static String[] arrayList;

    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(System.in);
        BufferedReader r = new BufferedReader(
                new InputStreamReader(bis, StandardCharsets.UTF_8));

        int n = Integer.parseInt(r.readLine().replaceAll(" ", ""));


        arrayList = r.readLine().split(" ");
        int m = 0;

        MinHeap minHeap = new MinHeap(n);
        minHeap.put(arrayList);
        minHeap.outReverse();
    }
}

class Reverse {
    private int parent;
    private int child;

    void setParentChild(int parent, int child) {
        this.parent = parent;
        this.child = child;
    }

    void out() {
        System.out.println(child + " " + parent);
    }
}

class MinHeap {
    private int maxSize;
    private int currentSize;
    private int[] heapArray;
    private int count;
    private ArrayList<Reverse> arrayList;

    public void out() {
        for (int i : heapArray) {
            System.out.print(i + " ");
        }
    }

    public MinHeap(int max) {
        this.maxSize = max;
        heapArray = new int[this.maxSize];
        this.currentSize = 0;
        count = -1;
        arrayList = new ArrayList<>();
    }

    public void put(String[] heapArray) {
        int i = 0;
        for (String str : heapArray) {
            this.heapArray[i] = Integer.parseInt(str);
            i++;
        }
        currentSize = i;
        for (i = maxSize / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    public boolean insert(int data) {
        if (currentSize == maxSize) {
            return false;
        } else {
            heapArray[currentSize] = data;
            //if (heapArray[(currentSize++ - 1) / 2] > heapArray[currentSize]) {
            SiftUp(currentSize++);
            //}
            return true;
        }
    }

    void outReverse() {
        System.out.println(count + 1);
        for (Reverse r : arrayList) {
            r.out();
        }
    }

    private void SiftUp(int index) {

        int parent = (index - 1) / 2;
        int node = heapArray[index];
        boolean flag = true;
        int child = -1;
//        System.out.println("index " + index + " node " + node);
//
//        if (heapArray[parent] > node) {
//            System.out.println("Trickle up");
//            count++;
//            //System.out.println("count "+count);
//            //System.out.println("index "+index);
//            arrayList.add(new Reverse());
//            arrayList.get(count).child = index;
//        }
        while (index > 0 &&
                heapArray[parent] > node) {
            if (flag) {
                count++;
                child = index;
                //System.out.println(count);
                flag = false;
            }
            //System.out.println("parent " + heapArray[parent] + " index " + heapArray[index]);
            //System.out.println(" parent " + parent + " index " + parent);
            //heapArray[index] = heapArray[parent];
            //System.out.println(parent);
            swap(parent, index);
            index = parent;
            parent = (parent - 1) / 2;
            //System.out.println("lol");
        }
        heapArray[index] = node;
        //System.out.println("ttt");
        System.out.println("count" + count);
        System.out.println("child" + child);
    }

    void swap(int i, int j) {
        int s = heapArray[j];
        heapArray[j] = heapArray[i];
        heapArray[i] = s;
        count++;
        arrayList.add(new Reverse());
        arrayList.get(count).setParentChild(j, i);
    }

    public int extractMin() {
        int root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        siftDown(0);
        return root;
    }

    private void siftDown(int index) {
        int minChild = index;
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        if (leftChild < maxSize && heapArray[leftChild] < heapArray[minChild]) {
            minChild = leftChild;
        }

        if (rightChild < maxSize && heapArray[rightChild] < heapArray[minChild]) {
            minChild = rightChild;
        }
        if (index != minChild) {
            swap(index, minChild);
            siftDown(minChild);
        }

//        int minChild = -1;
//        int top = heapArray[index];
//        while (index < currentSize / 2) { // Are there descendants?
//            int leftChild = 2 * index + 1;
//            int rightChild = leftChild + 1;
//
//            if (rightChild < currentSize &&
//                    heapArray[leftChild] > heapArray[rightChild]) {
//                minChild = rightChild;
//            } else {
//                minChild = leftChild;
//            }
//
//            if (top <= heapArray[minChild]) {
//                break;
//            }
//            count++;
//            arrayList.add(new Reverse());
//            arrayList.get(count).child = index;
//            arrayList.get(count).parent = minChild;
//            heapArray[index] = heapArray[minChild];
//            index = minChild;
//            heapArray[index] = top;
//        }
        //heapArray[index] = top;
    }
}

