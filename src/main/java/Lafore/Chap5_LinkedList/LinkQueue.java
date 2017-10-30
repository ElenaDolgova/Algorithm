package Lafore.Chap5_LinkedList;

/**
 * Queue based on bilateral LinkedList {@see Lafore.Chap5_LinkedList.FirstLastLink}
 */
public class LinkQueue<T> {
    private FirstLastList<T> list;

    public LinkQueue() {
        list = new FirstLastList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void insert(T id) {
        list.insertLast(id);
    }

    public T remove() throws LinkedListException {
        return (T) list.deleteFirst().iData;
    }

    public void displayQueue() {
        System.out.println("Queue: ");
        list.displayList();
    }
}
