package ui;

import model.Tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(10,"diez");
        tree.insert(15,"quince");
        tree.insert(7,"siete");
        tree.insert(20,"veinte");
        tree.insert(5,"cinco");
        System.out.println(tree.inOrder());
    }
}
