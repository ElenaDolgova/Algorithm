package Lafore.Chap5_LinkedList;

public class SortedList<T extends Comparable> {
    private Link first;

    public boolean isEmpty() {
        return (first == null);
    }

    public void insert(T key) {
        Link newLink = new Link(key);
        Link previous = null;
        Link current = first;

        while (current != null && current.compareTo(key) < 0) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) {
            first = newLink; // At the beginner of the list
        } else {
            previous.changeNext(newLink);
        }
        newLink.changeNext(current);
    }

    public Link removeFirst() throws LinkedListException {
        if (isEmpty()) {
            throw new LinkedListException("SortedList is empty");
        }
        Link temp = first;
        first = first.getNext();
        return temp;
    }

    public void displaySL() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }
}
