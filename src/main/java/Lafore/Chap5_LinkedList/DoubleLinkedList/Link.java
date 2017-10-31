package Lafore.Chap5_LinkedList.DoubleLinkedList;

public class Link<T extends Comparable> {
    public T iData;
    public Link previous;
    public Link next;

    public Link(T iData) {
        this.iData = iData;
    }

    public void displayLink() {
        System.out.print(iData + " ");
    }

    public int compareTo(T iData) {
        return this.iData.compareTo(iData);
    }

}
