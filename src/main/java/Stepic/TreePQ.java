//package Stepic;
//
//public class TreePQ implements InTreePQ {
//    private NodePQ root;
//    private NodePQ last;
//
//    @Override
//    public void insert(int p) {
//        NodePQ newNodePQ = new NodePQ(p);
//
//        if (root == null) {
//            root = newNodePQ;
//            last = newNodePQ;
//            root.setLeft(false);
//        } else {
//            if (newNodePQ.getPriority() % 2 == 0) {
//                last.setRightChild(newNodePQ);
//                last.setLeft(false);
//            } else {
//                last.setLeftChild(newNodePQ);
//                last.setLeft(true);
//            }
//            newNodePQ.setParent(last);
//            last = newNodePQ;
//            NodePQ node = last;
//
//            while (node.getPriority() > node.getParent().getPriority()) {
//                int q = node.getPriority();
//                node.setPriority(node.getParent().getPriority());
//                node.getParent().setPriority(q);
//                if (node.getParent() == root) {
//                    break;
//                } else {
//                    node = node.getParent();
//                }
//            }
//        }
//    }
//
////    @Override
////    public void remove(Iterator iterator) {
////        if (iterator.getCurrent().getRightChild() == null && iterator.getCurrent().getRightChild() == null) {
////            if (iterator.getCurrent().areLeft()) {
////                iterator.getCurrent().getParent().setLeftChild(null);
////            } else {
////                iterator.getCurrent().getParent().setRightChild(null);
////            }
////        } else if (iterator.getCurrent().getRightChild() == null) {
////            iterator.getCurrent().getParent().setLeftChild(iterator.getCurrent().getLeftChild());
////        } else if (iterator.getCurrent().getRightChild() == null) {
////            iterator.getCurrent().getParent().setRightChild(iterator.getCurrent().getRightChild());
////        } else if (iterator.getCurrent().getRightChild() != null && iterator.getCurrent().getRightChild() != null) {
////            iterator.
////        }
////    }
//
//    @Override
//    public int getMax() {
//        return root.getPriority();
//    }
//
//    @Override
//    public int extractMax() {
//        int max = root.getPriority();
//        if (last != root) {
//            root.setPriority(last.getPriority());
//            if (last.areLeft()) {
//                last.getParent().setLeftChild(null);
//            } else {
//                last.getParent().setRightChild(null);
//            }
//            last = last.getParent();
//        } else {
//            root = null;
//            last = null;
//            return max;
//        }
//        NodePQ node = root;
//
//        while (node.getPriority() < node.getMinFromChildren()) {
//            int a = node.getPriority();
//            int max1 = node.getMaxFromChildren();
//            node.setPriority(max1);
//            if (node.getLeftChild() == null) {
//                node.getRightChild().setPriority(a);
//                node = node.getRightChild();
//            } else if (node.getRightChild() == null) {
//                node.getLeftChild().setPriority(a);
//                node = node.getLeftChild();
//            } else if (node.getLeftChild().getPriority() == max1) {
//                node.getLeftChild().setPriority(a);
//                node = node.getLeftChild();
//            } else {
//                node.getRightChild().setPriority(a);
//                node = node.getRightChild();
//            }
//        }
//        return max;
//    }
//
//    @Override
//    public void changePriority(Iterator iterator, int newPriority) {
//        iterator.getCurrent().setPriority(newPriority);
//    }
//
//    public Iterator getIterator() {
//        return new Iterator(this);
//    }
//
//    public NodePQ getRoot() {
//        return root;
//    }
//
//    public NodePQ getLast() {
//        return last;
//    }
//}
