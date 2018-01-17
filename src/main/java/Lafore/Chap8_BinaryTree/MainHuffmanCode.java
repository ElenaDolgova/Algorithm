package Lafore.Chap8_BinaryTree;

import java.util.*;

import java.util.HashMap;
import java.util.Map;

public class MainHuffmanCode {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder str = new StringBuilder(s.nextLine());
        Map<Character, Integer> map = new HashMap<>();
        ArrayList<Character> arrayList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.replace(str.charAt(i), map.get(str.charAt(i)), map.get(str.charAt(i)) + 1);
            } else {
                arrayList.add(str.charAt(i));
                map.put(str.charAt(i), 1);
            }
        }

        if(map.size()==1){
            System.out.println( "1 "+map.get(str.charAt(0)));
            System.out.println(str.charAt(0)+": 0");
            int i =0;
            while(i<map.get(str.charAt(0))){
                System.out.print("0");
                i++;
            }
            return;
        }

        Queue<BTHuffmanCode> pq = new PriorityQueue<>(map.size(), idComparator);
        for (int i = 0; i < map.size(); i++) {
            BTHuffmanCode bt = new BTHuffmanCode();
            bt.insert(arrayList.get(i), map.get(arrayList.get(i)));
            pq.add(bt);
        }

        while (pq.size() > 1) {
            BTHuffmanCode bt1 = pq.poll();
            BTHuffmanCode bt2 = pq.poll();

            BTHuffmanCode bt = new BTHuffmanCode();
            bt.insert(bt1.getFrecuency() + bt2.getFrecuency());

            bt.insert(bt1);
            bt.insert(bt2);
            pq.add(bt);
        }

        BTHuffmanCode bt = pq.poll();
        String string = "";

        bt.roundAll();

        for (int i = 0; i < str.length(); i++) {
            string = string + bt.getMap().get(str.charAt(i));
        }
        System.out.print(arrayList.size() + " " + string.length());
        System.out.println();

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i) + ": " + bt.getMap().get(arrayList.get(i)));
        }
        System.out.print(string);
    }

    public static Comparator<BTHuffmanCode> idComparator = Comparator.comparingInt(BTHuffmanCode::getFrecuency);
}




