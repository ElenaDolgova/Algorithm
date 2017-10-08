package Week5;

import java.util.Scanner;

public class Distance {
    public static void main(String[] args) {
        new Distance().run();
    }

    void run() {
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        String s2 = s.next();
        int[][] D = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            D[i][0] = i;
        }

        for (int i = 0; i <= s2.length(); i++) {
            D[0][i] = i;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int c = s1.charAt(i-1) == s2.charAt(j-1) ? 0 : 1;
                D[i][j]= Math.min(D[i-1][j]+1,D[i][j-1]+1);
                D[i][j]=Math.min(D[i][j],D[i-1][j-1]+c);
            }
        }

        System.out.println(D[s1.length()][s2.length()]);

    }
}
