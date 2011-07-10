/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplealgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Ryo Asai
 */
public class TestDataGenerator {
    private int length;
    private int differentValue;

    private List<Integer> dataList;
    private int[] data1;
    private int[] data2;
    
    TestDataGenerator(int length, int differentValue) {
        this.length = length;
        this.differentValue = differentValue;
        
        dataList = new ArrayList<Integer>(length);
    }
    
    public void generate() {
        dataList = new ArrayList<Integer>(length);
        
        for (int i = 0; i < length; i++) {
            dataList.add(i);
        }
        
        Collections.shuffle(dataList);
        data1 = toIntArray(dataList);
        
        // substitute only one element.
        dataList.set(0, differentValue);
 
        Collections.shuffle(dataList);
        data2 = toIntArray(dataList);
    }

    public int[] getData1() {
        return data1;
    }

    public int[] getData2() {
        return data2;
    }
    
    private int[] toIntArray(List<Integer> list) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}
