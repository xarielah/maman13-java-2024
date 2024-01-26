public class Ex13 {
    /**
     * Accepts a non-empty array of integers and returns the maximum product of 3
     * 
     * The time complexity is O(n) and the space complexity is O(1)
     * 
     * Time complexity is O(n) because we iterate through the array once, meaning it
     * is n steps which will linearly increase the time complexity.
     * 
     * Space complexity is O(1) because we only use contant amound of integer
     * variables, and is not dependent on the size of the input.
     * 
     * @param arr
     * @return the maximum product of 3 elements in the array
     */
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

    /**
     * Find the median of 2 separate and sorted arrays as combined sorted arrays.
     * 
     * Time complexity here is O(logn) because we "cut" the array in half each time
     * we iterate it and find the median of both array, therefore we are increasing
     * the running time by log of n with input's growth.
     * 
     * Space complexity is O(1), we use predeclated, and not-input-dependant
     * variables that the space
     * complexity is constant and not increasing with input.
     * 
     * @param arr1
     * @param arr2
     * @return the median of the arrays combined and sorted
     */
    public static int findMedian(int[] arr1, int[] arr2) {
        int l1 = 0, r1 = arr1.length - 1;
        int l2 = 0, r2 = arr2.length - 1;
        int median1 = 0, median2 = 0;

        while (r1 - l1 != 1 && r2 - l2 != 1) {
            int mid1 = (l1 + r1) / 2;
            median1 = arr1[mid1];

            int mid2 = (r2 + l2) / 2;
            median2 = arr2[mid2];

            if (median1 < median2) {
                l1 = mid1;
                r2 = mid2;
            } else if (median1 > median2) {
                r1 = mid1;
                l2 = mid2;
            } else {
                return median1;
            }
        }

        int maximum = Math.max(arr1[l1], arr2[l2]);
        int minimum = Math.min(arr1[r1], arr2[r2]);

        return (maximum + minimum) / 2;
    }

    // public static int binarySearch(int arr[], int target) {
    // int l = 0, r = arr.length - 1;

    // while (l <= r) {
    // int m = (r + l) / 2;

    // if (arr[m] < target) {
    // l = m + 1;
    // } else if (arr[m] > target) {
    // r = m - 1;
    // } else {
    // return m;
    // }
    // }

    // return -1;
    // }

    public static void main(String[] args) {
        int[] arr1 = { 1, 12, 15, 26, 38 };
        int[] arr2 = { 12, 13, 18, 30, 45 };
        System.out.println(findMedian(arr1, arr2));
    }
}