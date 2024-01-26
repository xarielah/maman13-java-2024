
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

}