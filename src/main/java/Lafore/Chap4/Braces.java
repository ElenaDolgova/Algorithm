package Lafore.Chap4;

import java.util.Scanner;

import static java.lang.System.in;

public class Braces {
    private static int j = 0;
    private static int k = 0;

    public static void main(String[] args) {
        System.out.println(new Braces().run());
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
                    break;
                case ')':
                case '}':
                case ']':
                    if (stackX.isEmpty() || !equalsBraces(stackX, ch, stackX.pop())) {
                        return "" + (i + 1);
                    }
                    break;
            }
            i++;
        }
        if (stackX.isEmpty()) {
            return "Success";
        } else {
            return "" + (stackX.getSize() + j);
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
