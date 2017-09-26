package Week2;

import java.math.BigInteger;
import java.util.Scanner;

public class Lcm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a=s.nextInt();
        int b=s.nextInt();
        BigInteger c= BigInteger.valueOf(a).multiply(BigInteger.valueOf(b));
        System.out.println(c.divide(BigInteger.valueOf(euc(a,b))));
    }

    public static int euc(int a, int b){
        if(b==0){
            return a;
        }else {
            return euc(b,a%b);
        }
    }
}
