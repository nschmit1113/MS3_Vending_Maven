package vendingmachine;

public class cmdui {
    /*
    * @author Nikolaus Schmitt
    * This class will deal with user interactions through the command line.
    * 
    */

    public cmdui(){

    }

    public static void main(String[] args){
        int sel = 0;
        LoadMachine lm = new LoadMachine();
        String end = "";
        while(end != "q" || end != "Q"){
            System.out.println("Welcome to the MS3 Vending Machine.");
            System.out.println("Please Make a Selection from the following menu");
            System.out.println("Our current snacks are:");
            System.out.println("***************************************************************");
            lm.printInventory();
            System.out.println("***************************************************************");
            switch(sel){
                case 1:
                    //Make a selection from the snack menu
            }
            
        }
    }

}
