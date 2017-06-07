/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgeadas.hr.solutions.recursivity;

import com.pgeadas.hr.solutions.stacks.BalancedBrackets;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author geadas
 */
public class DaviStairsTest {

    public DaviStairsTest() {
    }

    /**
     * Testing with HackerRank example*
     */
    @Test
    public void testDaviStairs1() {
        System.out.println("main");
        Integer[] args = {3, 1, 3, 7};
        String result = DaviStairs.testFromHere(args);
        String expected = "1\n4\n44"; // both begin with hac, none with hak
        assertEquals(expected, result);
    }

    /**
     * Testing with custom example*
     */
    @Test
    public void testDaviStairs2() {
        System.out.println("main");
        Integer[] args = {3, 22, 28, 36};
        String result = DaviStairs.testFromHere(args);
        String expected = "410744\n15902591\n2082876103"; // both begin with hac, none with hak
        assertEquals(expected, result);
    }

}
