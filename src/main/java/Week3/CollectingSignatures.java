package Week3;

import java.util.Scanner;

public class CollectingSignatures {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        out(n, findMin(n, set(n, s)));
    }

    public static void out(int n, int[][] array) {
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (array[0][i] != -1) {
                k++;
            }
        }
        System.out.println(k);
        for (int i = 0; i < n; i++)
            if (array[0][i] != -1 && i != n - 1) {
                System.out.print(array[0][i] + " ");
            } else if (array[0][i] != -1 && i == n - 1) {
                System.out.print(array[0][i]);
            }
    }

    public static int[][] findMin(int n, int[][] array) {
        for (int j = 0; j < n - 1; j++) {
            if ((array[0][j] == array[0][j + 1]) & (array[2][j] < array[2][j + 1])) {// Если левые концы совпадают
                array[0][j + 1] = -1;// и отрезок выше меньше отрезка ниже, то больший отрезок убирается
            }
            if ((array[0][j] == array[0][j + 1]) & (array[2][j] > array[2][j + 1])) {// Если отрезок выше больше
                array[0][j] = -1;// отрезка ниже и их левые концы совпадают, то больший отрезок убирается
            }
        }

//        System.out.println();
//        for (int j = 0; j < 3; j++) {
//            for (int i = 0; i < n; i++) {
//                System.out.print(array[j][i] + " ");
//            }
//            System.out.println();
//        }
        for (int i = n - 1; i >= 1; i--) {
            if ((array[0][i] <= array[1][i - 1]) & (array[1][i] <= array[1][i - 1]) & (array[0][i] != -1)) {// Если отрезок выше(рисуем один под другим)
                array[0][i - 1] = array[0][i];//поглощает отрезок, лежащий ниже, то больший отрезок заменяем меньшим
                array[1][i - 1] = array[1][i];
                array[0][i] = -1;
            }
            if ((array[0][i] <= array[1][i - 1]) & (array[0][i] != -1)) {// Если у отрезка ниже левый конец меньше или равен
                array[0][i - 1] = array[0][i];// правому концу отрезка, лежащему выше, то отрезку выше присваивается
                array[0][i] = -1;// его левому концу левый конец отрезка ниже
            }
        }
//        System.out.println();
//        for (int j = 0; j < 3; j++) {
//            for (int i = 0; i < n; i++) {
//                System.out.print(array[j][i] + " ");
//            }
//            System.out.println();
//        }
        return array;
    }

    public static int[][] set(int n, Scanner s) {
        int[][] array = new int[3][n];
        for (int i = 0; i < n; i++) {
            array[0][i] = s.nextInt();
            array[1][i] = s.nextInt();
            array[2][i] = array[1][i] - array[0][i];
        }
        int l;
        for (int k = n - 1; k > 0; k--) {// сортировка по убыванию
            for (int j = 0; j < k; j++) {
                if (array[0][j] > array[0][j + 1]) {
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
//        for (int j = 0; j < 3; j++) {
//            for (int i = 0; i < n; i++) {
//                System.out.print(array[j][i] + " ");
//            }
//            System.out.println();
//        }

        return array;
    }
}
