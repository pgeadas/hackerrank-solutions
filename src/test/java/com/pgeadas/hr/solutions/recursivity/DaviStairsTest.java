package com.pgeadas.hr.solutions.recursivity;

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
        String expected = "1\n4\n44"; 
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
        String expected = "410744\n15902591\n2082876103"; 
        assertEquals(expected, result);
    }
    
        /**
     * Testing with custom example*
     */
    @Test
    public void testDaviStairs3() {
        System.out.println("main");
        Integer[] args = {4, 4, 5, 6, 7};
        String result = DaviStairs.testFromHere(args);
        String expected = "7\n13\n24\n44"; 
        assertEquals(expected, result);
    }

}
