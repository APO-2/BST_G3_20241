package model;

public class Tree {
    private Node root;
    public void insert(int key, String value){
        if(root == null ){
            root = new Node(key,value);
        }else{
            root.insert(key,value);
        }
    }
    public String inOrder(){
        return root == null ? "" : root.inOrder();
    }
}