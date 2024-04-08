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
        Node temp = searchN(key);
        if(temp!=null){
           delete(temp);
        }



    }
    private void delete (Node temp){
        //si es hoja
        if((temp.right==null)&&(temp.left==null)){
            if(temp.isRightSon()){
                temp.father.right=null;
            }else {
                temp.father.left=null;
            }
        } else if ((temp.right!=null)&&(temp.left!=null)) {
            // si se tienen ambos hijos
            Node max = temp.left.max();
            temp.key = max.key;
            temp.value = max.value;
            delete(max);
        }else {
            //si uno de los hijos es diferente de null
            if(temp.right!=null){
                if(temp.isRightSon()){
                    temp.father.right=temp.right;
                }else {
                    temp.father.left=temp.right;
                }
                temp.right.father=temp.father;
            }else {
                if(temp.isRightSon()){
                    temp.father.right=temp.left;
                }else {
                    temp.father.left=temp.left;
                }
                temp.left.father=temp.father;
            }

        }
    }
    public boolean isRightSon(){
        return this.father.right.key==key;
    }
    public Node max(){
        if(this.right!=null){
            return this.right.max();
        }
        return this;
    }
    public Node menor(){
        if(this.left!=null){
            return this.left.menor();
        }
        return this;
    }


    @Override
    public String search(int key) {
        Node temp = searchN(key);
        return temp == null ? "null" : temp.getValue();
    }

    private Node searchN(int key) {
        if (this.key > key) {
            return this.left == null ? null : this.left.searchN(key);
        }else if(this.key < key) {
            return this.right == null ? null : this.right.searchN(key);
        } else {
            return this;
        }
    }

    @Override
    public String preOrder() {

        String result = "";

        result+=this.toString() + " ";

        if(this.left != null){
            result += this.left.preOrder();
        }

        if(this.right != null){
            result += this.right.preOrder();
        }
        return result;

    }

    @Override
    public String postOrder() {

        String result = "";

        if(this.left != null){
            result = this.left.postOrder();
        }

        if(this.right != null){
            result += this.right.postOrder();
        }

        result+=this.toString() + " ";

        return result;

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
