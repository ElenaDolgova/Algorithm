package Week3;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        int k=1;
        int r=0;
        while(n>0){
            if(n-k<=k){
                break;
            }
            n=n-k;
            k=k+1;
        }
        System.out.println(k);
        for(int i=1;i<k;i++){
            System.out.print(i+" ");
        }
        System.out.print(n);

    }
}
