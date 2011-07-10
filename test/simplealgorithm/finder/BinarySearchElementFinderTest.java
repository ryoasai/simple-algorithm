/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplealgorithm.finder;

import simplealgorithm.finder.BinarySearchDifferentElementFinder;
import java.util.concurrent.Callable;

/**
 *
 * @author Ryo Asai
 */
public class BinarySearchElementFinderTest extends DifferentElementFinderTestSupport {

    @Override
    protected Callable<Integer> createTask(int[] data1, int[] data2, int threadCount) {
        return new BinarySearchDifferentElementFinder(data1, data2, threadCount);
    }

}
