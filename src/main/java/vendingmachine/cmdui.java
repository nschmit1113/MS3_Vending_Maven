package vendingmachine;

import java.util.*;
public class cmdui {
    /*
    * @author Nikolaus Schmitt
    * This class will deal with user interactions through the command line.
    * 
    */

    public static void main(String[] args){
        int sel = 0;
        LoadMachine lm = new LoadMachine();
        Credit cr = new Credit();
        SelectSnacks select = new SelectSnacks(lm, cr);
        Scanner scan;
        String end = "";
        System.out.println("Welcome to the MS3 Vending Machine.");
        System.out.println("Please Make a Selection from the following menu");
        System.out.println("Our current snacks are:");
        System.out.println("***************************************************************");
        lm.printNames();
        System.out.println("***************************************************************\n");
        System.out.println("Please Make a Selection from the following menu");
        while(end != "q" && end != "Q"){
            
            System.out.println("1: View snacks, prices, and amounts of each left");
            System.out.println("2: Insert credit into machine");
            System.out.println("3: View available credit");
            System.out.println("4: Select a snack to purchase");
            System.out.println("5: Load the machine with new inventory");
            System.out.println("6: Leave the machine");
            
            scan = new Scanner(System.in);
            end = scan.nextLine();
            try{
                sel = Integer.parseInt(end);
            }catch(Exception e){
                System.out.println("Please enter a number between 1 and 6 inclusive.");
            }
            

            switch(sel){
                case 1:
                    lm.printAll();
                    break;
                case 2:
                    System.out.println("Please enter your credit now: ");
                    //scan.close();
                    //scan = new Scanner(System.in);
                    String num = scan.nextLine();
                    try{
                        double db = Double.parseDouble(num);
                        cr.addCredit(db);
                        System.out.println("Your credit is now: " + cr.getCredit());
                    }catch(Exception e){
                        System.out.println("Please enter a valid decimal value. (e.g. 0.00)");
                    }
                    break;
                case 3:
                    System.out.println("Your credit is: " + cr.getCredit());
                    break;
                case 4:
                    System.out.println("Please make your selection");
                    lm.printNames();
                    select.getUserIn();
                    break;
                case 5:
                    
                    break;
                case 6: 
                    end = "q";
                    scan.close();
                    System.out.println("Thanks for shopping with us. Have a nice day!");
                default:
                    
            }
            
        }
        
    }

    

}
