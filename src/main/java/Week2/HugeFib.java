package Week2;
//Находим остаток от деления Fn mod m

import java.util.Scanner;

class HugeFib {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        int m = s.nextInt();
        long i = 0;
        int pos[] = new int[6 * m ]; // длина периода ряда фибоначи не превышает 6*m
        pos[0] = 0 % m;
        pos[1] = 1 % m;
        for (i = 2; i < 6 * m; i++) {
            pos[(int) i] = (pos[(int) i - 1] + pos[(int) i - 2]) % m; //пишем остатки от деления нод на m
            if ((i != 2) && (pos[(int) i - 1] == 0) && (pos[(int) i] == 1)) { // ряд Фибоначи начинается с 0,1...
                break;
            }
        }
        i = i - 1;
        i = (n) % (i); // не имеет смысла смотреть на число для большого индекса. Достаточно для остатка, а имеено для i=n-gcd*p (p - период)
        System.out.println(pos[(int) i]);
    }
}