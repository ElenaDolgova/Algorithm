package Week3;

import java.util.*;
// It is example and bad try
public class MaxSalary1 {
//    public static void main(String[] args) {
//        new MaxSalary1().run();
//    }

    int n;
    ArrayList<String> list = new ArrayList<String>();

    MaxSalary1(int n, ArrayList<String> list) {
        this.n = n;
        this.list = list;
    }

    String run() {
        String out = "";
        //canner sc = new Scanner(System.in);
        List<String> list = this.list; // new ArrayList<String>();
        int n = this.n; // sc.nextInt();
        //int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            list.add(sc.next());
//        }
        Collections.sort(list);
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i).length() < list.get(i + 1).length()) {
                String a1 = "";
                int k = 0;
                for (int j = 0; j < list.get(i).length(); j++) {
                    if (list.get(i).charAt(j) == list.get(i + 1).charAt(j)) {
                        k += 1;
                    }
                    if (k == list.get(i).length()) {
                        a1 = list.get(i + 1).substring(i + 2);
                        //System.out.println(i + 1);
                        //System.out.println(a1);
                        if (a1.compareTo(list.get(i)) == -1) {
                            Collections.swap(list, i, i + 1);
                            break;
                        }
                    }

                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            out += list.get(i);
            //System.out.printf(list.get(i));
        }
        //System.out.println(out);
        return out;
    }
}