package lab0;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lab0.Variant10;
import lab0.Variant10.DIRECTION;

public class Variant10Test {

    ////////////////////////////////////////////////

    @Test(dataProvider = "integerProvider")
    public void integerTest(int p1, int[] p2) {
        assertEquals(new Variant10().integerNumbersTask(p1), p2);
    }

    @DataProvider
    public Object[][] integerProvider() {

        return new Object[][] { { 328, new int[] {8, 2} }, { 808, new int[] {8, 0} }, { 228, new int[] {8, 2} } };
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeIntegerTest() {
        new Variant10().integerNumbersTask(50);
    }

    ////////////////////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int[] p3) {
        assertEquals(new Variant10().ifTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] { { 2, 3, new int[] {5, 5} }, { 3, 3, new int[] {0, 0} }, { -3, -3, new int[] {0, 0} } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, boolean p3) {
        assertEquals(new Variant10().booleanTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 5, 5, false }, { 0, 1, true }, { -3, 2, true } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "switchProvider")
    public void switchTest(DIRECTION c, int p1, DIRECTION p2) {
        assertEquals(new Variant10().switchTask(c, p1), p2);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] {
                { DIRECTION.EAST, 1, DIRECTION.NORTH},
                { DIRECTION.NORTH, -1, DIRECTION.EAST },
                { DIRECTION.WEST, 0, DIRECTION.WEST } };
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void switchNegativeTest() {
        new Variant10().switchTask(DIRECTION.NORTH,2);
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "forProvider")
    public void forTest(int n, double p2) {
        assertEquals(new Variant10().forTask(n), p2);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] { { 10, 2.9289682539682538 }, { 4, 2.083333333333333 }, { 123, 5.393459552775602 } };
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "whileProvider")
    public void whileTest(int a, int b) {
        assertEquals(new Variant10().whileTask(a), b);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 125, 4 }, { 81, 3 }, { 12832, 8 }, { 3, 0} };
    }

    @Test(expectedExceptions = NumberFormatException.class, dataProvider = "negativeWhileProvider")
    public void negativeWhileTest(int a) {
        new Variant10().whileTask(a);
    }

    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][] { { -2 }, { 1 }, { 0 } };
    }

    //////////////////////////////////////////
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int[] array1, int[] array2) {
        assertEquals(new Variant10().arrayTask(array1), array2);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] {
                { new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, new int[] {2, 4, 6, 8, 10, 9, 7, 5, 3, 1} },
                { new int[] { 1, 2 }, new int[]{ 2, 1 } },
                { new int[] { 2 }, new int[] { 2 }}
        };
    }

    //////////////////////////////////////////

    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[][] input, int[] output) {
        assertEquals(new Variant10().twoDimensionArrayTask(input), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input = {{2, 3, 6, 9, -9},
                {34, 98, -9, 2, 1},
                {-4, 2, 1, 6, 1},
                {-98, 8, 1, 5, 3}};

        int[][] input2 = {{-98, 8, 1, 3},
                {-4, 2, 1, 1},
                {34, 98, -9, 1},
                {2, 3, 6, -9}};

        int[][] input3 = {{2, 3, 6, 9, -9},
                {34, 98, -9, 2, 1}};

        return new Object[][] {
                {input, new int[]{2, 6, -9, 34, -9, 1, -4, 1, 1, -98, 1, 3}},
                {input2, new int[] {-98, 1, -4, 1, 34, -9, 2, 6}},
                {input3, new int[] {2, 6, -9, 34, -9, 1}}
        };
    }
}