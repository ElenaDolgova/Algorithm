package Week3;

import java.util.*;

public class AdequateMethod {
    public static void main(String[] args) {
        new AdequateMethod().method();
    }

    public AdequateMethod method() {
        List<String> list = new ArrayList<String>();

        Scanner s = new Scanner(System.in);
        long n = s.nextLong();

        for (int i = 0; i < n; i++) {
            list.add(s.next());
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.charAt(0) == o2.charAt(0)) {
                return -Integer.parseInt(o1 + o2) + Integer.parseInt(o2 + o1);
            }
            return -o1.compareTo(o2);
        });

        for (String str : list) {
            System.out.print(str);
        }
        return null;
    }

}
