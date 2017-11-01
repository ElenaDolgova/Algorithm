package Lafore.Chap5_LinkedList;

public class Iterator<T extends Comparable> {
    private Link current;
    private Link previous;
    private LinkList list;

    public Iterator(LinkList list) {
        this.list = list;
        reset();
    }

    /**
     * Moves the iterator to the beginning at the list
     */
    public void reset() {
        current = list.getFirst();
        previous = null;
    }

    /**
     * @return true if at the end of list
     */
    public boolean atEnd() {
        return (current.getNext() == null);
    }

    /**
     * Moves to the next element of list
     */
    public void nextLink() {
        previous = current;
        current = current.getNext();
    }

    public Link getCurrent() {
        return current;
    }

    /**
     * Insert after current element at the list
     *
     * @param id is new element of the list
     */
    public void insertAfter(T id) {
        Link newLink = new Link(id);

        if (list.isEmpty()) {
            list.setFirst(newLink);
            current = newLink;
        } else {
            newLink.changeNext(current.getNext());
            current.changeNext(newLink);
            nextLink();
        }
    }

    public void insertBefore(T id) {
        Link newLink = new Link(id);
        if (previous == null) { // isEmpty()== null || at the beginning of list
            newLink.changeNext(list.getFirst()); // null (list is empty) || next element
            list.setFirst(newLink);
            reset();
        } else {
            newLink.changeNext(current); //??? newLink.changeNext(previous.getNext());
            previous.changeNext(newLink);
            current = newLink;
        }
    }

    public T deleteCurrent() {
        T temp = (T) current.iData;

        if (previous == null) {// At the beginning
            list.setFirst(current.getNext());
            reset();
        } else {
            previous = current.getNext();
            if (atEnd()) {
                reset();
            } else {
                current = current.getNext();
            }
        }
        return temp;
    }
}
