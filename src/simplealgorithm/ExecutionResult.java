/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplealgorithm;

/**
 *
 * @author Ryo Asai
 */
public class ExecutionResult {
    private final long timeTakenForNestedLoop;
    private final long timeTakenForBinarySearch;
    private final long timeTakenForHashSet;
    
    private final int threadCount;
    private final int dataSize;

    public ExecutionResult(int threadCount, int dataSize, long timeTakenForNestedLoop, long timeTakenForBinarySearch, long timeTakenForHashSet) {
        this.timeTakenForNestedLoop = timeTakenForNestedLoop;
        this.timeTakenForBinarySearch = timeTakenForBinarySearch;
        this.timeTakenForHashSet = timeTakenForHashSet;
        this.threadCount = threadCount;
        this.dataSize = dataSize;
    }

    public int getDataSize() {
        return dataSize;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public long getTimeTakenForBinarySearch() {
        return timeTakenForBinarySearch;
    }

    public long getTimeTakenForHashSet() {
        return timeTakenForHashSet;
    }

    public long getTimeTakenForNestedLoop() {
        return timeTakenForNestedLoop;
    }

    @Override
    public String toString() {
        return  "threadCount=" + threadCount + ", elementSize=" + dataSize + "timeTakenForNestedLoop=" + timeTakenForNestedLoop + ", timeTakenForBinarySearch=" + timeTakenForBinarySearch + ", timeTakenForHashSet=" + timeTakenForHashSet + ", threadCount=" + threadCount + ", dataSize=" + dataSize;
    }
    
}
