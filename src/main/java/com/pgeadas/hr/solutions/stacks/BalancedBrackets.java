package com.pgeadas.hr.solutions.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author geadas
 */
public class BalancedBrackets {

    private static Stack<Character> open;

    private static boolean isBalanced(String expression) {

        if (expression.length() % 2 != 0) {
            return false;
        }

        open = new Stack();

        for (int i = 0; i < expression.length(); i++) {
            //System.out.println("expression.charAt(i): " + expression.charAt(i));
            if (expression.charAt(i) == '(' || expression.charAt(i) == '[' || expression.charAt(i) == '{') {
                open.push(expression.charAt(i));
            } else {
                if (open.isEmpty()) {
                    return false;
                }
                Character c = open.pop();
                if (null != c) {
                    switch (c) {
                        case '(':
                            if (expression.charAt(i) != ')') {
                                return false;
                            }
                            break;
                        case '{':
                            if (expression.charAt(i) != '}') {
                                return false;
                            }
                            break;
                        case '[':
                            if (expression.charAt(i) != ']') {
                                return false;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }

        return open.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }

    public static String testFromHere(String[] args) {
        StringBuilder results = new StringBuilder();

        int n = Integer.parseInt(args[0]);

        for (int a0 = 1; a0 <= n; a0++) {
            String expression = args[a0];
            results.append((isBalanced(expression)) ? "YES" : "NO");
            results.append("\n");
        }

        return results.toString().substring(0, results.length() - 1);
    }
}
