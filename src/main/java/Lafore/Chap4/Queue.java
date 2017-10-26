package Lafore.Chap4;

import java.util.ArrayList;

public class Queue<T> {
    private int maxSize;
    private ArrayList<T> queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        maxSize = s;
        queArray = new ArrayList<>(maxSize);
        front = 0;
        rear = -1;
        //nItems = 0;
    }

    public void insert(T j) throws QueueException {
        if (isFull()) {
            throw new QueueException("Queue is full");
        }
        if (rear == maxSize - 1) {//Циклический перенос
            rear = -1;
        }
        queArray.set(++rear, j);//Сначала увеличиваем, потом вставляем
        //nItems++;
    }

    public T remove() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Queue is empty");
        }
        T temp = queArray.get(front++);//Сначала выбираем, потом увеличиваем front
        if (front == maxSize) {//Если front достиг конца, то перносим
            front = 0;
        }
        //nItems--;
        return temp;
    }

    public T peekFront() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Queue is empty");
        }
        return queArray.get(front);
    }

    public boolean isEmpty() {
        return (rear + 1 == front || (front + maxSize - 1 == rear));
    }

    public boolean isFull() {
        return (rear + 2 == front || (front + maxSize - 2 == rear));
    }

    public int getMaxSize() {
        if (rear >= front) {//непрерывная последовательность
            return rear - front + 1;
        } else {//несвязанная последовательност
            return (maxSize - front) + (rear + 1);
        }
    }
}
