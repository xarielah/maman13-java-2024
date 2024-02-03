
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;;

/**
 * Ex13Test
 */
public class Ex13Test {

    @Test
    public void testMaxMult3() {
        int[] normalResult = { -8, 1, -4, 11, 9, -15, 10, 8, -3 };
        assertEquals(1320, Ex13.maxMult3(normalResult));

        int[] lessThanThree = { 2, 3 };
        assertEquals(Integer.MIN_VALUE, Ex13.maxMult3(lessThanThree));

        int[] allNegative = { -10, -200, -35, -2, -30 };
        assertEquals(-600, Ex13.maxMult3(allNegative));
    }

    @Test
    public void testFindMedian() {
        int[] arr1 = { 1, 12, 15, 26, 38 };
        int[] arr2 = { 12, 13, 18, 30, 45 };
        assertEquals(16, Ex13.findMedian(arr1, arr2));
    }

    @Test
    public void testMinimalSt() {
        String st1 = "AGGTAB";
        String st2 = "GXTXAYB";
        assertEquals(Ex13.minimalSt(st1, st2), "AGXGTXAYB");
        // assertEquals(Ex13.minimalSt(st1, st2), "AGGXTXAYB");
    }

    @Test
    public void testSnake() {
        int[][] a = {
                { 4, 5, 2, 3, 1 },
                { 3, 4, 1, 4, 4 },
                { 1, 5, 6, 7, 8 },
                { 3, 4, 5, 8, 9 },
                { 3, 2, 2, 7, 6 },
        };
        assertEquals(13, Ex13.maxSnake(a));
    }
}