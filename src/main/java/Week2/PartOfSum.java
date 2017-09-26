package Week2;
//Находим последнее число в сумме чисел Фибоначи, начиная с m до n, где m<=n

import java.util.Scanner;

class PartOfSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long m = s.nextLong();
        long n = s.nextLong();
        int r1 = sumMod((m + 1) % 60, 10)-1;

        int r = sumMod((n + 2) % 60, 10)-1;

        System.out.println((r-r1+10)%10);

    }

    public static int sumMod(long n, int m) {
        long i = 0;
        //System.out.println(n);
        int pos[] = new int[6 * m]; // длина периода ряда фибоначи не превышает 6*m
        pos[0] = 0;
        pos[1] = 1;
        for (i = 2; i < 6 * m; i++) {
            pos[(int) i] = (pos[(int) i - 1] + pos[(int) i - 2]) % m; //пишем остатки от деления нод на m
            if ((i != 2) && (pos[(int) i - 1] == 0) && (pos[(int) i] == 1)) { // ряд Фибоначи начинается с 0,1...
                break;
            }
        }
        i = i - 1;
        i = n % i; // не имеет смысла смотреть на число для большого индекса. Достаточно для остатка, а имеено для i=n-gcd*p (p - период)
        if (pos[(int) i] == 0) {
            return 10;
        } else {
            return pos[(int) i];
        }
    }
}