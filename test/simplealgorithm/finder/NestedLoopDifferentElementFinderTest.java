/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplealgorithm.finder;

import simplealgorithm.finder.NestedLoopDifferentElementFinder;
import java.util.concurrent.Callable;

/**
 *
 * @author Ryo Asai
 */
public class NestedLoopDifferentElementFinderTest extends DifferentElementFinderTestSupport {

    @Override
    protected Callable<Integer> createTask(int[] data1, int[] data2, int threadCount) {
        return new NestedLoopDifferentElementFinder(data1, data2, threadCount);
    }

}
