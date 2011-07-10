/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplealgorithm.finder;

import simplealgorithm.finder.HashSetDifferentElementFinder;
import java.util.concurrent.Callable;

/**
 *
 * @author Ryo Asai
 */
public class HashSetDifferentElementFinderTest extends DifferentElementFinderTestSupport {

    @Override
    protected Callable<Integer> createTask(int[] data1, int[] data2, int threadCount) {
        return new HashSetDifferentElementFinder(data1, data2, threadCount);
    }

}
