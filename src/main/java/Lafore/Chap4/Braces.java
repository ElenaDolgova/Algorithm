package Lafore.Chap4;
/**
 * Правильная растановка скобок {},(),[]
 * Если все верно, то выводится Success, в ином случае выводится номер символа в строке, где скобка стоит неверно
 */

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
        String q = s.next(); // Считываем целую строку
        int i = 0;
        while (i < q.length()) {// Пока не достигнем конца считанной строки
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
        if (stackX.isEmpty()) { // Проверяет случаи вида: {[][}.
            return "Success";
        } else {
            return "" + (stackX.getSize() + j);
        }
    }

    /**
     *
     * @param stackX стек, заполненный скобками
     * @param ch1 элемент считанный из строки
     * @param ch2 элемен считанный из стека
     * @return true, если скбки дополняют друг друга, false если скобки разного типа или в разной последовательности.
     * Например, [], (), {} - true, [}, }{ и т.д - false
     */

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
