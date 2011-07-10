/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplealgorithm;

import java.util.List;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Ryo Asai
 */
public class TestDataGeneratorTest {
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generate method, of class TestDataGenerator.
     */
    @Test
    public void testGenerate() {
        final int LENGTH = 5;
        
        TestDataGenerator instance = new TestDataGenerator(LENGTH, 100);
        instance.generate();
        int[] data1 = instance.getData1();
        int[] data2 = instance.getData2();

        List<Integer> data1List = new ArrayList<Integer>();
        List<Integer> data2List = new ArrayList<Integer>();

        for (int i = 0; i < LENGTH; i++) {
            data1List.add(data1[i]);
            data2List.add(data2[i]);
        }
        
        System.out.println(data1List);
        System.out.println(data2List);

        assertThat(data1List.size(), is(LENGTH));
        assertThat(data2List.size(), is(LENGTH));

        assertThat(data1List.contains(100), is(false));
        assertThat(data2List.contains(100), is(true));
    }

}
