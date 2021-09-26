package vendingmachine;


import static org.junit.Assert.assertEquals;
import org.junit.*;

public class CreditTest {
    Credit cr = new Credit();
    @Test
    public void testAdd(){
        double add = 2.0;
        cr.addCredit(add);
        assert(add == cr.getCredit()); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void subCredit(){
        double cred = 1.50;
        cr.subtractCredit(cred);
    }

    @Test
    public void subCreditGood(){
        cr.addCredit(3.25);
        cr.subtractCredit(1.75);
        assert(cr.getCredit() == 1.50);
    }
}
