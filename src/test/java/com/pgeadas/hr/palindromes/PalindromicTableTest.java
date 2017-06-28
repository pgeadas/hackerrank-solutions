/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgeadas.hr.palindromes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author geadas
 */
public class PalindromicTableTest {

    static StringTokenizer st = null;
    static BufferedReader bi;

    final static String dir = System.getProperty("user.dir");

    static StringBuilder expected = new StringBuilder();

    private static String getExpectedResult() throws FileNotFoundException, IOException {
        bi = new BufferedReader(new FileReader(dir + "/PalindromicTable/solution1.txt"));
        String line;

        while ((line = bi.readLine()) != null) {
            expected.append(line);
            expected.append("\n");
        }

        return expected.substring(0, expected.length() - 1);
    }

    /**
     * Test of main method, of class PalindromicTable.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testMain() throws Exception {
        String testdir = dir + "/PalindromicTable/test1.txt";
        PalindromicTable.main(new String[]{testdir});
        assertEquals(getExpectedResult(), PalindromicTable.solution);
    }

}
