package vendingmachine;

import java.util.*;
/*
*@author Nikolaus Schmitt
*This class will deal with selecting the correct snack based off of the input from the 
*user. The number of rows and columns must be passed into the constructor for this 
*class to work.
*/
public class SelectSnacks {
    private int rows;
    private int cols;
    private char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private int[] inte = {0,1,2,3,4,5,6,7,8,9,}; 
    public SelectSnacks(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
    }

    public void getUserIn(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please make your selection");
    }

}
