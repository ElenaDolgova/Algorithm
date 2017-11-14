package Lafore.Chap8_BinaryTree;

public class HuffmanCode {
    char symbol;
    int frequency;

    HuffmanCode(char symbol, int frequency){
        this.symbol = symbol;
        this.frequency = frequency;
    }

    HuffmanCode(int frequency){
        this.frequency = frequency;
    }
}
