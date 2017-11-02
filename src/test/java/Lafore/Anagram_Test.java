package Lafore;

import Lafore.Chap6_Recursion.Anagram;
import org.junit.Test;

public class Anagram_Test {
    Anagram anagram = new Anagram("cats");

    @Test
    public void anagram_Test(){
        anagram.doAnagram(4);
        System.out.println(anagram.count);
    }
}
