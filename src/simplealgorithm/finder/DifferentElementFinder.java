/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplealgorithm.finder;

import java.util.concurrent.Callable;

/**
 *
 * @author Ryo Asai
 */
public interface DifferentElementFinder extends Callable<Integer> {
    long getTimeTakenInNano();
    
    long getTimeTakenInMillSecond();
}
