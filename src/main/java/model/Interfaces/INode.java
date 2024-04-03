package model.Interfaces;

public interface INode {
    public void insert(int key,String value);
    public void delete(int key);
    public String search(int key);
    public String preOrder();
    public String postOrder();
    public String inOrder();
}
