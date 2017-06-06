/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgeadas.hr.solutions.trees;

/**
 *
 * @author geadas
 */
public class Trees {

    /**
     * Hidden stub code will pass a root argument to the function below.
     * Complete the function to solve the challenge. Hint: you may want to write
     * one or more helper functions. * The Node class is defined as follows: *
     */
    class Node {

        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return inOrderTransverse(root, min, max);
    }

    /**
     * In order to be a BST, the elements in each subtree must be ordered. Thus,
     * if we find a parent node with a left child with greater value or right
     * child with lower value than the parent itself, it is not a BST.*
     */
    boolean inOrderTransverse(Node node, int min, int max) {
        if (node == null) {
            return true;
        } else {
            if (node.data <= min || node.data >= max) {
                return false;
            }
        }

        return inOrderTransverse(node.left, min, node.data) && inOrderTransverse(node.right, node.data, max);
    }
}
