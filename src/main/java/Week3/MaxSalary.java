package Week3;

import java.util.Scanner;

public class MaxSalary {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        //out(sortWith(setWith(n,s)));
        setWith(n, s);
    }

    public static int[][] change(int n, int i, int[][] array) {
        int l;
        l = array[0][i + 1];
        array[0][i + 1] = array[0][i];
        array[0][i] = l;

        l = array[1][i + 1];
        array[1][i + 1] = array[1][i];
        array[1][i] = l;

        l = array[2][i + 1];
        array[2][i + 1] = array[2][i];
        array[2][i] = l;

        l = array[3][i + 1];
        array[3][i + 1] = array[3][i];
        array[3][i] = l;
        return array;
    }


    public static void sortWith(int n, int[][] array) {

        for (int k = n - 1; k > 0; k--) {// Отсортировали по старшему разряду
            for (int j = 0; j < k; j++) {
                if (array[0][j] < array[0][j + 1]) {
                    array = change(n, j, array);
                }
            }
        }
        // Хотим проверить на равенство старших разрядов
        //out(n, array);
        for (int t = 0; t < 3; t++) {
            for (int k = n - 1; k > 0; k--) {
                for (int j = 0; j < k; j++) {
                    if (array[t][j] == array[t][j + 1] && array[t + 1][j] < array[t + 1][j + 1] &&
                            (array[t + 1][j] != -1)
                            ) {
                        array = change(n, j, array);
                    } else if (array[t][j] == array[t][j + 1] && array[t + 1][j + 1] == -1 && array[t + 1][j] != -1 && array[t + 1][j] < array[t][j] ) {
                        array = change(n, j, array);
                    } else if (array[t][j] == array[t][j + 1] && array[t + 1][j] == -1 && array[t + 1][j + 1] > array[t][j + 1]) {
                        array = change(n, j, array);
                        System.out.println("jf");
                    }
                }
            }
        }
        out(n, array);
        //System.out.println();
    }

    public static void out(int n, int[][] array) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[j][i] != -1) {
                    System.out.print(array[j][i]);
                }
            }
        }
//        System.out.println();
//        for (int j = 0; j < 4; j++) {
//            for (int i = 0; i < n; i++) {
//                System.out.print(array[j][i] + " ");
//            }
//            System.out.println();
//        }
    }

    public static void setWith(int n, Scanner s) {
        int[][] array = new int[4][n];
        int a, j;
        for (int i = 0; i < n; i++) {
            for (int l = 0; l < 4; l++) {
                array[l][i] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            a = s.nextInt();
            if (a - 1000 >= 0) {
                j = 3;
            } else if (a - 100 >= 0) {
                j = 2;
            } else if (a - 10 >= 0) {
                j = 1;
            } else {
                j = 0;
            }
            for (; j >= 0; j--) {
                array[j][i] = a % 10;
                a = a / 10;
            }
        }
        //out(n, array);
        sortWith(n, array);
    }
}
