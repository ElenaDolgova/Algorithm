package Stepic.TheoryAndPractise_DataStructure.Lesson_1.HighOfTree;

import java.util.*;

//import static Stepic.TheoryAndPractise_DataStructure.Lesson_1.HighOfTree.TreeBasedOnArray.Tree.getAllChildren;

public class TreeBasedOnArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        Tree tree = new Tree(size, s);
        tree.getAllChildren();

        System.out.println(tree.highOfTree(-1));
    }

    static class Tree {
        static ArrayList<Integer> arrayList;
        static Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        public Tree(int size, Scanner s) {
            arrayList = new ArrayList<>(size);
            int i = 0;
            int k;
            while (i < size) {
                k = s.nextInt();
                //arrayList.add(k);
                if (!map.containsKey(k)) {
                    map.put(k, new ArrayList<>());
                    map.get(k).add(i);
                } else {
                    map.get(k).add(i);
                }
                //map.put(k, new ArrayList<>());
                //System.out.println(arrayList.get(i));
                i++;
            }
        }

//        private int getValueOfRoot() {
//            for (int i : arrayList) {
//                if (i == -1) {
//                    return arrayList.indexOf(i);
//                }
//            }
//            return 0;
//        }

        public static void getAllChildren() {

            for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (entry.getKey() == arrayList.get(i)) {
                        entry.getValue().add(i);
                        System.out.println("Key " + entry.getKey() + " Value " + i);
                    }
                }
            }
        }

//        private ArrayList<Integer> getValueOfChild(int i) {
//            ArrayList<Integer> childArray = new ArrayList<>();
//            for (int k = 0; k < arrayList.size(); k++) {
//                if (arrayList.get(k) == i) {
//                    childArray.add(k);
//                    System.out.println("getChild " + i);
//                }
//            }
//            return childArray;
//        }


        public static int highOfTree(int indChild) {
            int height = 0;

            if (map.containsKey(indChild)) {
                ArrayList<Integer> childArray = map.get(indChild);
                for (int child : childArray) {
                    height = Math.max(height, 1 + highOfTree(child));
                }
            } else {
                return 0;
            }
            return height;
        }
    }
}
