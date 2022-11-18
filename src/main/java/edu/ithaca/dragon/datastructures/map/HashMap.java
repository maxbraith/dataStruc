package edu.ithaca.dragon.datastructures.map;

import java.util.ArrayList;
import java.util.List;

public class HashMap<T> implements Map<T> {
    BTNode<T>[] map;

    public HashMap(int size){
        map = new BTNode[size];
    }

    @Override
    public void put(int key, T value) {
        // TODO Auto-generated method stub
        int index = Math.abs(key % map.length);
        if(map[index] == null){
            map[index] = new BTNode<T>(value, key);
        }
        else{
            BTNode<T> indexNode = map[index];
            BSTNodeUtil.bstAddTail(indexNode, value, key);
        }

        
    }

    @Override
    public T get(int key) {
        // TODO Auto-generated method stub
        int index = Math.abs(key % map.length);
        if(map[index] == null){
            return null;
        }
        if(map[index].getKey() == key){
            return map[index].getItem();
        }
        if(map[index].getKey() > key){
            T left = BSTNodeUtil.BSTget(map[index].getLeft(), key);
            return left;
        }
        if(map[index].getKey() < key){
            T right = BSTNodeUtil.BSTget(map[index].getRight(), key);
            return right;
        }
        return null;

    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        int count = 0;
        for(int i=0; i<map.length; i++){
            count = count + BSTNodeUtil.nodeCount(map[i]);
        }
        return count;
    }

    @Override
    public List<Integer> keys() {
        // TODO Auto-generated method stub
        List<Integer> myList;
        myList = new ArrayList<Integer>();
        for(int i=0; i<map.length; i++){
            myList.addAll(BSTNodeUtil.keyList(map[i]));
        }
        return myList;
    }

    @Override
    public List<T> values() {
        // TODO Auto-generated method stub
        List<T> myList;
        myList = new ArrayList<T>();
        for(int i=0; i<map.length; i++){
            myList.addAll(BSTNodeUtil.itemList(map[i]));
        }
        return myList;
    }


    
}
