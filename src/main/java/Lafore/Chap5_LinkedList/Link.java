package Lafore.Chap5_LinkedList;

/**
 * It is simple Linkedlist with some data (I don't know exactly what is it).
 * I did it for abstract data.
 */
public class Link<T extends Comparable> {
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

    public int compareTo(T iData) {
        return this.iData.compareTo(iData);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link<?> link = (Link<?>) o;

        if (iData != null ? !iData.equals(link.iData) : link.iData != null) return false;
        return next != null ? next.equals(link.next) : link.next == null;
    }

    @Override
    public int hashCode() {
        int result = iData != null ? iData.hashCode() : 0;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}
