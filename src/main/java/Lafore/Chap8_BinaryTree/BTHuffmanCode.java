package Lafore.Chap8_BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BTHuffmanCode {
    private NodeHuffmanCode root;
    //public static String hCode = "";
    public static Map<Character, String> map = new HashMap<>();

    public void insert(BTHuffmanCode newBT) {


        if (this.root.leftChild == null) {
            this.root.leftChild = newBT.root;
        } else {
            this.root.rightChild = newBT.root;
        }
    }

    public void insert(int frequency) {
        NodeHuffmanCode newNode = new NodeHuffmanCode(frequency);

        if (root == null) {
            root = newNode;
        } else {
            NodeHuffmanCode current = root;
            NodeHuffmanCode parent = current;

            while (true) {
                if (frequency < current.hc.frequency) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void insert(char symbol, int frequency) {
        NodeHuffmanCode newNode = new NodeHuffmanCode(symbol, frequency);

        if (root == null) {
            root = newNode;
        } else {
            NodeHuffmanCode current = root;
            NodeHuffmanCode parent = current;

            while (true) {
                if (frequency < current.hc.frequency) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public int getFrecuency() {
        return root.hc.frequency;
    }

    public char getSymbol() {
        return root.hc.symbol;
    }

    public void roundAll() {
        preOrder(this.root, "");
    }

    private void preOrder(NodeHuffmanCode node, String str) {
        if (node != null) {
            if (node.hc.symbol != ';') {
                //System.out.print(node.hc.symbol + " " + str);
                map.put(node.hc.symbol, str);
                //System.out.println();
            }
            preOrder(node.leftChild, str + "0");
            preOrder(node.rightChild, str + "1");
        }
    }

    public Map<Character, String> getMap() {
        return map;
    }
}
