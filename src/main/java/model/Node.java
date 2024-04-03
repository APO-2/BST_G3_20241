package model;
import model.Interfaces.INode;
public class Node implements INode{
    
    private Node left;
    private Node right;
    private Node father;
    private int key;
    private String value;
    public Node(int key, String value) {
        this.key = key;
        this.value = value;
    }
    

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public void insert(int key, String value) {
        if(this.key > key){
            if(this.left == null){
                this.left = new Node(key,value);
                this.left.setFather(this);
            }
            else{
                this.left.insert(key,value);
            }
        }else if(this.key < key){
            if(this.right == null){
                this.right = new Node(key,value);
                this.right.setFather(this);
            }
            else{
                this.right.insert(key,value);
            }
        }
    }

    @Override
    public void delete(int key) {

    }

    @Override
    public String search(int key) {
        return null;
    }

    @Override
    public String preOrder() {
        return null;
    }

    @Override
    public String postOrder() {
        return null;
    }

    @Override
    public String inOrder() {
        String result = "";
        if(this.left != null){
            result = this.left.inOrder();
        }
        result+=this.toString() + " ";
        if(this.right != null){
            result += this.right.inOrder();
        }
        return result;
    }
    public String toString(){
        return key + " " + value;
    }
}
