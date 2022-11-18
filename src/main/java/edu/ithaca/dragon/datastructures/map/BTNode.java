package edu.ithaca.dragon.datastructures.map;

public class BTNode<T> {

    private T item;
    private int key;
    private BTNode<T> left;
    private BTNode<T> right;

    public BTNode(T item, int key){
        this.item = item;
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public T getItem(){
        return item;
    }

    public int getKey(){
        return key;
    }

    public void setItem(T key) {
		this.item = key;
	}

	public BTNode<T> getLeft() {
		return left;
	}

	public BTNode<T> getRight() {
		return right;
    }

	public void setLeft(BTNode<T> left) {
		this.left = left;
	}

	public void setRight(BTNode<T> right) {
		this.right = right;
	}

    
    
}
