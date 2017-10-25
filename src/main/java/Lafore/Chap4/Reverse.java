package Lafore.Chap4;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        StakX<Character> word = new StakX<>();
        Scanner s = new Scanner(System.in);
        String q = s.next();
        int i = 0;
        while (i < q.length()) {
            word.push(q.charAt(i));
            i++;
        }
        while(!word.isEmpty()){
            System.out.print(word.pop());
        }
    }
}
