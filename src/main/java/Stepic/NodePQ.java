package Stepic;

public class NodePQ {
    private ElementOfQueue EQ;
    private NodePQ parent;
    private NodePQ leftChild;
    private NodePQ rightChild;
    private boolean left;

    NodePQ(int priority) {
        this.EQ = new ElementOfQueue(priority);
    }

    public void setParent(NodePQ parent) {
        this.parent = parent;
    }

    public NodePQ getParent() {
        return parent;
    }

    public void setLeftChild(NodePQ left) {
        this.leftChild = left;
    }

    public void setRightChild(NodePQ right) {
        this.rightChild = right;
    }

    public void setBothChildren(NodePQ left, NodePQ right) {
        this.rightChild = right;
        this.leftChild = left;
    }

    public NodePQ getLeftChild() {
        return this.leftChild;
    }

    public NodePQ getRightChild() {
        return this.rightChild;
    }

    public int getPriority() {
        return EQ.getPriority();
    }

    public void setPriority(int priority) {
        this.EQ.changePriority(priority);
    }

    public boolean areLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public int getMaxFromChildren() {
        if (leftChild == null && rightChild == null) {
            return -1;
        } else if (leftChild == null) {
            return rightChild.getPriority();
        } else if (rightChild == null) {
            return leftChild.getPriority();
        } else {
            return Integer.max(rightChild.getPriority(), leftChild.getPriority());
        }
    }

    public int getMinFromChildren() {
        if (leftChild == null && rightChild == null) {
            return -1;
        } else if (leftChild == null) {
            return rightChild.getPriority();
        } else if (rightChild == null) {
            return leftChild.getPriority();
        } else {
            return Integer.min(rightChild.getPriority(), leftChild.getPriority());
        }
    }
}
