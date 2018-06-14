package Stepic.TheoryAndPractise_DataStructure.Lesson_3;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Telephon {

    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(System.in);
        BufferedReader r = new BufferedReader(
                new InputStreamReader(bis, StandardCharsets.UTF_8));

        int n = Integer.parseInt(r.readLine().replaceAll(" ", ""));

        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = r.readLine();
            String[] strings = str.split(" ");
            if (str.contains("add")) {
                hashMap.put(Integer.parseInt(strings[1]), strings[2]);
            } else if (str.contains("find")) {
                if (hashMap.containsKey(Integer.parseInt(strings[1]))) {
                    System.out.println(hashMap.get(Integer.parseInt(strings[1])));
                } else {
                    System.out.println("not found");
                }

            } else {
                hashMap.remove(Integer.parseInt(strings[1]));
            }
        }
    }
}
