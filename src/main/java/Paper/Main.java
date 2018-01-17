package Paper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\Algorithm\\Resource\\Circle");
        Scanner sc = new Scanner(fr);

        ArrayList<Lamb> arrayList = new ArrayList();

        while (sc.hasNext()) {
            double freq = sc.nextDouble();
            String str = sc.nextLine();
            arrayList.add(new Lamb(freq, str));
        }
        Collections.sort(arrayList);
        fr.close();

        FileWriter fw = new FileWriter("D:\\Algorithm\\Resource\\SortFreq.txt");

        for (int i = 0; i < arrayList.size(); i++) {
            fw.write((i+1)+") "+arrayList.get(i).toString() + "\n");
        }
        fw.close();
    }
}
