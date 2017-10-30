package Lafore.Chap5_LinkedList;

/**
 * It is simple Linkedlist with some data (I don't know exactly what is it).
 * I did it for abstract data.
 */
public class Link<T> {
    public T iData;
    private Link next; // default null

    public Link(T id) {
        iData = id;
    }

    public void displayLink() {
        System.out.print(iData + " ");
    }

    public void changeNext(Link next) {
        this.next = next;
    }

    public Link getNext() {
        return next;
    }
}
