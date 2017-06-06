/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgeadas.hr.solutions.stacks;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author geadas
 */
public class BalancedBracketsTest {

    public BalancedBracketsTest() {
    }

    /**
     * Testing trie with HackerRank example*
     */
    @Test
    public void testBalancedBrackets1() {
        System.out.println("main");
        String[] args = {"3", "{[()]}", "{[(])}", "{{[[(())]]}}"};
        String result = BalancedBrackets.testFromHere(args);
        String expected = "YES\nNO\nYES"; // both begin with hac, none with hak
        assertEquals(expected, result);
    }

    /**
     * Testing trie with custom example*
     */
    @Test
    public void testBalancedBrackets2() {
        System.out.println("main");
        String[] args = {"4", "{[((}]}", "", "({}[()])", "}][{"};
        String result = BalancedBrackets.testFromHere(args);
        String expected = "NO\nYES\nYES\nNO"; // both begin with hac, none with hak
        assertEquals(expected, result);
    }

}
