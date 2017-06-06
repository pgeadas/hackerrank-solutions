package com.pgeadas.hr.solutions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author geadas
 */
public class TriesTest {

    public TriesTest() {
    }

    /**
     * Testing trie with HackerRank example*
     */
    @Test
    public void testTrie1() {
        System.out.println("main");
        String[] args = {"4", "add hack", "add hackerrank", "find hac", "find hak"};
        String result = Tries.readFromArgs(args);
        String expected = "2\n0"; // both begin with hac, none with hak
        assertEquals(expected, result);
    }

    /**
     * Testing trie with custom example*
     */
    @Test
    public void testTrie2() {
        System.out.println("main");
        String[] args = {"7", "add hack", "add hackerrank", "add hacky", "add hacker", "find hack", "find hacker", "find hak"};
        String result = Tries.readFromArgs(args);
        String expected = "4\n2\n0"; //all words begin with hack, only two begin with hacker, none begins with hak
        assertEquals(expected, result);
    }

}
