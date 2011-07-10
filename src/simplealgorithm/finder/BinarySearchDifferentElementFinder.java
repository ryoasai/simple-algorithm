/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplealgorithm.finder;

import java.util.Arrays;

/**
 * This algorithm requires O(N log(N)) calculations.
 * 
 * @author Ryo Asai
 */
public class BinarySearchDifferentElementFinder extends BaseDifferentElementFinder {

    public BinarySearchDifferentElementFinder(int[] data1, int[] data2, int threadCount) {
        super(data1, data2, threadCount);
    }
        
    public BinarySearchDifferentElementFinder(int[] data1, int[] data2) {
        super(data1, data2);
    }

    protected void init() {
        Arrays.sort(data1);
    }

    @Override
    protected boolean matchFound(int data) {
        return Arrays.binarySearch(data1, data) >= 0;
    }

}
