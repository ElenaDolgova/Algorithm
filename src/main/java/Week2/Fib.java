package Week2;

import java.util.ArrayList;
import java.util.Scanner;

public class Fib {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        ArrayList array = new ArrayList();
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else {
            array.add(0);
            array.add(1);
            array.add(1);

            for (int i = 3; i <= n; i++) {
                array.add((int)array.get(i - 1)%10+(int)array.get(i-2)%10);
            }
            return (int) array.get(n)%10;
        }
    }
}
