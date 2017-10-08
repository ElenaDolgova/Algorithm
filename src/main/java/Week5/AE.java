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

    int paran() {
        int n = str.length() / 2 + 1;
        int[][] m = new int[n][n];
        int[][] M = new int[n][n];
        for (int i = 0; i < n; i++) {
            m[i][i] = str.charAt(2 * i)-'0';
            M[i][i] = str.charAt(2 * i)-'0';
        }
        for (int s = 1; s <= n - 1; s++) {
            for (int i = 0; i <= n - s - 1; i++) {
                int j = i + s;
                int[] array = minAndMax(i, j, m, M);
                m[i][j] = array[0];
                M[i][j] = array[1];
            }
        }
        return M[0][n-1];
    }

    int[] minAndMax(int i, int j, int[][] m, int[][] M) {
        int[] array = new int[2];
        array[0] = Integer.MAX_VALUE;
        array[1] = Integer.MIN_VALUE;
        for (int k = i; k < j; k++) {
            int a = op(M[i][k], M[k + 1][j], str.charAt(2 * k + 1));
            int b = op(M[i][k], m[k + 1][j], str.charAt(2 * k + 1));
            int c = op(m[i][k], M[k + 1][j], str.charAt(2 * k + 1));
            int d = op(m[i][k], m[k + 1][j], str.charAt(2 * k + 1));
            array[0] = min(min(min(min(array[0], a), b), c), d);
            array[1] = max(max(max(max(array[1], a), b), c), d);
        }
        return array;
    }

    int op(int a, int b, char c) {
        switch (c) {
            case '*':
                return ((int) a) * ((int) b);
            case '-':
                return ((int) a) - ((int) b);
            case '+':
                return ((int) a) + ((int) b);
            default:
                return Integer.parseInt(null);
        }
    }
}
