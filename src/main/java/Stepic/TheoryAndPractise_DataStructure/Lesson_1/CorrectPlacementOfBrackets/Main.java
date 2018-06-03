package Stepic.TheoryAndPractise_DataStructure.Lesson_1.CorrectPlacementOfBrackets;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    private static int j = 0;
    private static int k = 0;

    public static void main(String[] args) {
        System.out.println(new Main().run());
    }

    public class StackX<T> {
        //private int size;
        private ArrayList<T> stackArray;
        private int top;

        public StackX(int j) {
            //size = j;
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
            return stackArray.remove(top--);
            //return stackArray.get(top--);// top перемещается, и значение хоть и сохранется в массиве, но недоступно
        }

        public T peek() {
            return stackArray.get(top);
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }


    public String run() {
        Scanner s = new Scanner(in);
        StackX<Character> stackX = new StackX<>();
        String q = s.next();
        int i = 0;
        while (i < q.length()) {
            char ch = q.charAt(i);

            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stackX.push(ch);
                    //j = j - 2;
                    break;
                case ')':
                case '}':
                case ']':
                    if (stackX.isEmpty() || !equalsBraces(stackX, ch, stackX.pop())) {
                        return "" + (i + 1);
                    }
//                    }else if ()) {
//                        return "" + (i + 1);
//                    }
//                    } else if(stackX.isEmpty()){
//                        return ""+(i+1);
//                    }
                    break;
            }
            i++;
        }
        if (stackX.isEmpty()) {
            return "Success";
        } else {
            return "" + ( stackX.getSize() + j);
        }
    }

    public boolean equalsBraces(StackX stackX, Character ch1, Character ch2) {
        if ((ch1 == ')' && ch2 == '(') || (ch1 == '}' && ch2 == '{') || (ch1 == ']' && ch2 == '[')) {
            if (!stackX.isEmpty()) {
                k = k + 2;
            } else {
                j = j + 2 + k;
                k = 0;
            }
            return true;
        } else {
            return false;
        }
    }
}
