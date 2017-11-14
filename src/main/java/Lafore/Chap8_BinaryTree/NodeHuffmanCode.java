package Lafore.Chap8_BinaryTree;

public class NodeHuffmanCode {
    public HuffmanCode hc;
    NodeHuffmanCode leftChild;
    NodeHuffmanCode rightChild;

    public NodeHuffmanCode(char symbol, int frequency) {
        this.hc = new HuffmanCode(symbol, frequency);
    }

    public NodeHuffmanCode(int frequency) {
        this.hc = new HuffmanCode(';', frequency);
    }
}
