package vendingmachine;
import org.apache.commons.math3.util.Precision;
/*
*@author Nikolaus Schmitt
*This class deals with displaying the machines available credit, adding to
*the credit, and subtracting from that credit whenever a purchase is made. 
*The credit can never go below 0.0. 
*/

public class Credit {
    
    private double credit = 0.00;

    public Credit(){

    }

    //Returns avaialbe credit
    public Double getCredit(){
        return this.credit;
    }

    public void addCredit(double db){
        db = db + credit;
        credit = Precision.round(db, 2);
    }

    public void subtractCredit(double db){
        if(db > credit){
            throw new IllegalArgumentException("Not Enough Credit");
        }
        db = credit - db;
        credit = Precision.round(db, 2);
    }

}
