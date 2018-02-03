package Stepic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str;
        int i = 0;
        TreePQ treePQ = new TreePQ();
        while (i < n) {
            str = sc.nextLine();
            String part2;
            if (str.contains(" ")){
                part2 = str.substring(str.indexOf(" ") + 1, str.length());
                treePQ.insert(Integer.parseInt(part2));
            }else {
                System.out.println(treePQ.extractMax());
            }
            i++;
        }
    }
}

class TreePQ implements InTreePQ {
    private NodePQ root;
    private NodePQ last;

    @Override
    public void insert(int p) {
        NodePQ newNodePQ = new NodePQ(p);

        if (root == null) {
            root = newNodePQ;
            last = newNodePQ;
            root.setLeft(false);
        } else {
            if (newNodePQ.getPriority() % 2 == 0) {
                last.setRightChild(newNodePQ);
                last.setLeft(false);
            } else {
                last.setLeftChild(newNodePQ);
                last.setLeft(true);
            }
            newNodePQ.setParent(last);
            last = newNodePQ;
            NodePQ node = last;

            while (node.getPriority() > node.getParent().getPriority()) {
                int q = node.getPriority();
                node.setPriority(node.getParent().getPriority());
                node.getParent().setPriority(q);
                if (node.getParent() == root) {
                    break;
                } else {
                    node = node.getParent();
                }
            }
        }
    }

//    @Override
//    public void remove(Iterator iterator) {
//        if (iterator.getCurrent().getRightChild() == null && iterator.getCurrent().getRightChild() == null) {
//            if (iterator.getCurrent().areLeft()) {
//                iterator.getCurrent().getParent().setLeftChild(null);
//            } else {
//                iterator.getCurrent().getParent().setRightChild(null);
//            }
//        } else if (iterator.getCurrent().getRightChild() == null) {
//            iterator.getCurrent().getParent().setLeftChild(iterator.getCurrent().getLeftChild());
//        } else if (iterator.getCurrent().getRightChild() == null) {
//            iterator.getCurrent().getParent().setRightChild(iterator.getCurrent().getRightChild());
//        } else if (iterator.getCurrent().getRightChild() != null && iterator.getCurrent().getRightChild() != null) {
//            iterator.
//        }
//    }

    @Override
    public int getMax() {
        return root.getPriority();
    }

    @Override
    public int extractMax() {
        int max = root.getPriority();
        if (last != root) {
            root.setPriority(last.getPriority());
            if (last.areLeft()) {
                last.getParent().setLeftChild(null);
            } else {
                last.getParent().setRightChild(null);
            }
            last = last.getParent();
        } else {
            root = null;
            last = null;
            return max;
        }
        NodePQ node = root;

        while (node.getPriority() < node.getMinFromChildren()) {
            int a = node.getPriority();
            int max1 = node.getMaxFromChildren();
            node.setPriority(max1);
            if (node.getLeftChild() == null) {
                node.getRightChild().setPriority(a);
                node = node.getRightChild();
            } else if (node.getRightChild() == null) {
                node.getLeftChild().setPriority(a);
                node = node.getLeftChild();
            } else if (node.getLeftChild().getPriority() == max1) {
                node.getLeftChild().setPriority(a);
                node = node.getLeftChild();
            } else {
                node.getRightChild().setPriority(a);
                node = node.getRightChild();
            }
        }
        return max;
    }

    @Override
    public void changePriority(Iterator iterator, int newPriority) {
        iterator.getCurrent().setPriority(newPriority);
    }

    public Iterator getIterator() {
        return new Iterator(this);
    }

    public NodePQ getRoot() {
        return root;
    }

    public NodePQ getLast() {
        return last;
    }
}

class ElementOfQueue {
    private int priority;
    //private int data;

    ElementOfQueue(int priority) {
        this.priority = priority;
        //this.data = data;
    }

    public int getPriority() {
        return this.priority;
    }

//    public int getData() {
//        return this.data;
//    }

    public boolean changePriority(int newPriority) {
        this.priority = newPriority;
        if (this.priority == newPriority) {
            return true;
        } else {
            return false;
        }
    }
}
class NodePQ {
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

interface InIterator {

    void reset();

    NodePQ getCurrent();

    void deleteCurrent();
}

interface InTreePQ {

    /**
     * Add a new element with priority @param p
     * @param p priority of new element in heap
     */
    void insert(int p);

    /**
     * Delete element
     *
     * @param iterator iterator of removing element
     * @return true if operation was successfully complete
     */
    default void remove(Iterator iterator) {
        System.out.println("Method remove is not realize");
    }

    /**
     * @return element with minimal priority
     */
    int getMax();

    /**
     * Extract element with minimal priority
     * @return element with minimal priority
     */
    int extractMax();

    /**
     * Change priority of element with iterator
     * @param iterator
     * @param newPriority
     * @return true if operation was successfully complete
     */
    void changePriority(Iterator iterator, int newPriority);
}

class Iterator implements InIterator {
    private NodePQ current;
    private NodePQ previous;
    private NodePQ last;
    private TreePQ treePQ;

    Iterator(TreePQ treePQ) {
        this.treePQ = treePQ;
        reset();
    }

    public void nextLeft() throws TreePQException {
        previous = current;
        if (current.getLeftChild() == null) {
            throw new TreePQException("The next node is null");
        } else {
            current = current.getLeftChild();
        }
    }

    public void nextRight() throws TreePQException {
        previous = current;
        if (current.getRightChild() == null) {
            throw new TreePQException("The next node is null");
        } else {
            current = current.getRightChild();
        }
    }

    @Override
    public NodePQ getCurrent() {
        return current;
    }

    public boolean atEndLeft() {
        if (current.getLeftChild() == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean atEndRight() {
        if (current.getRightChild() == null) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void deleteCurrent() {

    }

    @Override
    public void reset() {
        previous = null;
        current = this.treePQ.getRoot();
        last = this.treePQ.getLast();
    }

    public boolean atEndBoth() {
        return (current.getLeftChild() == null && current.getLeftChild() == null);
    }

    public boolean atEndOfLeft() {
        return (current.getLeftChild() == null);
    }

    public boolean atEndOfRight() {
        return (current.getRightChild() == null);
    }
}

class TreePQException extends Exception {
    public TreePQException(String message) {
        super(message);
    }
}






