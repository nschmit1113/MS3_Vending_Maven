package vendingmachine;

import java.io.*;
import java.net.URL;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
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
    private char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private int[] inte = {0,1,2,3,4,5,6,7,8,9,}; 

    public LoadMachine(){
        System.out.println("Here1");
        readInJson("/Users/nikolaus/coding_questions/MS3_Vending_Maven/input.json");
    }

    public LoadMachine(String fileName){
        readInJson(fileName);
    }

    public void readInJson(String fileName){
        JSONParser jP = new JSONParser();
        try {
            System.out.println(fileName);
            JSONObject jO =(JSONObject) jP.parse(new FileReader(fileName));
            //String id = (String) jsonObject.get("ID"); example
            JSONObject obj = (JSONObject)jO.get("config");
            
            cols = Integer.valueOf((String)obj.get("columns"));
            rows = Integer.valueOf(obj.get("rows").toString());

            arr = (JSONArray)jO.get("items");
            
            iV = initArr();
            System.out.println(iV.toString() + "here");

            

        } catch (ParseException e) {
            System.out.println(e);
        }catch(IOException io){
            System.out.println(io);
        }catch(Exception ee){
            System.out.println(ee);
        }
        
    }

    public Inventory initArr(){
        int i = 0; 
        int j = 0;
        Inventory iV = new Inventory(rows, cols);
        
        for(Object ob: arr){
            
            JSONObject o = (JSONObject)ob;
            String name = (String)o.get("name");
            //System.out.println(name);
            int amount = Integer.valueOf(o.get("amount").toString());
            
            String r = o.get("price").toString();
            String x = r.replace("$", "");
            double price = Double.valueOf(x);
            
            Snack sn = new Snack(name, amount, price);
            //System.out.println(sn.checkName());
            iV.add(sn, i, j);
            
            
            
            
            if(j == cols - 1 && i == rows - 1){
                //Most likely this will rarely if ever occur
                System.out.println("The machine is full!");
                return iV;
            }
            
            if(i == rows - 1){
                //System.out.print(iV.peek(i, j).checkName());
                j++;
                i = 0;
                //System.out.println();
            }else{
                //System.out.print(iV.peek(i, j).checkName() + ", ");
                i++;
            }
        }
        
        return iV;
    }

    public int rows(){
        return rows;
    }

    public int cols(){
        return cols;
    }

    public Inventory getIV(){
        return this.iV;
    }

    
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

    public String readInNewFile(){
        System.out.println("Please enter the name of the file (e.g. yourfile.json");
        System.out.println("Only json files will work.");
        Scanner scan = new Scanner(System.in);
        String filename = scan.nextLine();
        URL url = getClass().getResource(filename);
        //File file = new File(url.getPath());
        String file = new String(url.getPath());
        scan.close();
        return file;
    }

    public static void main(String[] args){
        LoadMachine lm = new LoadMachine("/Users/nikolaus/coding_questions/MS3_Vending_Maven/input.json");
        //lm.readInJson("/Users/nikolaus/coding_questions/MS3_Vending_Maven/input.json");
        
        System.out.println(lm.cols);
        System.out.println(lm.rows);
        
    }
}
