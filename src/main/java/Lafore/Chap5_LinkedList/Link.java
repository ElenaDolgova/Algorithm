package Lafore.Chap5_LinkedList;

/**
 * It is simple Linkedlist with some data (I don't know exactly what is it).
 * I did it for abstract data.
 */
public class Link {
    public int iData;
    public double dData;
    private Link next; // default null

    public Link(int id, double dd) {
        iData = id;
        dData = dd;
    }

    public void displayLink() {
        System.out.println(iData + ", " + dData);
    }

    public void changeNext(Link next) {
        this.next = next;
    }

    public Link getNext() {
        return next;
    }
}
