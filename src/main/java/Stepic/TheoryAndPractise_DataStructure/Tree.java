package Stepic.TheoryAndPractise_DataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Tree {
    ArrayList<Integer> arrayList;

    public Tree(int size, Scanner s) {
        arrayList = new ArrayList<>(size);
        int i = 0;
        while (i < size) {
            arrayList.add(s.nextInt());
            //System.out.println(arrayList.get(i));
            i++;
        }
    }

    private int getValueOfRoot() {
        for (int i : arrayList) {
            if (i == -1) {
                return arrayList.indexOf(i);
            }
        }
        return 0;
    }

    private ArrayList<Integer> getValueOfChild(int i) {
        ArrayList<Integer> childArray = new ArrayList<>();
        for (int k = 0; k < arrayList.size(); k++) {
            if (arrayList.get(k) == i) {
                childArray.add(k);
            }
        }
        return childArray;
    }

    public int highOfTreeWithRecursion(int indChild) {
        int height = 0;
        //int root = getValueOfRoot();
        ArrayList<Integer> childArray = getValueOfChild(indChild);
        for (int child : childArray) {
            height = Math.max(height, 1 + highOfTreeWithRecursion(child));
        }
        return height;
    }

}
