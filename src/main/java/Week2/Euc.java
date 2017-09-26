package Week2;

import java.util.Scanner;

public class Euc {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a=s.nextInt();
        int b=s.nextInt();
        System.out.println(euc(a,b));
    }

    public static int euc(int a, int b){
        if(b==0){
            return a;
        }else {
            return euc(b,a%b);
        }
    }
}
