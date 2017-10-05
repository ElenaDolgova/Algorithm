package Week5;

import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        new Calculator().run();
    }

    public static Map<Integer, Integer> map;
    public static int[] values;

    void run() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        map = new HashMap<>();
        map.put(0, 0);

        //array = new int[n + 1];//new int[n + 1];

//        for (int i = 0; i < n + 1; i++) {
//            array[i] = -1;
//        }
//        array[0] = 0;
//        array[1] = 0;
//        for (int i = 0; i < n; i++) {
//            change(i);
//        }
        change(n);

//            while (n > 1) {
//                if (n > 3 && (n - 1) % 3 == 0) {
//                    arrayList.add(n - 1);
//                    arrayList.add(n / 3);
//                    n = (n - 1) / 3;
//                } else if (n % 3 == 0) {
//                    n /= 3;
//                    arrayList.add(n);
//                } else if (n > 2 && (n - 1) % 2 == 0) {
//                    arrayList.add(n - 1);
//                    arrayList.add(n / 2);
//                    n = (n - 1) / 2;
//                } else if (n % 2 == 0) {
//                    n /= 2;
//                    arrayList.add(n);
//                } else {
//                    n -= 1;
//                    arrayList.add(n);
//                }
//            }
//        System.out.println(arrayList.size() - 1);
//        for (int i = arrayList.size() - 1; i >= 0; i--) {
//            System.out.print(arrayList.get(i) + " ");
//        }
    }

    void change(int number) {
        ArrayList<Integer> arrayList = new ArrayList();

        int i = 1, num3, num2, num1;

        while (i <= number) {
            num3 = i % 3 == 0 ? map.get(i / 3) : number;
            num2 = i % 2 == 0 ? map.get(i / 2) : number;
            num1 = map.get(i - 1);
            int min;

            if (num3 <= num2 && num3 <= num1) {
                min = i / 3;
            } else if (num2 <= num3 && num2 <= num1) {
                min = i / 2;
            } else {
                min = i - 1;
            }
            map.put(i, map.get(min) + 1);
            i++;
        }

        while (number > 0) {
            num3 = number % 3 == 0 ? map.get(number / 3) : number;
            num2 = number % 2 == 0 ? map.get(number / 2) : number;
            num1 = map.get(number - 1);
            int min;

            if (num3 <= num2 && num3 <= num1) {
                min = number / 3;
            } else if (num2 <= num3 && num2 <= num1) {
                min = number / 2;
            } else {
                min = number - 1;
            }
            arrayList.add(number);
            number = min;
        }

        System.out.println(arrayList.size() - 1);

        for (int k = arrayList.size() - 1; k >= 0; k--) {
            System.out.print(arrayList.get(k)+" ");
        }


//        if (array[number] != -1) {
//            return array[number];
//        } else {
//            if (number % 3 == 0) {
//                arrayList.add(1 + change(number / 3));
//            }
//            if (number % 2 == 0) {
//                arrayList.add(1 + change(number / 2));
//            }
//            arrayList.add(1 + change(number - 1));
//            array[number] = Collections.min(arrayList);
//            return Collections.min(arrayList);
//        }
//    }
    }
}
