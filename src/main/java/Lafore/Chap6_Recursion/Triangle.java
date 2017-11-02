package Lafore.Chap6_Recursion;

public class Triangle {

    public long triangle(long n) {
        long total = 0;
        while (n > 0) {
            total += n;
            n--;
        }
        return total;
    }

    public long triangleRec(long n) {
        if (n == 1) {
            return 1;
        } else {
            return triangleRec(n - 1) + n;
        }
    }
}
