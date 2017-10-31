package Lafore.Chap5_LinkedList;

/**
 * Class consist of only one element. This element is link on first element of
 * LinkedList. You can find remaining elements if you begin from this element.
 */
public class LinkList<T> {
    private Link first; // default null

    public Link find(T key) throws LinkedListException {
        if (isEmpty()) {
            throw new LinkedListException("There is no first element. LinkedList is empty.");
        }
        Link current = first;
        while (!current.iData.equals(key)) {
            if (current.getNext() == null) {
                return null;
            } else {
                current = current.getNext();
            }
        }
        return current;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(T id) {
        Link newLink = new Link((Comparable) id);
        newLink.changeNext(first);
        first = newLink;
    }

    public Link deleteFirst() throws LinkedListException {
        if (isEmpty()) {
            throw new LinkedListException("There is no first element. LinkedList is empty.");
        }
        Link temp = this.first;
        this.first = first.getNext();
        return temp;
    }

    public void displayList() throws LinkedListException {
        if (isEmpty()) {
            throw new LinkedListException("There is no first element. LinkedList is empty.");
        }
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
    }

    public Link delete(T key) throws LinkedListException {
        if (isEmpty()) {
            throw new LinkedListException("There is no first element. LinkedList is empty.");
        }
        Link previous = this.first;
        Link current = this.first;
        while (!current.iData.equals(key)) {
            if (current.getNext() == null) {
                return null;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        if (current == this.first) { // there is no elements before first
            first = first.getNext();
        } else {
            previous.changeNext(current.getNext()); // delete current element
        }
        return current;
    }
}
