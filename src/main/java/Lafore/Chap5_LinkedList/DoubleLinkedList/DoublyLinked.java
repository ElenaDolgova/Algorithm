package Lafore.Chap5_LinkedList.DoubleLinkedList;

import Lafore.Chap5_LinkedList.LinkedListException;

public class DoublyLinked<T extends Comparable> {
    private Link first;
    private Link last;

    public DoublyLinked() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(T id) {
        Link newLink = new Link(id);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(T id) {
        Link newLink = new Link(id);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        newLink.previous = last;
        last = newLink;
    }

    public void insertAfter(T id, T key) throws LinkedListException {
        if (isEmpty()) {
            throw new LinkedListException("There is no elements");
        } else {
            Link current = first;
            while (current.compareTo(key) != 0) {
                current = current.next;
                if (current == null) {
                    throw new LinkedListException("There is no elements");
                }
            }
            if (current == null) {
                throw new LinkedListException("There is no elements");
            }
            Link newLink = new Link(id);
            if (current == last) {
                newLink.next = null;
                last = newLink;
            }else{
                newLink.next = current.next;
                current.next.previous = newLink;
            }
            newLink.previous = current;
            current.next = newLink;
        }
    }

    public Link deleteFirst() {
        Link temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    public Link deleteLast() {
        Link temp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    public Link deleteKey(T key) throws LinkedListException {
        Link current = first;
        while (current.compareTo(key) != 0) {
            current = current.next;
            if (current == null) {
                throw new LinkedListException("There is no elements");
            }
        }
        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current;
    }

    public void displayForward() {
        System.out.print("List: ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.print("List: ");
        Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
        System.out.println();
    }
}
