package Stepic.TheoryAndPractise_DataStructure.Lesson_1.CorrectPlacementOfBrackets;

import Stepic.TheoryAndPractise_DataStructure.Stack;
import java.util.Scanner;

import static java.lang.System.in;

public class Brackets {
    private static int j = 0;
    private static int k = 0;

    public static void main(String[] args) {
        System.out.println(new Brackets().run());
    }

    public String run() {
        Scanner s = new Scanner(in);
        Stack<Character> stack = new Stack<>();
        String q = s.next();
        int i = 0;
        while (i < q.length()) {
            char ch = q.charAt(i);

            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                case '}':
                case ']':
                    if (stack.isEmpty() || !equalsBraces(stack, ch, stack.pop())) {
                        return "" + (i + 1);
                    }
                    break;
            }
            i++;
        }
        if (stack.isEmpty()) {
            return "Success";
        } else {
            return "" + ( stack.getSize() + j);
        }
    }

    public boolean equalsBraces(Stack stack, Character ch1, Character ch2) {
        if ((ch1 == ')' && ch2 == '(') || (ch1 == '}' && ch2 == '{') || (ch1 == ']' && ch2 == '[')) {
            // for number of char mistake
            if (!stack.isEmpty()) {
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
