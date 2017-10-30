package Lafore.Chap5_LinkedList;

public class FirstLastList<T> {
    private Link first;
    private Link last;

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(T id) {
        Link temp = new Link(id);
        if (isEmpty()) {
            this.last = temp;
        }
        temp.changeNext(this.first);
        this.first = temp;
    }

    public void insertLast(T id) {
        Link temp = new Link(id);
        if (isEmpty()) {
            this.first = temp;
        } else {
            this.last.changeNext(temp);
        }
        this.last = temp;
    }

    public Link deleteFirst() throws LinkedListException {
        if (isEmpty()) {
            throw new LinkedListException("LinkedList is empty");
        }
        Link temp = this.first;
        if (this.first.getNext() == null) { // only one element
            this.last = null;
        }
        this.first = this.first.getNext();
        return temp;
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("There is nothing to display. LinkedList is empty.");
            return;
        }
        System.out.println("List: ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }
}
