package Lafore.Chap8_BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class BTHuffmanCode {
    private NodeHuffmanCode root;
    public static Map<Character, String> map = new HashMap<>();

    public void insert(BTHuffmanCode newBT) {


        if (this.root.leftChild == null) {
            this.root.leftChild = newBT.root;
        } else {
            this.root.rightChild = newBT.root;
        }
    }

    public void insertByPath(char symbol, String path) {
        NodeHuffmanCode newNode = new NodeHuffmanCode(symbol, 0); // There is path to symbol instead frequency

        if (root == null) {
            root = new NodeHuffmanCode(':', -1);
        }
        insertNode(root, newNode, path);
    }

    private void insertNode(NodeHuffmanCode node, NodeHuffmanCode newNode, String path) {
        int i = 0;
        while (i < path.length() - 1) {
            if (path.charAt(i) == '1') {
                if (node.rightChild == null) {
                    node.rightChild = new NodeHuffmanCode(':', -1);
                    node = node.rightChild;
                } else {
                    node = node.rightChild;
                }
            } else if (path.charAt(i) == '0') {
                if (node.leftChild == null) {
                    node.leftChild = new NodeHuffmanCode(':', -1);
                    node = node.leftChild;
                } else {
                    node = node.leftChild;
                }
            }
            i++;
        }
        if (path.charAt(path.length() - 1) == '1') {
            node.rightChild = newNode;
        } else if (path.charAt(path.length() - 1) == '0') {
            node.leftChild = newNode;
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

            }
            preOrder(node.leftChild, str + "0");
            preOrder(node.rightChild, str + "1");
        }
    }

    public Map<Character, String> getMap() {
        return map;
    }

    public int printCharacter(int k, StringBuilder strB) {

        NodeHuffmanCode node = this.root;

        while (node.hc.symbol == ':') {
            if (strB.charAt(k) == '0') {
                k++;
                node = node.leftChild;
                if (node.hc.symbol != ':') {
                    System.out.print(node.hc.symbol);
                    return k;
                }
            } else {
                k++;
                node = node.rightChild;
                if (node.hc.symbol != ':') {
                    System.out.print(node.hc.symbol);
                    return k;
                }
            }
        }
        return -1;
    }
}
