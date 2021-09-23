package vendingmachine;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class LoadMachineTest {
    
    @Test
    public void testReadInJson(){
        LoadMachine lm = new LoadMachine("../../input.json");
        assertEquals(4, lm.rows());
        assertEquals(8, lm.cols());
    }
}
