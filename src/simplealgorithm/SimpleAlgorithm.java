/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplealgorithm;

import simplealgorithm.finder.HashSetDifferentElementFinder;
import simplealgorithm.finder.NestedLoopDifferentElementFinder;
import simplealgorithm.finder.DifferentElementFinder;
import simplealgorithm.finder.BinarySearchDifferentElementFinder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ryo Asai
 */
public class SimpleAlgorithm {

    private List<ExecutionResult> resultList = new ArrayList<ExecutionResult>();
    
    public void run() {
        for (int threadCount = 1; threadCount <= 10; threadCount++) {
            for (int i = 0; i < 10; i++) {
                resultList.add(doExecute(10, threadCount));
                resultList.add(doExecute(100, threadCount));
                resultList.add(doExecute(1000, threadCount));
                resultList.add(doExecute(10000, threadCount));
                resultList.add(doExecute(100000, threadCount));
            }
        }
    }

    private ExecutionResult doExecute(int dataSize, int threadCount) {

        System.out.println("==========================================");
        System.out.println("dataSize = " + dataSize + ", " + "threadCount = " + threadCount);

        TestDataGenerator testDataGenerator = new TestDataGenerator(dataSize, -1);
        testDataGenerator.generate();

        int[] data1 = testDataGenerator.getData1();
        int[] data2 = testDataGenerator.getData2();

        try {
            DifferentElementFinder nestedLoopFinder = new NestedLoopDifferentElementFinder(data1, data2, threadCount);
            DifferentElementFinder binSearchFinder = new BinarySearchDifferentElementFinder(data1, data2, threadCount);
            DifferentElementFinder hashSetFinder = new HashSetDifferentElementFinder(data1, data2, threadCount);

            System.out.println("result(nested loop) = " + nestedLoopFinder.call());
            System.out.println("result(bin search) = " + binSearchFinder.call());
            System.out.println("result(hash set) = " + hashSetFinder.call());

            System.out.println("time take in ms(nested loop) = " + nestedLoopFinder.getTimeTakenInMillSecond());
            System.out.println("time take in ms(bin search) = " + binSearchFinder.getTimeTakenInMillSecond());
            System.out.println("time take in ms(hash set) = " + hashSetFinder.getTimeTakenInMillSecond());

            return new ExecutionResult(threadCount, dataSize, nestedLoopFinder.getTimeTakenInMillSecond(), binSearchFinder.getTimeTakenInMillSecond(), hashSetFinder.getTimeTakenInMillSecond());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        new SimpleAlgorithm().run();
    }
}
