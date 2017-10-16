package Week4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        new MajorityElement().run();
    }

    void run() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int l = n;
        while (l > 0) {
            int i = s.nextInt();
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
            l--;
        }
        int max = -1;
        for (Map.Entry<Integer, Integer> k : map.entrySet()) {
            if (max < k.getValue()) {
                max = k.getValue();
            }
        }
        if (n / 2 < max) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
