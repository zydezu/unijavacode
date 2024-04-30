package exercise;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Question2_i_Test {
    
    @Test
    /**
     * Test that the function returns the correct value for the simple case 
     * where the value of a segment of a rod is equal to its length. 
     */
    public void testSimpleCase(){
        assertTrue(Question2.rodCutting(new int[]{1,2,3,4,5,6,7,8}, 5) == 5);       
    }

}