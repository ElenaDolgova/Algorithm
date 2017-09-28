package Week3;

import java.util.Arrays;
import java.util.Scanner;

public class Ads {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] profit = set(n,s);
        int[] clicks = set(n,s);

        System.out.println(max(profit,clicks,n));
    }
    public static long max(int[] a, int[] b, int n){
        Arrays.sort(a);
        Arrays.sort(b);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) a[i]*b[i];
        }
        return sum;
    }

    public static int[] set(int n, Scanner s){
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = s.nextInt();
        }
        return array;
    }
}
