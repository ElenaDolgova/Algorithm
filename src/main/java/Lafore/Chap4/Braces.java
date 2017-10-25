package Lafore.Chap4;

import java.util.Scanner;

public class Braces {
    public static void main(String[] args) {
        System.out.println(new Braces().run());
    }

    public String run() {
        Scanner s = new Scanner(System.in);
        StackX<Character> stackX = new StackX<>();
        String q = s.next();
        int i = 0;
        while (i < q.length()) {
            char ch=q.charAt(i);

            switch (ch){
                case '(':
                case '{':
                case '[':
                    stackX.push(ch);
                    break;
                case ')':
                case '}':
                case ']':
                    if(!stackX.isEmpty()&&!equalsBraces(ch,stackX.pop())){
                        return ""+(i+1);
                    }
                    break;
            }
            i++;
        }
        if(stackX.isEmpty()){
            return "Success";
        }else {
            return ""+i;
        }
    }

    public boolean equalsBraces(Character ch1, Character ch2) {
        if ((ch1 == ')' && ch2 == '(') || (ch1 == '}' && ch2 == '{') || (ch1 == ']' && ch2 == '[')) {
            return true;
        } else {
            return false;
        }
    }
}
