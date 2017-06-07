/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgeadas.hr.solutions.recursivity;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author geadas
 */
public class DaviStairs {

    private static final Map<Integer, Integer> steps = new HashMap<>();

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

    private static int daviSteps(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        } else {
            if (!steps.containsKey(n)) {
                int count = daviSteps(n - 1) + daviSteps(n - 2) + daviSteps(n - 3);
                steps.put(n, count);
            }
            return steps.get(n);
        }
    }
}
