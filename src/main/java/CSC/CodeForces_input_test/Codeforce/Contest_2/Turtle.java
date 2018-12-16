//package CSC.CodeForces_input_test.Codeforce.Contest_2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tartel {
    public static void main(String[] args) throws IOException {
        BufferedInputStream in = new BufferedInputStream(System.in);
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        String[] input = r.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] D = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = r.readLine().split(" ");
            for (int k = 0; k < m; k++) {
                D[i][k] = Integer.parseInt(input[k]);
            }
        }

//        out(n, m, D);

        int[][] answer = new int[n][m];
        answer[0][0] = D[0][0];
        for (int i = 1; i < m; i++) {
            answer[0][i] = answer[0][i - 1] + D[0][i];
        }
//        out(n, m, answer);
        for (int i = 1; i < n; i++) {
            answer[i][0] = answer[i - 1][0] + D[i][0];
        }
//        out(n, m, answer);
        for (int i = 1; i < n; i++) {
            for (int k = 1; k < m; k++) {
                answer[i][k] = D[i][k] + Math.min(answer[i][k - 1], answer[i - 1][k]);
            }
        }
//        out(n, m, answer);
        System.out.println(answer[n - 1][m - 1]);
    }

    static void out(int n, int m, int[][] D) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                System.out.print(D[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
