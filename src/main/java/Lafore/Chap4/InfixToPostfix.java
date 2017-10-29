package Lafore.Chap4;

import java.util.Scanner;

/**
 * Преобразовываем инфиксную запись в постфиксную. Реалиация на основе стека (сейчас стек на основе массива,
 * который влечет за собой меленную вставку).
 * Главная задача это преобразование выражения вида А+В -> АВ+; ((А+В)*С)-D -> AB+C*D-
 * Для простоты будем пока считать, что операнды - это цифры.
 * Пользуемся такими правилами:
 * 1. Если прочитан операнд, то записываем его в выходную строку
 * 2. Если прочитана (, то заносим ее в стек
 * 3. Если прочитана ), то  если в стеке остаются элементы, то извлекаем элемент
 * если элемент отличен от (, то записываем в выходную строку
 * При чтении элемента ), выходим з строки.
 * 4.Если прочитна оператор, то если стек пуст, то заносим его в стек.
 * В ином случае, пока в стеке остаются элементы
 * Извлечь элемент.
 * Если это элемен (, заносим его в стек,
 * если это оператор, то если приоритет оператора из стека ниже нового, то обратно
 * заносим в стек недавно прочитанный оператор из него и выходим из цикла, также выходим
 * из цикла, если извлекли (.
 * В ином случае оператор из стека скопировать в выходную строку.
 * Заносим в стек, считанный оператор из строки.
 * 5. Если в строке ничего больше нет, то пока в стеке остаются элементы извлекаем их и вносим в выходную строку.
 *
 * @author Elena
 * @version 1.0
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        new InfixToPostfix().run();
        System.out.println(out);
        ParsePostfix parsePostfix = new ParsePostfix();
        System.out.println(parsePostfix.doParse(out));
    }

    public static StringBuilder out;
    private StackX<Character> stackX;
    private String str;

    public InfixToPostfix() {
        Scanner s = new Scanner(System.in);
        str = s.next();
        out = new StringBuilder(str.length());
        stackX = new StackX<>();
    }

    public void run() {
        char ch, ch0;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (isNumber(ch)) {
                out.append(ch);
                if (i == str.length() - 1) {
                    while (!stackX.isEmpty()) {
                        if (stackX.peek() != '(') {
                            out.append(stackX.pop());
                        } else stackX.pop();
                    }
                    continue;
                }
                continue;
            }
            if (ch == ')' && (i == str.length() - 1)) {
                while (!stackX.isEmpty()) {
                    if (stackX.peek() != '(') {
                        out.append(stackX.pop());
                    } else stackX.pop();
                }
                continue;
            }

            switch (ch) {
                case '(':
                    stackX.push(ch);
                    break;
                case ')':
                    ch0 = stackX.pop();
                    while (ch0 != '(') {
                        out.append(ch0);
                        ch0 = stackX.pop();
                    }
                    break;
                default:
                    if (stackX.isEmpty()) {
                        stackX.push(ch);
                    } else {
                        while (!stackX.isEmpty()) {
                            ch0 = stackX.pop();
                            if (ch0 == '(') {
                                stackX.push(ch0);
                                break;
                            } else if (!priorityOperator(ch, ch0)) {
                                out.append(ch0);
                            } else {
                                stackX.push(ch0);
                                break;
                            }
                        }
                        stackX.push(ch);
                    }
            }

        }
    }

    /**
     * @param ch0 из строки
     * @param ch1 из стека
     * @return Если ch0 имеет приоритет ниже чем ch1, то false, в ином случае, если больше либо равен, то true
     */
    private boolean priorityOperator(char ch0, char ch1) {
        switch (ch0) {
            case '-':
            case '+':
                if (ch1 == '*' || ch1 == '/') {
                    return false;
                } else {
                    return true;
                }
            default:
                return true;
        }
    }

    private boolean isNumber(char var) {
        return var >= '0' && var <= '9';

    }

}
