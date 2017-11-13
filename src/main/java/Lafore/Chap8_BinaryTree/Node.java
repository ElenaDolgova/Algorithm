package Lafore.Chap8_BinaryTree;

public class Node {

    public int id;
    public Node leftChild;
    public Node rightChild;

    public Node(int id) {
        this.id = id;
    }

    public void displayNode() {
        System.out.println("id: " + id);
    }
}
