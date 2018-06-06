package Stepic.TheoryAndPractise_DataStructure.Lesson_1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Window {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(System.in);
        BufferedReader r = new BufferedReader(
                new InputStreamReader(bis, StandardCharsets.UTF_8));

        int n = Integer.parseInt(r.readLine().replaceAll(" ", ""));
        String[] arrayList;

        arrayList = r.readLine().split(" ");

        int m = Integer.parseInt(r.readLine());

        QueueWithMin queueWithMin = new QueueWithMin();
        int k = 0;
        for (; k < m; k++) {
            queueWithMin.push(Integer.parseInt(arrayList[k]));
        }

        System.out.print(queueWithMin.peakMax()+" ");

        for (; k < n; k++) {
            queueWithMin.push(Integer.parseInt(arrayList[k]));
            queueWithMin.popElem();
            System.out.print(queueWithMin.peakMax()+" ");
        }
    }
}

class QueueWithMin {
    StackWithMin stackWithMin1 = new StackWithMin();
    StackWithMin stackWithMin2 = new StackWithMin();

    public void push(int j) {
        stackWithMin1.push(j);
    }

    public int popElem() {
        if (stackWithMin2.isEmpty()) {
            while (!stackWithMin1.isEmpty()) {
                int elem = stackWithMin1.popElem();
                stackWithMin2.push(elem);
            }
        }
        return stackWithMin2.popElem();
    }

    public int peakMax() {
        if (stackWithMin2.isEmpty() || stackWithMin1.isEmpty()) {
            return stackWithMin1.isEmpty() ? stackWithMin2.peakMax() : stackWithMin1.peakMax();
        } else {
            return Math.max(stackWithMin1.peakMax(), stackWithMin2.peakMax());
        }
    }
}

class StackWithMin {
    ArrayList<int[]> stack = new ArrayList<>();
    int top = -1;

    public void push(int[] j) {
        stack.add(j);
        top++;
    }

    public void showStack() {
        for (int i = 0; i <= top; i++) {
            System.out.println("i = " + i + ": " + stack.get(i)[0] + " " + stack.get(i)[1]);
        }
    }

    public void push(int j) {

        if (stack.size() > ++top) {
            if (top == 0) {
                stack.set(top, new int[]{j, j});
            } else if (stack.get(top - 1)[1] < j) {
                stack.set(top, new int[]{j, j});
            } else {
                stack.set(top, new int[]{j, stack.get(top - 1)[1]});
            }

        } else {
            if (top == 0) {
                stack.add(new int[]{j, j});
            } else if (stack.get(top - 1)[1] < j) {
                stack.add(new int[]{j, j});
            } else {
                stack.add(new int[]{j, stack.get(top - 1)[1]});
            }
        }
    }

    public int[] popElemWithMax() {
        int[] remove = stack.get(top);
        top--;
        return remove;
    }

    public int popElem() {
        int remove = stack.get(top)[0];
        top--;
        return remove;
    }

    public int popMax() {
        int remove = stack.get(top)[1];
        top--;
        return remove;
    }

    public int peakElem() {
        return stack.get(top)[0];
    }

    public int peakMax() {
        return stack.get(top)[1];
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else
            return false;
    }

    public int size() {
        return top + 1;
    }
}
