/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplealgorithm.finder;

/**
 * This is the most unefficient algorithm, which requires O(N^2) times comparison.
 * 
 * @author Ryo Asai
 */
public class NestedLoopDifferentElementFinder extends BaseDifferentElementFinder {

    public NestedLoopDifferentElementFinder(int[] data1, int[] data2, int threadCount) {
        super(data1, data2, threadCount);
    }
        
    public NestedLoopDifferentElementFinder(int[] data1, int[] data2) {
        super(data1, data2);
    }

    @Override
    protected boolean matchFound(int data) {
        boolean matchFound = false;
        for (int j = 0; j < data1.length; j++) {
            if (data1[j] == data) {
                matchFound = true;
            }
        }

        return matchFound;
    }
}
