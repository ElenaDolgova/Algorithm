package Lafore.Chap6_Recursion;

/**
 * Recursion is not exit.
 * 1. Save two last numbers
 * 2. Asymptotic
 */
public class Factorial {

    public long factorial(long n) {
        long temp = 1;
        while (n > 0) {
            temp *= n;
            n--;
        }
        return temp;
    }


    public long factorialRec(long n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return factorialRec(n - 1) * n;
        }
    }
}
