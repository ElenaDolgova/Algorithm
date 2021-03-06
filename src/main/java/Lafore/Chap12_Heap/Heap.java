//package Lafore.Chap12_Heap;
//
//public class Heap {
//    private int maxSize;
//    private int currentSize;
//    private Node[] heapArray;
//
//    public Heap(int max) {
//        this.maxSize = max;
//        heapArray = new Node[maxSize];
//        this.currentSize = 0;
//    }
//
//    public boolean insert(int data) {
//        if (currentSize == maxSize) {
//            return false;
//        } else {
//            Node node = new Node(data);
//            heapArray[currentSize] = node;
//            trickleUp(currentSize++);
//            return true;
//        }
//    }
//
//    private void trickleUp(int index) {
//        int parent = (index - 1) / 2;
//        Node node = heapArray[index];
//
//        while (index > 0 &&
//                heapArray[parent].getData() < node.getData()) {
//            heapArray[index] = heapArray[parent];
//            index = parent;
//            parent = (parent - 1) / 2;
//        }
//        heapArray[index] = node;
//    }
//
//    public int extractMax() {
//        Node root = heapArray[0];
//        heapArray[0] = heapArray[--currentSize];
//        trickleDown(0);
//        return root.getData();
//    }
//
//    private void trickleDown(int index) {
//        int largeChild;
//        Node top = heapArray[index];
//        while (index < currentSize / 2) { // Are there descendants?
//            int leftChild = 2 * index + 1;
//            int rightChild = leftChild + 1;
//
//            if (rightChild < currentSize &&
//                    heapArray[leftChild].getData() < heapArray[rightChild].getData()) {
//                largeChild = rightChild;
//            } else {
//                largeChild = leftChild;
//            }
//
//            if (top.getData() >= heapArray[largeChild].getData()) {
//                break;
//            }
//            heapArray[index] = heapArray[largeChild];
//            index = largeChild;
//        }
//        heapArray[index] = top;
//    }
//}
