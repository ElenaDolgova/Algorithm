package Week3;

import java.util.Scanner;

public class Loot {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int W = s.nextInt();
        double[][] array = sort(n, set(n, s));
        //out(n,array);
        find(n, W, array);

    }

    public static void find(int n, int W, double[][] array) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            if (array[1][i] <= W) {
                sum += array[2][i] * array[1][i];
                W -= array[1][i];
            } else if (W > 0) {
                sum += W * array[2][i];
                W = 0;
            }
        }
        System.out.println(sum);
    }

    public static double[][] sort(int n, double[][] array) { //сортировка двумерного массива по убыванию
        double l;
        for (int k = n - 1; k > 0; k--) {
            for (int j = 0; j < k; j++) {
                if (array[2][j] < array[2][j + 1]) {
                    l = array[0][j];
                    array[0][j] = array[0][j + 1];
                    array[0][j + 1] = l;

                    l = array[1][j];
                    array[1][j] = array[1][j + 1];
                    array[1][j + 1] = l;

                    l = array[2][j];
                    array[2][j] = array[2][j + 1];
                    array[2][j + 1] = l;
                }
            }
        }
        return array;
    }

    public static void out(int n, double[][] array) {
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print(array[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] set(int n, Scanner s) {
        int i = 0;
        double[][] array = new double[3][n];
        while (i < n) {
            array[0][i] = s.nextInt();
            array[1][i] = s.nextInt();
            array[2][i] = array[0][i] / array[1][i];
            //array[2][i] = new BigDecimal(array[0][i] / array[1][i]).setScale(5, RoundingMode.UP).doubleValue();
            i++;
        }
        return array;
    }
}
