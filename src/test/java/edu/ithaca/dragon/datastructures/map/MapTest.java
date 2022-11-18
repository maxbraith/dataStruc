package edu.ithaca.dragon.datastructures.map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MapTest {
        //TODO:Write your own tests for the Map functions and test your implementation
        @Test
        public void hashMapTest(){
                HashMap testMap = new HashMap(10);
                for(int i=25; i>0; i--){
                        testMap.put(i, i);
                }
                assertTrue(testMap.get(5).equals(5));
                assertTrue(testMap.get(23).equals(23));
                assertFalse(testMap.get(22).equals(21));
                assertTrue(testMap.size() == 25);

                HashMap testMap2 = new HashMap(3);
                testMap2.put(1, "one");
                testMap2.put(2, "two");
                testMap2.put(3, "three");
                testMap2.put(4, "four");
                testMap2.put(5, "five");
                testMap2.put(6, "six");
                testMap2.put(7, "seven");
                System.out.println(testMap2.values());
                System.out.println(testMap2.keys());

        }

}
