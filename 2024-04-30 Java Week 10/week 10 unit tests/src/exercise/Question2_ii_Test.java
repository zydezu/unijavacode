package exercise;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Question2_ii_Test {
    
    @Test
    /**
     * Test that the function returns the correct value for the simple case 
     * where the value of a segment of a rod is equal to its length. 
     * Note also, that the tested values are the same as for question 2.i.
     */
    public void testSimpleCase(){
        Map<Integer,Integer> prices = new HashMap<>();
        for(int i=1; i < 9; i++){
            prices.put(i, i);
        }
        assertTrue(Question2.rodCutting(prices, 5) == 5);       
    }

}