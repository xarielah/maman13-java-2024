import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex13 {
    public static int maxMult3(int[] arr) {
        if (arr.length < 3) {
            return Integer.MIN_VALUE;
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2) {
                max3 = max2;
                max2 = arr[i];
            } else if (arr[i] > max3) {
                max3 = arr[i];
            }

            if (arr[i] < min1) {
                min2 = min1;
                min1 = arr[i];
            } else if (arr[i] < min2) {
                min2 = arr[i];
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static int findMedian(int[] arr1, int[] arr2) {

        int start = 0;
        int end = arr1.length - 1;
        int median1 = median(arr1);
        int median2 = median(arr2);
        while (start - end != 1) {

            if (median1 > median2) {
                start = 0;
                end = arr1.length / 2;
            } else if (median1 < median2) {
                start = arr1.length / 2;
                end = arr1.length - 1;
            } else {
                return median1;
            }
        }

        int initMedian = Math.max(arr1[start], arr2[start]);
        int finalMedian = Math.max(arr1[end], arr2[end]);

        return (finalMedian + initMedian) / 2;
    }

    private static int median(int[] arr) {
        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        } else {
            return arr[arr.length / 2];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        System.out.println(maxMult3(arr));

        int[] arr1 = { 1, 12, 15, 26, 38 };
        int[] arr2 = { 12, 13, 18, 30, 45 };
        System.out.println(findMedian(arr1, arr2));
    }
}