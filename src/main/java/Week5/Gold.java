package Week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Gold {
    public static void main(String[] args) {
        new Gold().run();
    }

    void run() {
        Scanner s = new Scanner(System.in);
        int W = s.nextInt();
        int n = s.nextInt();
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            array.add(s.nextInt());
        }
        Collections.sort(array);

        int[][] D = new int[W+1][n+1];

        for (int w = 1; w <= W; w++) {
            for (int i = 1; i <= n; i++){
                D[w][i]=D[w][i-1];
                if (array.get(i-1)<=w) {
                    D[w][i]=Math.max(D[w][i-1],D[w-array.get(i-1)][i-1]+array.get(i-1));
                }
            }
        }
        System.out.println(D[W][n]);

    }
}
