
public class Ex13StudentTester20441 {
    public static void main(String[] args) {

        System.out.println("----------------------------------------");
        System.out.println("***         Q1  - maxMult3           ***");
        System.out.println("----------------------------------------");
        System.out.println("arr:[-8,1,-4,11,9,-15,10,8,-3]");
        int[] arr = { -8, 1, -4, 11, 9, -15, 10, 8, -3 };
        int result1 = Ex13.maxMult3(arr);
        if (result1 == 1320)
            System.out.println("Passed, result is 1320");
        else
            System.out.println("Failed,  expected: 1320   student's result: " + result1);
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("***      Q2  - findMedian            ***");
        System.out.println("----------------------------------------");
        {
            int[] arr1 = { 1, 12, 15, 26, 38 };
            int[] arr2 = { 12, 13, 18, 30, 45 };
            System.out.println("arr1: [1,12,15,26,38]");
            System.out.println("arr1: [12,13,18,30,45]");
            int result2 = Ex13.findMedian(arr1, arr2);
            if (result2 == 16)
                System.out.println("Passed, result is 16");
            else
                System.out.println("Failed,  expected: 16  student's result: " + result2);
        }
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("***         Q3  - minimalSt          ***");
        System.out.println("----------------------------------------");
        System.out.println("Testing : st1=\"B\" st2=\"A\"");
        String st1 = "B";
        String st2 = "A";
        String result3 = Ex13.minimalSt(st1, st2);
        if (result3.equals("AB") || result3.equals("BA"))
            System.out.println("Passed, result is " + result3);
        else
            System.out.println("Failed,  expected: \"AB\" or \"BA\"   student's result: " + result3);
        System.out.println("Testing : st1=\"AA\" st2=\"A\"");
        st1 = "AA";
        st2 = "A";
        result3 = Ex13.minimalSt(st1, st2);
        if (result3.equals("AA"))
            System.out.println("Passed, result is " + result3);
        else
            System.out.println("Failed,  expected: \"AA\"  student's result: " + result3);
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("***         Q4  - maxSnake           ***");
        System.out.println("----------------------------------------");
        System.out.println("testing with matrix:");
        System.out.println("4 5 2 3 1");
        System.out.println("3 4 1 4 4");
        System.out.println("1 5 6 7 8");
        System.out.println("3 4 5 8 9");
        System.out.println("3 2 2 7 6");
        int[][] mat = { { 4, 5, 2, 3, 1 },
                { 3, 4, 1, 4, 4 },
                { 1, 5, 6, 7, 8 },
                { 3, 4, 5, 8, 9 },
                { 3, 2, 2, 7, 6 } };
        int result4 = Ex13.maxSnake(mat);
        if (result4 == 13)
            System.out.println("Passed, result is " + result4);
        else
            System.out.println("Failed,  expected: 13   student's result: " + result4);

        System.out.println();
    }
}
