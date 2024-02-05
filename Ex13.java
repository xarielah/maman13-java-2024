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
        // Check if the array is less than three then
        // return MIN_VALUE.
        if (arr.length < 3) {
            return Integer.MIN_VALUE;
        }

        // Poplate maximum variables, we populate them
        // with MIN_VALUE so we can have the lowest base for the next if's
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        // Poplate minimum variables, we populate them
        // with MAX_VALUE so we can have the highest base for the next if's
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // For loop the array.
        for (int i = 0; i < arr.length; i++) {

            // This entire if block basically help us bubble new maximum
            // values, and keep track of the highest numbers in the array.
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

            // Same as above, this entire if block basically help us bubble new minimum
            // values, and keep track of the lowest numbers in the array.
            if (arr[i] < min1) {
                min2 = min1;
                min1 = arr[i];
            } else if (arr[i] < min2) {
                min2 = arr[i];
            }
        }

        // Return either the multiply of the three maximum numbers
        // or the highest number and lowest numbers.
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
        // We initialize the boundries of each (l = left, r = right)
        // of the arrays and later on we'll use that to set new poritions of the
        // array to run on.
        int l1 = 0, r1 = arr1.length - 1;
        int l2 = 0, r2 = arr2.length - 1;

        // Initialize new medians
        int median1 = 0, median2 = 0;

        // While the gap of left's and right's of both arrays
        // we keep iterating. The whole method here is to reach
        // a point where we have 2 items available in each array and we calculate it.
        while (r1 - l1 != 1 && r2 - l2 != 1) {

            // Calculate middle as int.
            int mid1 = (l1 + r1) / 2;

            // Set the new median / half for the first array
            median1 = arr1[mid1];

            // Calculate middle as int.
            int mid2 = (r2 + l2) / 2;

            // Set the new median / half for the second
            median2 = arr2[mid2];

            // If the first array's median is smaller then the second's\
            if (median1 < median2) {
                // we'd set the boundries of the beginning of the first array to it' middle,
                // keeping the right side of the array.
                l1 = mid1;

                // We'd take the end of the second array and set it to the middle
                // taking the left of the array.
                r2 = mid2;
            } else if (median1 > median2) {
                // We'd take the end of the first array and set it to the middle
                // taking the left of the array.
                r1 = mid1;

                // we'd set the boundries of the beginning of the second array to it' middle,
                // keeping the right side of the array.
                l2 = mid2;
            } else {
                // If the medians are equal, we reutrn a median
                return median1;
            }
        }

        // After exiting the array we'd basically take the largest number between the
        // pairs
        // and the lowest value between the pairs for example:
        // first array = [20, 60];
        // second array = [1, 99];

        // We'd take 99, and 20

        // Get the maximum from each first element of the 2 numbers array
        int maximum = Math.max(arr1[l1], arr2[l2]);

        // Get the minimum from each second element of the 2 numbers array
        int minimum = Math.min(arr1[r1], arr2[r2]);

        // In order to give the median of 2 elements,
        // we calculate avarage of the two.
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

    /**
     * Check if the substring argument is interlaced in the string
     * 
     * @param string
     * @param subStr
     * @return
     */
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

    /**
     * Get a matrix of positive number (n > 0), traverse through the matrix
     * with certain rules, and return the longest path or MIN_VALUE as the return
     * value.
     * 
     * @param mat
     * @return longest path tiles / steps
     */
    public static int maxSnake(int[][] mat) {
        int maxSnakePath = maxSnake(mat, 0, 0, mat[0][0]);
        return maxSnakePath > 0 ? maxSnakePath : Integer.MIN_VALUE;
    }

    private static int maxSnake(int[][] mat, int i, int j, int prev) {
        // Rule that prevents the latest recursion steps from over extending beyond
        // the matrix's boundries.
        if (i < 0 || j < 0 || i == mat.length || j == mat[0].length)
            return Integer.MIN_VALUE;

        // If current position is less than zero
        if (mat[i][j] < 0)
            return Integer.MIN_VALUE;

        // If we encounter an impossible step, we return MIN_VALUE.
        // this will be eliminated by the later Math.max function.
        if (Math.abs(mat[i][j] - prev) > 1)
            return Integer.MIN_VALUE;

        // Congrats we reached to the end of the matrix, we then
        // return 1 to sum that step as well.
        if (i == mat.length - 1 && j == mat[0].length - 1)
            return 1;

        // Current point is copied into the memory before being changed.
        int cur = mat[i][j];

        // In order for us not to go over the same step twice,
        // we temporarily change the tile's value to a negative-self,
        // then when continuing to go over the recursive calls we switch
        // it back to a positive value.
        mat[i][j] *= -1;

        // We take "branch" out ways to create a separate path for each
        // possible direction.
        int top = maxSnake(mat, i - 1, j, cur);
        int bottom = maxSnake(mat, i + 1, j, cur);
        int right = maxSnake(mat, i, j + 1, cur);
        int left = maxSnake(mat, i, j - 1, cur);

        // After all the recusive calls are done we turn that tile we
        // changed to negative, to a positive value.
        mat[i][j] *= -1;

        // We then ditermine between each direction, and eliminate MIN_VALUES values
        // from real values,
        // and take the biggest value between the four.
        int biggerHorizontal = Math.max(left, right);
        int biggerVertical = Math.max(top, bottom);

        // Return bigger value + 1 step to include the first step.
        return 1 + Math.max(biggerHorizontal, biggerVertical);
    }

}
