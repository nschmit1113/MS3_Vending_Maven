package vendingmachine;

import java.util.*;
import java.util.concurrent.TimeUnit;
/*
*@author Nikolaus Schmitt
*This class will deal with selecting the correct snack based off of the input from the 
*user. The number of rows and columns must be passed into the constructor for this 
*class to work.
*/
public class SelectSnacks {
    
    private int sec;
    private int index = 0;
    
    private char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    
    private String str;
    private String[] first;
    private String second;
    private boolean flag = true;
    LoadMachine lm;
    Credit cr;
    Scanner scan2;



    public SelectSnacks(LoadMachine lm1, Credit cr, Scanner scan){
        this.cr = cr;
        this.lm = lm1;
        this.scan2  = scan;
    }

    public void getUserIn(){
       flag = true;
        while(flag){
            try{
                str = scan2.nextLine();
                first = str.split("");
                second = first[0];
                sec = Integer.parseInt(first[1]);
        
                char ch = second.charAt(0);
                for(int i = 0; i < chars.length; i++){
                    if(ch == chars[i]){
                        index = i;
                        break;
                    }
                }
                
                makeSelection();
                flag = false;
                str = new String();
                
            }catch(Exception e){
                System.out.println("Please enter a valid input (e.g. a1)");
                
            }
             
        }
        
    }

    public void makeSelection(){
        
        if(0 == lm.getIV().peek(sec, index).checkAmount()){
            System.out.println("Item out of stock.");
            return;
        }
        
        if(cr.getCredit() > lm.getIV().peek(index, sec).checkPrice()){
            vend();
        }else{
            int us = 0;
            System.out.println("Please add credit to make this purchase.");
            System.out.println("Enter 1 to add credit");
            System.out.println("Enter 2 to cancel the transaction");
            while(us < 1 || us > 2){
                try{
                   us = scan2.nextInt(); 
                }catch(Exception e){
                    System.out.println("Please enter either 1 or 2 then press enter.");
                    System.out.println("Enter 1 to add credit");
                    System.out.println("Enter 2 to cancel the transaction");
                }
            }
            switch(us){
                case 1:
                    
                    while(cr.getCredit() < lm.getIV().peek(index, sec).checkPrice()){
                        
                        System.out.println("Please add credit now: ");
                        String num = scan2.nextLine();
                        try{
                            double db = Double.parseDouble(num);
                            cr.addCredit(db);
                            System.out.println("Your credit is now: " + cr.getCredit());
                            if(cr.getCredit() < lm.getIV().peek(index, sec).checkPrice()){
                                System.out.print("Please add: $");
                                System.out.println(lm.getIV().peek(index, sec).checkPrice() - cr.getCredit() 
                                            + " additional dollars");
                            }
                        }catch(Exception e){
                            System.out.println("Please enter a valid decimal value. (e.g. 0.00)");
                        }   
                    }
                    
                    vend();
                    break;
                case 2:
                System.out.println("Cancelling your transaction");
                    return;

            }
        }
    }

    public void vend(){
        System.out.println("Vending in progress...");
        
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Please take you item: " + lm.getIV().peek(sec, index).checkName());
        cr.subtractCredit(lm.getIV().peek(sec, index).checkPrice());
        System.out.println("Your available balance is: " + cr.getCredit().toString() + "\n\n");
        System.out.println(lm.getIV().peek(sec, index).checkAmount());
        lm.getIV().peek(sec, index).decAmount();
        
        
        
    }

    

}
