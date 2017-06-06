package com.pgeadas.hr.solutions.tries;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author geadas
 */
class Node {

    /* Node structure in Trie: bool indicating if its final word, 
    hash with set of children nodes, and number of words from this node*/
    boolean isFinalWord = false;
    HashMap<Character, Node> children = null;
    int numberOfWords = 0;
}

public class Tries {

    public static void main(String[] args) {
        readFromInput();
    }

    private static void readFromInput() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Node root = new Node();

        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            if (op.equalsIgnoreCase("add")) { //add
                addContact(contact, root);
            } else if (op.equalsIgnoreCase("find")) { //search
                System.out.println(searchContact(contact, root));
            } else {
                System.out.println("Unexpected operation... Exiting.");
            }
        }
    }

    /**
     * Used to test the program, passing the arguments from an array, instead of
     * System.in
     *
     *
     * @param args
     * @return
     */
    public static String readFromArgs(String[] args) {

        StringBuilder results = new StringBuilder();

        int n = Integer.parseInt(args[0]);

        Node root = new Node();

        for (int a0 = 1; a0 <= n; a0++) {
            String op = args[a0];
            if (op.substring(0, 4).equalsIgnoreCase("add ")) { //add operation
                addContact(op.substring(4, op.length()), root);
            } else if (op.substring(0, 5).equalsIgnoreCase("find ")) { //search operation
                results.append(searchContact(op.substring(5, op.length()), root));
                results.append("\n");
            } else {
                System.out.println("Unexpected operation... Exiting.");
            }
        }

        return results.toString().substring(0, results.length() - 1);
    }

    /**
     * Adding a new Contact to the trie *
     *
     * @param contact
     * @param node
     *
     */
    private static void addContact(String contact, Node node) {
        for (int i = 0; i < contact.length() - 1; i++) {
            node = createNode(node, contact.charAt(i), false);
        }
        createNode(node, contact.charAt(contact.length() - 1), true);
    }

    /**
     * Searching for a Contact in the trie *
     *
     * @param contact
     * @param root
     *
     */
    private static int searchContact(String contact, Node root) {
        int count = 0;
        for (int i = 0; i < contact.length(); i++) {
            if (root.children != null && (root = root.children.get((Character) contact.charAt(i))) != null) {
                count++;
            } else {
                break;
            }
        }

        if (count == contact.length()) {
            return root.numberOfWords;
        } else {
            return 0;
        }

    }

    /**
     * Creating a new Node in the trie *
     *
     * @param contact
     * @param node
     *
     */
    private static Node createNode(Node parent, char c, boolean isFinal) {
        Node newNode;
        if (parent.children == null) { //parent has no child nodes yet
            parent.children = new HashMap();
            newNode = new Node();
            parent.children.put(c, newNode);
            newNode.numberOfWords += 1;
        } else { //verify if already has the char in the child nodes
            Node existingNode;
            if ((existingNode = parent.children.get(c)) == null) { //if it does not, add it
                newNode = new Node();
                parent.children.put(c, newNode);
                newNode.numberOfWords += 1;
                newNode.isFinalWord = isFinal;
                return newNode;
            } else { //if it does, check if it is a new final word, or a final word contained in another word
                if (isFinal && existingNode.isFinalWord) {
                    existingNode.numberOfWords = 1;
                } else {
                    existingNode.numberOfWords += 1;
                }
                return existingNode;
            }
        }

        return newNode;
    }

}
