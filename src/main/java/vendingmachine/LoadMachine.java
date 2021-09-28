package vendingmachine;

import java.io.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * This class will be responsible for loading the vending machine with the
 * items from the JSON file. 
 */

public class LoadMachine {

    private int rows;
    private int cols;
    JSONArray arr;
    Inventory iV;
    Scanner scan;
    private char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private int[] inte = {0,1,2,3,4,5,6,7,8,9,}; 

    //Initial constructor
    public LoadMachine(Scanner scan){
        this.scan = scan;
        Path path = Paths.get("input.json");
        Path file = path.toAbsolutePath();
        readInJson(file.toString());
    }

    //Constructor for reading in a new input file
    public LoadMachine(String fileName, Scanner scan){
        this.scan = scan;
        readInJson(fileName);
    }

    //This method does the parsing and reading of the json file.
    public void readInJson(String fileName){
        JSONParser jP = new JSONParser();
        try {
            
            JSONObject jO =(JSONObject) jP.parse(new FileReader(fileName));
            
            JSONObject obj = (JSONObject)jO.get("config");
            
            cols = Integer.valueOf((String)obj.get("columns"));
            rows = Integer.valueOf(obj.get("rows").toString());

            arr = (JSONArray)jO.get("items");
            iV = new Inventory(rows, cols);
            iV = initArr();

        } catch (ParseException e) {
            System.out.println(e);
        }catch(IOException io){
            System.out.println(io);
        }catch(Exception ee){
            System.out.println(ee);
        }
        
    }

    //This method is what set up the underlying array to hold and manipulate the array of Snacks.
    public Inventory initArr(){
        int i = 0; 
        int j = 0;
        Inventory iV = new Inventory(rows, cols);
        
        for(Object ob: arr){
            
            JSONObject o = (JSONObject)ob;
            String name = (String)o.get("name");
            
            int amount = Integer.valueOf(o.get("amount").toString());
            
            String r = o.get("price").toString();
            String x = r.replace("$", "");
            double price = Double.valueOf(x);
            //creates a snack object, populates its data, and stores it in the arrays
            Snack sn = new Snack(name, amount, price);
            iV.add(sn, i, j);
            
            //This if/esle deals with indexing items in the array.
            if(j == cols - 1 && i == rows - 1){
                //Most likely this will rarely if ever occur
                System.out.println("The machine is full!");
                return iV;
            }
            if(i == rows - 1){
                j++;
                i = 0;
            }else{
                i++;
            }
        }
        return iV;
    }
    //Method for testings
    public int rows(){
        return rows;
    }
    //Method for testing
    public int cols(){
        return cols;
    }

    //Returns the local copy of the Inventory object for use oustide this class
    public Inventory getIV(){
        return this.iV;
    }

    //Prints all information about the items in the machine.
    public void printAll(){
        boolean breaker = false;
        for(int col = 0; col < cols; col++){
            for(int row = 0; row < rows; row++){
                if(iV.peek(row, col) == null){
                    breaker = true;
                    break;

                }
                System.out.print("{ " + chars[col] + "" + inte[row] + ": ");
                System.out.print("Item: " + iV.peek(row, col).checkName() + ",");
                System.out.print(" Number left: " + iV.peek(row, col).checkAmount() + ",");
                System.out.print(" Price: " + iV.peek(row, col).checkPrice() + "}  ");
            }
            System.out.println();
            if(breaker){
                break;
            }
        }
    }

    //This method returns the names of all the items stored in the vending machine 
    //along with their selection code.
    public void printNames(){
        boolean breaker = false;
        for(int col = 0; col < cols; col++){
            for(int row = 0; row < rows; row++){
                if(iV.peek(row, col) == null){
                    breaker = true;
                    break;
                }
                System.out.print("{ " + chars[col] + "" + inte[row] + ": ");
                System.out.print(iV.peek(row, col).checkName() + "}  ");
            }
            System.out.println();
            if(breaker){
                break;
            }
        }
    }

    //This method takes another file that the user specifies, retrieves the absolute path,
    //and returns that path as a string.
    public String readInNewFile(){
        System.out.println("Please enter the name of the file (e.g. yourfile.json)");
        System.out.println("Only json files will work.");
        
        String filename = scan.nextLine();
        Path path = Paths.get(filename);
        Path file = path.toAbsolutePath();
        
        
        return file.toString();
    }

    
}
