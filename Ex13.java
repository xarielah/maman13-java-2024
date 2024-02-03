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

        // Get the maximum from each first element of the 2 numbers array
        int maximum = Math.max(arr1[l1], arr2[l2]);

        // Get the minimum from each second element of the 2 numbers array
        int minimum = Math.min(arr1[r1], arr2[r2]);

        return (maximum + minimum) / 2;
    }

    /**
     * Method accepts two string and returns the minimal interlaced
     * version of both strings.
     * 
     * @param st1 string
     * @param st2 string
     * @return minimal string
     */
    public static String minimalSt(String st1, String st2) {
        return minimalSt("", st1, 0, st2, 0);
    }

    private static String minimalSt(String result, String st1, int index1, String st2, int index2) {
        // We use the recursive includes function to check at anytime if
        // our progressivly-built result variable is is including both
        // strings within it.
        if (includes(result, st1) && includes(result, st2)) {
            return result;
        }

        // We initialize to temporary variable that will be used to
        // traverse between the recursive string built during the run of the function.
        String m1 = "", m2 = "";

        // As long as index is less than the length of st1 we continue iterating the st1
        // string
        // this will progressivly build our result variable in "interlacing" way.
        if (index1 < st1.length()) {
            m1 = minimalSt(result + st1.charAt(index1), st1, index1 + 1, st2, index2);
        }

        // As long as index is less than the length of st2 we continue iterating the st2
        // string
        // this will progressivly build our result variable in "interlacing" way.
        if (index2 < st2.length()) {
            m2 = minimalSt(result + st2.charAt(index2), st1, index1, st2, index2 + 1);
        }

        // If at any point both temp variables are empty, we return an empty string.
        if (m1.equals("") && m2.equals("")) {
            return "";
        }

        // When we will reach to a point where both temp variables are populated we will
        // return the shortest version between them.
        if (!m1.equals("") && !m2.equals("")) {
            return m1.length() < m2.length() ? m1 : m2;
        }

        // When the rest of the condition aren't met, indexes ar the end of the strings,
        // one of the temp vars is empty, we return the temp var which is not empty.
        return !m1.equals("") ? m1 : m2;

    }

    private static boolean includes(String string, String subStr) {
        return includes(string, 0, subStr, 0);
    }

    private static boolean includes(String string, int index1, String subStr, int index2) {
        if (index2 == subStr.length()) {
            return true;
        }

        if (index1 == string.length()) {
            return false;
        }

        if (subStr.charAt(index2) == string.charAt(index1)) {
            index2++;
        }

        index1++;

        return includes(string, index1, subStr, index2);
    }

    public static int maxSnake(int[][] a) {
        int maxPath = maxSnake(a, 0, 0, a[0][0]);
        return maxPath > 0 ? maxPath : Integer.MIN_VALUE;
    }

    private static int maxSnake(int[][] a, int i, int j, int prev) {
        if (i < 0 || j < 0 || i == a.length || j == a[0].length) {
            return Integer.MIN_VALUE;
        }

        int cur = a[i][j];

        if (cur < 0) {
            return Integer.MIN_VALUE;
        }

        if (Math.abs(cur - prev) > 1) {
            return Integer.MIN_VALUE;
        }

        if (i == a.length - 1 && j == a[0].length - 1) {
            return 1;
        }

        int up = maxSnake(a, i - 1, j, cur);
        int down = maxSnake(a, i + 1, j, cur);
        int right = maxSnake(a, i, j + 1, cur);
        int left = maxSnake(a, i, j - 1, cur);

        a[i][j] *= -1;

        return 1 + Math.max(
                Math.max(up, down),
                Math.max(left, right));
    }
}
