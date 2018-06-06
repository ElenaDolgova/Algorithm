package Stepic.TheoryAndPractise_DataStructure.Lesson_1.StackMax;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Stack {

    ArrayList<Integer> stack;
    ArrayList<Integer> stackOfMax;
    private int top;
    private int size;

    Stack() {
        stack = new ArrayList<>();
        stackOfMax = new ArrayList<>();
        top = -1;
    }

    public void push(int j) {

        if (stack.size() > ++top) {
            stack.set(top, j);

            if (stackOfMax.get(top - 1) < j) {
                stackOfMax.set(top, j);
            } else {
                stackOfMax.set(top, stackOfMax.get(top - 1));
            }
        } else {
            stack.add(j);

            if (top != 0) {
                if (stackOfMax.get(top - 1) < j) {
                    stackOfMax.add(j);
                } else {
                    stackOfMax.add(stackOfMax.get(top - 1));
                }
            } else {
                stackOfMax.add(j);
            }

        }
    }

    public int pop() {
        int remove = stack.get(top);
        stackOfMax.get(top);
        top--;
        return remove;
    }

    public int max() {
        //System.out.println(top);
        return stackOfMax.get(top);
    }


    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(System.in);
        BufferedReader r = new BufferedReader(
                new InputStreamReader(bis, StandardCharsets.UTF_8));
        //Scanner s = new Scanner(System.in);
        int n = 0;
        try {
            n = Integer.parseInt(r.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;

        Stack stack = new Stack();
        //r.readLine();

        //System.out.println(n);

        while (i < n) {

            String str = r.readLine();

            //System.out.println(str);

            if (str.contains("pu")) {
                stack.push(Integer.parseInt(str.substring(str.indexOf(" ") + 1)));
            } else if (str.contains("po")) {
                stack.pop();
            } else {
                System.out.println(stack.max());
            }
            i++;
            //System.out.println("i " + i);
        }
    }
}
