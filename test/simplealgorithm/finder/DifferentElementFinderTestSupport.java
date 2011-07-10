/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplealgorithm.finder;

import java.util.concurrent.Callable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author Ryo Asai
 */
public abstract class DifferentElementFinderTestSupport {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of call method, of class NestedLoopDifferentElementFinder.
     */
    @Test
    public void call_matchFound() throws Exception {
        int[] data1 = {1, 2, 3};
        int[] data2 = {3, 4, 1};
        Callable<Integer> target = createTask(data1, data2);

        assertThat(target.call(), is(4));
    }

        
    @Test
    public void call_matchFound_MuiltiThreaded_SameThreadsAsElements() throws Exception {
        int[] data1 = {1, 2, 3};
        int[] data2 = {3, 4, 1};
        Callable<Integer> target = createTask(data1, data2, 3);

        assertThat(target.call(), is(4));
    }

    @Test
    public void call_matchFound_MuiltiThreaded_FewerThreadsThanElements() throws Exception {
        int[] data1 = {1, 2, 3};
        int[] data2 = {3, 4, 1};
        Callable<Integer> target = createTask(data1, data2, 2);

        assertThat(target.call(), is(4));
    }

    @Test
    public void call_matchFound_MuiltiThreaded_MoreThreadsThanElements() throws Exception {
        int[] data1 = {1, 2, 3};
        int[] data2 = {3, 4, 1};
        Callable<Integer> target = createTask(data1, data2, 4);

        assertThat(target.call(), is(4));
    }
        
    protected abstract Callable<Integer> createTask(int[] data1, int[] data2, int threadCount);

    protected Callable<Integer> createTask(int[] data1, int[] data2) {
        return createTask(data1, data2, 1);
    }
    
    @Test
    public void call_notFound() throws Exception {
        int[] data1 = {1, 2, 3};
        int[] data2 = {2, 3, 1};

        Callable<Integer> target = createTask(data1, data2);

        assertThat(target.call(), is(nullValue()));
    }
    
    @Test
    public void call_matchFound_MuitlThread() throws Exception {
        int[] data1 = {1, 2, 3};
        int[] data2 = {2, 3, 1};
        Callable<Integer> target = createTask(data1, data2, 2);

        assertThat(target.call(), is(nullValue()));
    }    

    @Test
    public void call_empty() throws Exception {
        int[] data1 = {};
        int[] data2 = {};

        Callable<Integer> target = createTask(data1, data2);

        assertThat(target.call(), is(nullValue()));
    }    
    

    @Test(expected = IllegalArgumentException.class)
    public void lengthNotMatched() throws Exception {
        int[] data1 = {1, 2, 3};
        int[] data2 = {1, 2};

        Callable<Integer> target = createTask(data1, data2);
    }

    @Test(expected = NullPointerException.class)
    public void nullFirstArgument() throws Exception {
        int[] data1 = null;
        int[] data2 = {1, 2};

       Callable<Integer> target = createTask(data1, data2);
    }

    @Test(expected = NullPointerException.class)
    public void nullSecondArgument() throws Exception {
        int[] data1 = {1, 2};
        int[] data2 = null;

        Callable<Integer> target = createTask(data1, data2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void invalidThreadCount() throws Exception {
        int[] data1 = {1, 2, 3};
        int[] data2 = {1, 2};

        Callable<Integer> target = createTask(data1, data2, 0);
    }    
}
