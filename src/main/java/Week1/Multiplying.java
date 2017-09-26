package Week1;

import java.math.BigInteger;
import java.util.Scanner;

public class Multiplying {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num = 0;
        BigInteger b= BigInteger.valueOf(0);
        String a = "";
        num = s.nextInt();

        for (int i = 0; i < 2; i++) {
            a = s.nextLine();
        }
        String strArr[] = a.split(" ");
        BigInteger numArr[] = new BigInteger[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = BigInteger.valueOf(Integer.parseInt(strArr[i]));
            // System.out.println(numArr[i]);
        }
        BigInteger max1 = numArr[0], max2 = numArr[1];
        if (max1.compareTo(max2)==-1) {
            b = max1;
            max1 = max2;
            max2 = b;
        }
        //System.out.println(max1*max2);
        for (int i = 2; i < num; i += 1) {

            if (max2.compareTo(numArr[i])==-1) {
                max2 = numArr[i];
            }
            if (max1.compareTo(max2)==-1) {
                b = max1;
                max1 = max2;
                max2 = b;
            }
        }

        System.out.println(max1.multiply(max2));
    }
}
