package ui;

import model.Tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(20,"veinte");
        tree.insert(10,"diez");
        tree.insert(15,"quince");
        tree.insert(7,"siete");
        tree.insert(5,"cinco");
        tree.insert(8,"Ocho");
        tree.insert(12,"Doce");
        tree.insert(13,"Trece");
        tree.insert(2,"Dos");
        System.out.println(tree.inOrder());
        tree.delete(20);
        System.out.println(tree.inOrder());
        System.out.println(tree.preOrder());
        System.out.println(tree.postOrder());

    }
}
