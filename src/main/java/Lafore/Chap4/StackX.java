package Lafore.Chap4;

import java.util.ArrayList;

public class StackX<T> {
    private ArrayList<T> stackArray;
    private int top;

    public StackX(int j) {
        stackArray = new ArrayList<T>(j);
        top = -1;
    }

    public int getSize() {
        return stackArray.size();
    }

    public StackX() {
        stackArray = new ArrayList<T>();
        top = -1;
    }

    public void push(T s) {
        if (stackArray.size() > ++top) {
            stackArray.set(top, s);
        } else {
            stackArray.add(s);
        }
    }

    public T pop() {
        return stackArray.get(top--);// top перемещается, и значение хоть и сохранется в массиве, но недоступно
    }

    public T peek() {
        return stackArray.get(top);
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
