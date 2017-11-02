package Lafore.Chap6_Recursion;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Factorial_Test {
    Factorial factorial = new Factorial();

    @Test
    public void triangleRec_Test() {
        assertEquals(1, factorial.factorialRec(0));
        assertEquals(1, factorial.factorialRec(1));
        assertEquals(2, factorial.factorialRec(2));
        assertEquals(6, factorial.factorialRec(3));
        assertEquals(24, factorial.factorialRec(4));
        assertEquals(120, factorial.factorialRec(5));


        assertEquals(1, factorial.factorial(0));
        assertEquals(1, factorial.factorial(1));
        assertEquals(2, factorial.factorial(2));
        assertEquals(6, factorial.factorial(3));
        assertEquals(24, factorial.factorial(4));
        assertEquals(factorial.factorial(999999), factorial.factorial(999999));
    }
}
