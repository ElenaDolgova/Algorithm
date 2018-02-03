//package Stepic;
//
//public class Iterator implements InIterator {
//    private NodePQ current;
//    private NodePQ previous;
//    private NodePQ last;
//    private TreePQ treePQ;
//
//    Iterator(TreePQ treePQ) {
//        this.treePQ = treePQ;
//        reset();
//    }
//
//    public void nextLeft() throws TreePQException {
//        previous = current;
//        if (current.getLeftChild() == null) {
//            throw new TreePQException("The next node is null");
//        } else {
//            current = current.getLeftChild();
//        }
//    }
//
//    public void nextRight() throws TreePQException {
//        previous = current;
//        if (current.getRightChild() == null) {
//            throw new TreePQException("The next node is null");
//        } else {
//            current = current.getRightChild();
//        }
//    }
//
//    @Override
//    public NodePQ getCurrent() {
//        return current;
//    }
//
//    public boolean atEndLeft() {
//        if (current.getLeftChild() == null) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean atEndRight() {
//        if (current.getRightChild() == null) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//
//    @Override
//    public void deleteCurrent() {
//
//    }
//
//    @Override
//    public void reset() {
//        previous = null;
//        current = this.treePQ.getRoot();
//        last = this.treePQ.getLast();
//    }
//
//    public boolean atEndBoth() {
//        return (current.getLeftChild() == null && current.getLeftChild() == null);
//    }
//
//    public boolean atEndOfLeft() {
//        return (current.getLeftChild() == null);
//    }
//
//    public boolean atEndOfRight() {
//        return (current.getRightChild() == null);
//    }
//}
