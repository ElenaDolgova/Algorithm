package Lafore.Chap6_Recursion;

public class Pow {

    int count = 0;

    public int power(int x, int y) {
        if (y == 0) {
            count++;
            return 1;
        } else if (y % 2 == 0) {
            count++;
            return power(x * x, y / 2);
        } else {
            count++;
            return power(x, y - 1) * x;
        }
    }

    /**
     * @param x
     * @param y
     * @return
     */
    public int powSimple(int x, int y) {
        if (y == 1) {
            count++;
            return x;
        }
        count++;
        return x * powSimple(x, y - 1);
    }
}
