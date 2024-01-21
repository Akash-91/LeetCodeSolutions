package com.tree;

import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;
public class PrintBinaryTreeVertical
{
    static class Node
    {
        int key;
        Node left;
        Node right;
        Node(int data)
        {
            key = data;
            left = null;
            right = null;
        }
    }
    static void printVerticalTree(Node root, int distance, TreeMap<Integer,Vector<Integer>> map)
    {
        if(root == null)
        {
            return;
        }
        Vector<Integer> keyValue = map.get(distance);
        if(keyValue == null)
        {
            keyValue = new Vector<>();
            keyValue.add(root.key);
        }
        else
            keyValue.add(root.key);
        map.put(distance, keyValue);
        printVerticalTree(root.left, distance-1, map);
        printVerticalTree(root.right, distance+1, map);
    }
    static void printVerticalOrder(Node root)
    {
        TreeMap<Integer,Vector<Integer>> m = new TreeMap<>();
        int distance =0;
        printVerticalTree(root,distance,m);
        for (Entry<Integer, Vector<Integer>> getentry : m.entrySet())
        {
            System.out.println(getentry.getValue());
        }
    }
    public static void main(String[] args)
    {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(11);
        root.right.left = new Node(14);
        root.right.right = new Node(17);
        root.right.left.right = new Node(18);
        root.right.right.right = new Node(25);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }
}