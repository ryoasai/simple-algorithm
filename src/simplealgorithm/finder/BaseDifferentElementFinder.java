/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplealgorithm.finder;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Ryo Asai
 */
public abstract class BaseDifferentElementFinder implements DifferentElementFinder {

    protected final int[] data1;
    protected final int[] data2;
    protected int threadCount = 1;
    protected long start, end;
    
    public BaseDifferentElementFinder(int[] data1, int[] data2) {
        this(data1, data2, 1);
    }

    public BaseDifferentElementFinder(int[] data1, int[] data2, int threadCount) {
        if (data1 == null || data2 == null) {
            throw new NullPointerException();
        }

        if (data1.length != data2.length) {
            throw new IllegalArgumentException();
        }

        if (threadCount <= 0) {
            throw new IllegalArgumentException();
        }

        this.data1 = data1;
        this.data2 = data2;

        this.threadCount = threadCount;
    }

    @Override
    public long getTimeTakenInNano() {
        return end - start;
    }
    
    @Override
    public long getTimeTakenInMillSecond() {
        return getTimeTakenInNano() / 1000;
    }
        
    @Override
    public Integer call() throws Exception {
        init();
        start = System.nanoTime();
        
        assert threadCount >= 1;

        if (threadCount == 1) {
            Integer result = doFindDifferentElement(0, data2.length);
            end = System.nanoTime();
            
            return result;
        } else {

            ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
            CompletionService completionService = new ExecutorCompletionService<Integer>(
                    executorService);

            try {
                // Submit divided subtasks.
                
                final int fragmentLen = data2.length / threadCount;
                for (int i = 0; i < threadCount - 1; i++) {
                    completionService.submit(new SubTask(i * fragmentLen, fragmentLen));
                }

                int remain = data2.length % threadCount;
                completionService.submit(new SubTask((threadCount - 1) * fragmentLen, remain == 0 ? fragmentLen : remain));

                // Take calculated results if any.
                
                for (int i = 0; i < threadCount; i++) {
                    Future<Integer> result = completionService.take();
                    if (result.get() != null) {
                        return result.get();
                    }
                }

                return null;
            } finally {
                end = System.nanoTime();

                executorService.shutdownNow();
            }
        }
    }

    class SubTask implements Callable<Integer> {

        private int offset;
        private int length;

        public SubTask(int offset, int length) {
            this.offset = offset;
            this.length = length;
        }

        @Override
        public Integer call() throws Exception {
            return doFindDifferentElement(offset, length);
        }
    }

    protected void init() {
    }

    protected Integer doFindDifferentElement(int offset, int length) {
        // Find a different element with hash set.
        for (int i = offset; i < offset + length; i++) {
            if (!matchFound(data2[i])) {
                return data2[i];
            }
        }

        return null;
    }

    protected abstract boolean matchFound(int data);
}
