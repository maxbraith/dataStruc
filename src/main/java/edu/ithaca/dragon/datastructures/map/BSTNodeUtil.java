package edu.ithaca.dragon.datastructures.map;

import java.util.ArrayList;
import java.util.List;

public class BSTNodeUtil {

    /**
     * @pre root must be a node of a valid binary search tree
     * @pre the BST from root must not already contain item 
     * @post BST from root will be mutatated to contain a new node with the given item
     * @throws IllegalArgumentException if root is null or the BST already contains item
     */
    public static <T> void bstAddTail(BTNode<T> root, T item, int key){
        if(root == null || root.getItem().equals(item)){
            throw new IllegalArgumentException();
        }
        if(key>root.getKey()){
            if(root.getRight() == null){
                root.setRight(new BTNode<T>(item, key));
            }
            else{
                bstAddTail(root.getRight(), item, key);
            }
        }
        if(key<root.getKey()){
            if(root.getLeft() == null){
                root.setLeft(new BTNode<T>(item, key));
            }
            else{
                bstAddTail(root.getLeft(), item, key);
            }
            
        } 

        
    }

    /**
     * @pre root must be a node of a valid binary search tree, or null
     * @pre the bst from root must not already contain item 
     * @return  the root of a BST which contains a new node the given item
     * @post original BST might be modified to contain a new node with the given item
     * @throws IllegalArgumentException if the bst already contains item
     */
    public static <T extends Comparable<T>> BTNode<T> bstAdd(BTNode<T> root, T item, int key){
        if(root == null){
            return new BTNode<T>(item, key);
        }
        if(item.compareTo(root.getItem()) > 0){
            if(root.getRight() == null){
                root.setRight(new BTNode<T>(item, key));
            }
            else{
                root.setRight(bstAdd(root.getRight(), item, key));
            }
        }
        else if(item.compareTo(root.getItem()) < 0){
            if(root.getLeft() == null){
                root.setLeft(new BTNode<T>(item, key));
            }
            else{
                root.setLeft(bstAdd(root.getLeft(), item, key));
            }
            
        } 
        else{
            throw new IllegalArgumentException();
        }
        return root;

    }

    /**
     * @pre root must be a node of a valid binary search tree, or null
     * @return true if the item is found in the bst, false otherwise 
     */
    public static <T extends Comparable<T>> boolean bstContains(BTNode<T> root, T item){
        if(root == null){
            return false;
        }
        if(root.getItem().equals(item)){
            return true;
        }
        if(bstContains(root.getLeft(), item) == true || bstContains(root.getRight(), item)==true){
            return true;
        }
        return false;
    }

    public static <T> T BSTget(BTNode<T> node, int key){
        if(node == null){
            return null;
        }
        if(node.getKey() == key){
            return node.getItem();
        }
        if(node.getKey() > key){
            T left = BSTget(node.getLeft(), key);
            return left;
        }
        if(node.getKey() < key){
            T right = BSTget(node.getRight(), key);
            return right;
        }
        return null;
    }

    public static <T> int nodeCount(BTNode<T> root){
        if(root == null){
            return 0;
        }
        else{
            return nodeCount(root.getLeft()) + nodeCount(root.getRight()) + 1;
        }   
    }

    public static <T> List<Integer> keyList(BTNode<T> root){
        List<Integer> myList;
        myList = new ArrayList<Integer>();
        if(root == null){
            return myList;
        }
        myList.add(root.getKey());
        myList.addAll(keyList(root.getLeft()));
        myList.addAll(keyList(root.getRight()));
        return myList;

    }

    public static <T> List<T> itemList(BTNode<T> root){
        List<T> myList;
        myList = new ArrayList<T>();
        if(root == null){
            return myList;
        }
        myList.add(root.getItem());
        myList.addAll(itemList(root.getLeft()));
        myList.addAll(itemList(root.getRight()));
        return myList;
    }
}
