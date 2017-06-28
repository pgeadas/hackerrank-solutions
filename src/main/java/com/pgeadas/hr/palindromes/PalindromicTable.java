package com.pgeadas.hr.palindromes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author geadas
 */
//the coordinates of the solution rectangle
class Coordinate {

    int x;
    int y;

    public Coordinate() {
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
//the rectangle being tested

class Rectangle {

    int n;
    int m;
    int area;

    public Rectangle(int n, int m) {
        this.n = n;
        this.m = m;
        this.area = n * m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void printArea() {
        System.out.println(area);
    }

    public void printSides() {
        System.out.println("r.n: " + n + "; r.m: " + m);
    }

    @Override
    public String toString() {
        return "Pair{" + "n=" + n + ", m=" + m + ", area=" + area + '}';
    }

}

public class PalindromicTable {

    static int[][] matrix;
    static ArrayList<Rectangle> rectangles = new ArrayList<>();
    static StringTokenizer st = null;
    static BufferedReader bi;
    static int N;
    static int M;
    static Coordinate start = new Coordinate(0, 0);
    static Coordinate end = new Coordinate(1, 1);
    static HashMap<Integer, Integer> totalCounts = new HashMap();
    static HashMap<Integer, Integer> totalCountsAux = new HashMap();
    //used for testing the program
    static String solution = "";

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            bi = new BufferedReader(new InputStreamReader(System.in));
        } else {
            bi = new BufferedReader(new FileReader(args[0]));
        }
        String line;

        if ((line = bi.readLine()) != null) {
            st = new StringTokenizer(line);
        }

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //the table
        matrix = new int[N][M];
        //calculates the areas of the possible rectangles
        calculateAreas(N, M);

        //Creates the matrix
        readLines(N);

        if (checkAllEqual()) {
            return;
        }

        doJob(rectangles);

    }

    public static boolean checkAllEqual() {
        if (totalCounts.size() == 1) {
            System.out.println(1);
            solution = "1\n" + printCoordinates();
            return true;
        }
        return false;
    }

    public static void doJob(ArrayList<Rectangle> rectangles) {
        for (Rectangle r : rectangles) {
            if (sweepMatrix(r)) {
                printSolution(r);
                return;
            }
        }
    }

    private static void printSolution(Rectangle r) {
        r.printArea();
        solution = r.area + "\n";
        solution += printCoordinates();
    }

    public static String printCoordinates() {
        String sol = start.getX() + " " + start.getY() + " " + (end.getX() - 1) + " " + (end.getY() - 1);
        System.out.println(sol);
        return sol;
    }

    /**
     * Tests all possible rectangles until it finds a solution
     *
     *
     * @param r
     * @return
     */
    public static boolean sweepMatrix(Rectangle r) {

        start.setX(0);
        start.setY(0);
        for (int i = 0; i <= N - r.n; i++) {
            start.setX(i);
            end.setX(r.n + i);
            for (int j = 0; j <= M - r.m; j++) {
                start.setY(j);
                end.setY(r.m + j);
                if (checkIfPalindrome(r)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Since we start from the bigger rectangles, its cheaper to eliminate the
     * rows/columns than counting all the elements inside a rectangle
     *
     *
     * @param r
     * @return
     */
    public static boolean checkIfPalindrome(Rectangle r) {

        //if we are already with the smaller rectangle possible, just return it
        if (r.getArea() == 1) {
            return true;
        }

        totalCountsAux = new HashMap<>(totalCounts);

        for (int x = N - 1; x >= end.getX(); x--) {
            for (int y = M - 1; y >= 0; y--) {
                updateAuxMapCount(matrix[x][y]);
            }
        }

        for (int x = 0; x < start.getX(); x++) {
            for (int y = 0; y < M; y++) {
                updateAuxMapCount(matrix[x][y]);
            }
        }

        for (int y = end.getY(); y < M; y++) {
            for (int x = start.getX(); x < end.getX(); x++) {
                updateAuxMapCount(matrix[x][y]);
            }
        }

        for (int y = 0; y < start.getY(); y++) {
            for (int x = start.getX(); x < end.getX(); x++) {
                updateAuxMapCount(matrix[x][y]);
            }
        }

        return verifySolution(r.area);

    }

    public static void readLines(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            readLine(bi.readLine(), i);
        }
    }

    public static void readLine(String row, int index) {
        st = new StringTokenizer(row);
        int i = 0;
        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            matrix[index][i++] = value;
            updateMapCount(value);
        }
    }

    private static void updateMapCount(int value) {
        if (totalCounts.get(value) == null) {
            totalCounts.put(value, 1);
        } else {
            totalCounts.put(value, (totalCounts.get(value) + 1));
        }
    }

    private static void updateAuxMapCount(int value) {
        if (totalCountsAux.get(value) == 0) {
            //totalCountsAux.put(value, 0);
        } else {
            totalCountsAux.put(value, (totalCountsAux.get(value) - 1));
        }
    }

    /**
     * In order to check if a rectangle is solution, we sum the mod2 of the
     * elements *
     */
    private static int sumHashValues(HashMap<Integer, Integer> theMap) {
        int sum = 0;
        sum = theMap.keySet().stream()
                .map((key) -> theMap.get(key) % 2).reduce(sum, Integer::sum);
        return sum;
    }

    /**
     * Calculates the areas of the possible rectangles in the given matrix
     *
     *
     * @param n
     * @param m
     */
    public static void calculateAreas(int n, int m) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                rectangles.add(new Rectangle(i, j));
            }
        }
        sortRectangles(rectangles);
    }

    /**
     * Sorts the rectangles, so we start checking from the bigger one
     *
     *
     * @param rectangles
     */
    public static void sortRectangles(ArrayList<Rectangle> rectangles) {
        Collections.sort(rectangles, areaComparator);
    }

//verifies if the given rectangle is a solution
    private static boolean verifySolution(int area) {

        int zeroCount = 0;

        try {
            zeroCount = totalCountsAux.get(0);
        } catch (Exception ex) {

        }

        if (zeroCount > (area - 2)) {
            return false;
        }

        int totalCountsSum = sumHashValues(totalCountsAux);

        if (area % 2 == 0) {
            if (totalCountsSum == 0) {
                return true;
            }
        } else {
            if (totalCountsSum == 1) {
                return true;
            }
        }

        return false;
    }

    //comparator used to sort the rectangles by area
    static Comparator<Rectangle> areaComparator = new Comparator<Rectangle>() {

        @Override
        public int compare(Rectangle o1, Rectangle o2) {
            int i = o1.getArea();
            int j = o2.getArea();
            if (i > j) {
                return -1;
            } else if (i < j) {
                return 1;
            } else {
                return 0;
            }
        }

    };
}
