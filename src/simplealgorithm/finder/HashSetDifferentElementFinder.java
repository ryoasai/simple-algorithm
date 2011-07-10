/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplealgorithm.finder;

import java.util.HashSet;
import java.util.Set;

/**
 * This algorithm requires only O(N) calculations.
 * 
 * @author Ryo Asai
 */
public class HashSetDifferentElementFinder extends BaseDifferentElementFinder {

    private Set<Integer> data1Set;

    public HashSetDifferentElementFinder(int[] data1, int[] data2, int threadCount) {
        super(data1, data2, threadCount);
    }
        
    public HashSetDifferentElementFinder(int[] data1, int[] data2) {
        super(data1, data2);
    }

    @Override
    protected void init() {
        data1Set = initSet(data1);
    }

    private Set<Integer> initSet(int[] data) {
        // Fill hash set with data1, unfortunately here are no simple way to initilize with a primitive array.
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < data.length; i++) {
            set.add(data[i]);
        }
        return set;
    }
        
    @Override
    protected boolean matchFound(int data) {
        return data1Set.contains(data);
    }

}
