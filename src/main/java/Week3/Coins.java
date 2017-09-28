package Week3;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(change(n));
    }

    public static int change(int n) {
        int n1 = 10, n2 = 5, n3 = 1;
        int[] array = new int[3];
        while (n > 0) {
            if (n - n1 >= 0) {
                array[0] += 1;
                n -= n1;
            } else if (n - n2 >= 0) {
                array[1] += 1;
                n -= n2;
            } else {
                array[2] = n;
                n=0;
            }
        }
        int sum =0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        return sum;
    }
}
