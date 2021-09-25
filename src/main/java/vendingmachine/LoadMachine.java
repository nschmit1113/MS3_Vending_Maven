package vendingmachine;

import java.io.*;
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

    public LoadMachine(){
    }

    public void readInJson(String fileName){
        JSONParser jP = new JSONParser();
        try {
            
            JSONObject jO =(JSONObject) jP.parse(new FileReader(fileName));
            //String id = (String) jsonObject.get("ID"); example
            JSONObject obj = (JSONObject)jO.get("config");
            
            cols = Integer.valueOf((String)obj.get("columns"));
            rows = Integer.valueOf(obj.get("rows").toString());

            arr = (JSONArray)jO.get("items");
           
            iV = initArr();
            
            

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
           
            int amount = Integer.valueOf(o.get("amount").toString());
            
            String r = o.get("price").toString();
            String x = r.replace("$", "");
            double price = Double.valueOf(x);
            
            Snack sn = new Snack(name, amount, price);
            iV.add(sn, i, j);
            
            
            if(j == cols - 1 && i == rows - 1){
                //Most likely this will rarely if ever occur
                System.out.println("The machine is full!");
                return iV;
            }
            
            if(j == cols - 1){
                i++;
                j = 0;
            }else{
                j++;
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

    public static void main(String[] args){
        LoadMachine lm = new LoadMachine();
        lm.readInJson("/Users/nikolaus/coding_questions/MS3_Vending_Maven/input.json");
        System.out.println(lm.cols);
        System.out.println(lm.rows);
    }
}
