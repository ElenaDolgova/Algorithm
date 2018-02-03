package TimusOnline;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class Sqrt_1001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        double i = 0;
        Stack<Double> stack = new Stack<Double>();

        while (in.hasNextDouble()) {
            i = in.nextDouble();
            stack.add(Math.sqrt(i));
            System.out.println(Math.sqrt(i));
            //out.println(Math.sqrt(i));
        }

        out.flush();
    }
}
