package Lafore.Chap6_Recursion;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Pow_Test {
    Pow pow = new Pow();
    Pow pow1 = new Pow();

    @Test
    public void pow_test() {

        assertEquals(8, pow.powSimple(2, 3));
        System.out.println(pow.count);
        assertEquals(27, pow.powSimple(3, 3));
        pow.count = 0;
        assertEquals(1024, pow.powSimple(2, 10));

        //assertEquals(49, pow.powSimple(7, 2));
        System.out.println(pow.count);

        assertEquals(8, pow1.power(2, 3));
        System.out.println(pow1.count);
        assertEquals(27, pow1.power(3, 3));
        pow1.count = 0;
        assertEquals(1024, pow1.power(2, 10));

        //assertEquals(49, pow1.power(7, 2));
        System.out.println(pow1.count);
    }
}
