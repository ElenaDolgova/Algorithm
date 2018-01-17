package Lafore.Chap8_BinaryTree;

import java.util.Scanner;

public class MainDecideHuffmanCode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfList = sc.nextInt();
        int strOutNumber = sc.nextInt();
        BTHuffmanCode bt = new BTHuffmanCode();
        int i = 0;
        sc.nextLine();
        while (i < numberOfList) {
            String str = sc.nextLine();
            bt.insertByPath(str.charAt(0), str.substring(3, str.length()));
            i++;
        }
        StringBuilder strb = new StringBuilder(sc.next());
        i = 0;

        while (i != strOutNumber ) {
            i = bt.printCharacter(i, strb);
        }
    }
}



