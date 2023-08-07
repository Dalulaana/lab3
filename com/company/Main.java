package com.company;
import java.util.Scanner;
public class Main
{
    /*
    public static void main(String[] args)
    {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.put(10, "value for 10");
        tree.put(5, "value for 5");
        tree.put(15, "value for 15");
        tree.put(3, "value for 3");
        tree.put(7, "value for 7");
        tree.put(12, "value for 12");
        tree.put(18, "value for 18");

        for (var entry : tree)
        {
            System.out.println("key is "+entry.key+" and value is "+entry.value);
        }
    }
    */
    public static void main(String[] args)
    {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<>();

        binaryTree.put(5, "5");
        binaryTree.put(3, "3");
        binaryTree.put(7, "7");
        binaryTree.put(2, "2");
        binaryTree.put(4, "4");

        int toFind=3;
        Entry<Integer, String> entry=binaryTree.find(toFind);
        if (entry!=null)
        {
            System.out.println(entry.key+" "+entry.value);
        }
        else
        {
            System.out.println("not found");
        }
    }

}
