package Lafore.Chap4;

public class ParsePostfix {
    private StackX<Long> stackX;

    public ParsePostfix() {
        stackX = new StackX<>();
    }

    public long doParse(StringBuilder stringBuilder) {
        long num = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            char ch = stringBuilder.charAt(i);
            if ((isNumber(ch))) {
                stackX.push((long) ch - '0');
            } else {
                long num1 = stackX.pop();
                long num2 = stackX.pop();
                switch (ch) {
                    case '+':
                        num = num1 + num2;
                        break;
                    case '-':
                        num = num2 - num1;
                        break;
                    case '*':
                        num = num1 * num2;
                        break;
                    case '/':
                        num = num1 / num2;
                        break;
                }
                stackX.push(num);
            }
        }
        return stackX.pop();
    }

    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
