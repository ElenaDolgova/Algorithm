package Lafore.Chap5_LinkedList;

/**
 * Stack based on LikedList
 */
public class LinkStack<T> {
    private LinkList linkList; // first element in link

    public LinkStack(){
        linkList = new LinkList();
    }
    public boolean isEmpty(){
        return linkList.isEmpty();
    }

    public void push(T id){
        linkList.insertFirst(id);
    }

    public T pop() throws LinkedListException {
        return (T) linkList.deleteFirst().iData;
    }
    public void displayStack() throws LinkedListException {
        System.out.println("Stack: ");
        linkList.displayList();
        System.out.println();
    }
}
