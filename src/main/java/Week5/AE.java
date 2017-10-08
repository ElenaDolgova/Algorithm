package Week5;

import java.util.Scanner;

import static java.lang.Math.*;

public class AE {
    public static String str;

    public static void main(String[] args) {
        new AE().run();
    }

    void run() {
        Scanner s = new Scanner(System.in);
        str = s.next();
        System.out.println(paran());
    }

    long paran() {
        int n = str.length() / 2 + 1;
        long[][] m = new long[n][n];
        long[][] M = new long[n][n];
        for (int i = 0; i < n; i++) {
            m[i][i] = (int) str.charAt(2 * i)-'0';
            M[i][i] = (int) str.charAt(2 * i)-'0';
        }
        for (int s = 1; s <= n - 1; s++) {
            for (int i = 0; i <= n - s - 1; i++) {
                int j = i + s;
                long[] array = minAndMax(i, j, m, M);
                m[i][j] = array[0];
                M[i][j] = array[1];
            }
        }
        return M[0][n-1];
    }

    long[] minAndMax(int i, int j, long[][] m, long[][] M) {
        long[] array = new long[2];
        array[0] = Integer.MAX_VALUE;
        array[1] = Integer.MIN_VALUE;
        for (int k = i; k < j; k++) {
            long a = op(M[i][k], M[k + 1][j], str.charAt(2 * k + 1));
            long b = op(M[i][k], m[k + 1][j], str.charAt(2 * k + 1));
            long c = op(m[i][k], M[k + 1][j], str.charAt(2 * k + 1));
            long d = op(m[i][k], m[k + 1][j], str.charAt(2 * k + 1));
            array[0] = min(min(min(min(array[0], a), b), c), d);
            array[1] = max(max(max(max(array[1], a), b), c), d);
        }
        return array;
    }

    long op(long a, long b, char c) {
        switch (c) {
            case '*':
                return a*b;
            case '-':
                return a-b;
            case '+':
                return a+b;
            default:
                assert false;
                return 0;
        }
    }
}
