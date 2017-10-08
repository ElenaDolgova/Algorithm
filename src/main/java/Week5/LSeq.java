package Week5;

import java.util.Scanner;

import static java.lang.Math.*;

public class LSeq {

    int[] set(Scanner s) {
        int[] array = new int[s.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = s.nextInt();
        }
        return array;
    }

    void run() {
        Scanner s = new Scanner(System.in);
        int[] seq1 = set(s);
        int[] seq2 = set(s);
        int[] seq3 = set(s);

        int[][][] D = new int[seq1.length + 1][seq2.length + 1][seq3.length + 1];

        for (int i = 0; i <= seq1.length; i++) {
            for (int j = 0; j <= seq2.length; j++) {
                for (int k = 0; k <= seq3.length; k++) {

                    if (i == 0 || j == 0 || k == 0) {
                        D[i][j][k] = 0;
                        continue;
                    }

                    //int c = seq1[i - 1] == seq2[j - 1] && seq2[j - 1] == seq3[k - 1] ? 0 : 1;

                    if (seq1[i - 1] == seq2[j - 1] && seq2[j - 1] == seq3[k - 1]) {
                        D[i][j][k] = D[i - 1][j - 1][k - 1] + 1;
                        continue;
                    }
                    D[i][j][k] = max(max(D[i - 1][j][k], D[i][j - 1][k]), D[i][j][k - 1]);
                }
            }
        }

        System.out.println(D[seq1.length][seq2.length][seq3.length]);

    }

    public static void main(String[] args) {
        new LSeq().run();
    }
}