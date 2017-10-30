package Lafore.Chap5_LinkedList;

/**
 * Class consist of only one element. This element is link on first element of
 * LinkedList. You can find remaining elements if you begin from it element.
 */
public class LinkList {
    private Link first; // default null

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
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

    public void displayList() {
        System.out.println("List: ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }
}
