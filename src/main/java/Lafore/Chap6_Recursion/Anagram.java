package Lafore.Chap6_Recursion;

import java.util.Scanner;

public class Anagram {

    public int size;
    public int count;
    public StringBuffer str;

    public Anagram() {
        Scanner s = new Scanner(System.in);
        str = new StringBuffer(s.next());
        size = str.length();
    }

    public Anagram(String str) {
        this.str = new StringBuffer(str);
        size = str.length();
    }

    public void doAnagram(int n) {
        if (n == 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            doAnagram(n - 1);
            if (n == 2) {
                displayWord(); // Get the word out
                count++;
            }
            rotate(n); // Cyclic shift of the word
        }
    }

    private void rotate(int n) {
        int pos = size - n;
        char chr = str.charAt(pos); // Saving the first letter
        for (int i = pos + 1; i < size; i++) {
            str.setCharAt(i - 1, str.charAt(i));
        }
        str.setCharAt(size - 1, chr);
    }

    private void displayWord() {
        for (int i = 0; i < size; i++) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }
}
