package com.pgeadas.hr.solutions.recursivity;

import java.util.Scanner;

/**
 *
 * @author geadas
 *
 *  * Because the next step only depends on the 3 previous steps, you can use a
 * circular buffer of lenght 3, hence the "mod 3". So even for an arbitrary big
 * value of n, you will never get out of memory by allocating a huge array. So,
 * for a n = 4, the array[0] would be ignored, for a n = 5, array[0] and
 * array[1], etc.
 *
 */
public class DaviStairsConstantSpace {

    private static final long[] values = new long[3];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int a0 = 0; a0 < s; a0++) {
            int n = in.nextInt();
            System.out.println(daviSteps(n));
        }
    }

    public static String testFromHere(Integer[] args) {
        StringBuilder results = new StringBuilder();

        int n = args[0];

        for (int a0 = 1; a0 <= n; a0++) {
            results.append(daviSteps(args[a0]));
            results.append("\n");
        }

        return results.toString().substring(0, results.length() - 1);
    }

    private static long daviSteps(int n) {
        switch (n) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
        }
        values[0] = 1;
        values[1] = 2;
        values[2] = 4;
        int i = 3;
        for (; i < n; i++) {
            values[i % 3] = values[0] + values[1] + values[2];
        }
        return values[((i - 1) % 3)];
    }
}
