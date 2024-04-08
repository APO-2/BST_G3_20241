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
    public void delete(int key){
        if(root!=null){
            root.delete(key);
        }
    }
    public String inOrder(){
        return root == null ? "" : root.inOrder();
    }

    public String preOrder() {

        return root == null ? "" : root.preOrder();

    }

    public String postOrder() {

        return root == null ? "" : root.postOrder();

    }
}