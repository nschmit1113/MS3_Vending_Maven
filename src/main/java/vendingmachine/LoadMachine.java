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

    public LoadMachine(){
       
    }

    public void readInJson(String fileName){
        JSONParser jP = new JSONParser();
        try {
            
            JSONObject jO =(JSONObject) jP.parse(new FileReader("C:\\Users\\schmi\\Coding_Problems\\vending\\input.json"));
            //String id = (String) jsonObject.get("ID"); example
            JSONObject obj = (JSONObject)jO.get("config");
            
            cols = Integer.valueOf((String)obj.get("columns"));
            rows = Integer.valueOf(obj.get("rows").toString());

            JSONArray arr = (JSONArray)jO.get("items");

            

        } catch (ParseException e) {
            System.out.println(e);
        }catch(IOException io){
            System.out.println(io);
        }catch(Exception ee){
            System.out.println(ee);
        }
        
    }

    public int rows(){
        return rows;
    }

    public int cols(){
        return cols;
    }

    public static void main(String[] args){
        LoadMachine lm = new LoadMachine();
        lm.readInJson("./input.json");
        System.out.println(lm.cols);
        System.out.println(lm.rows);
    }
}
