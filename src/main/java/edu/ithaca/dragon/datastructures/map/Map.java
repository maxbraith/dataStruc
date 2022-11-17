package edu.ithaca.dragon.datastructures.map;

import java.util.List;

public interface Map<T> {
    /**
     * @post puts a new key-value pair into the map.
     *       If the key was already in the map, 
     *       the new value replaces the old value for that key
     */
    void put(int key, T value);

    /**
     * @return the item associated with the given key in this map, 
     *         or null, if the key is not present
     */
    T get(int key);

    /**
     * @return the current number of key-value pairs in the map
     */
    int size();

    /**
     * @return a list of all keys in the current map
     */
    List<Integer> keys();

    /**
     * @return a list of all values in the current map
     */
    List<T> values();
}
