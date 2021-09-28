package vendingmachine;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.*;

public class LoadMachineTest {
    
    @Test
    public void testReadInJson(){
        Scanner scan = new Scanner("");
        LoadMachine lm = new LoadMachine(scan);
        assertEquals(4, lm.rows());
        assertEquals(8, lm.cols());
    }
}
