package Lafore.Chap6_Recursion;

import static java.lang.Math.pow;

/**
 * This class describes the problem of towers of Hanoi
 */
public class Towers {
    private int numberOfDisk;

    public Towers(int numberOfDisk) {
        this.numberOfDisk = numberOfDisk;
    }

    public int getNumberShifting() {
        return (int) (pow(2, numberOfDisk) - 1);
    }

    public void doT() {
        doTowers(numberOfDisk, 'A', 'B', 'C');
    }

    private void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, inter); // from -> inter
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to); //inter -> to
        }
    }
}
