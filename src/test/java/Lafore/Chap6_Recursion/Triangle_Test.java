package Lafore.Chap6_Recursion;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Triangle_Test {

    Triangle triangle = new Triangle();

    @Test
    public void triangleRec_Test() {
        assertEquals(1, triangle.triangle(1));
        assertEquals(3, triangle.triangle(2));
        assertEquals(6, triangle.triangle(3));
        assertEquals(10, triangle.triangle(4));
        assertEquals(15, triangle.triangle(5));


        assertEquals(1, triangle.triangleRec(1));
        assertEquals(3, triangle.triangleRec(2));
        assertEquals(6, triangle.triangleRec(3));
        assertEquals(10, triangle.triangleRec(4));
        assertEquals(15, triangle.triangleRec(5));
    }
}
