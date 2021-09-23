package vendingmachine;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
/**
 * This class will be responsible for loading the vending machine with the
 * items from the JSON file. 
 */

public class LoadMachine {

    private int rows;
    private int cols;

    public LoadMachine(String fileName){
        System.out.println(fileName);
        readInJson(fileName);
    }

    public void readInJson(String fileName){
        JSONParser jP = new JSONParser();
        try {
            System.out.println(fileName);
            Object ob = (Object) jP.parse(new FileReader(fileName));
            System.out.println("Here1");
            JSONObject jsonObject = (JSONObject) ob;
            System.out.println(jsonObject.toJSONString());
            //String id = (String) jsonObject.get("ID"); example
            JSONObject obj = (JSONObject)jsonObject.get("config");
            System.out.println(ob);
            rows = (int)obj.get("rows");
            cols = (int)obj.get("columns");

        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }

    public int rows(){
        return rows;
    }

    public int cols(){
        return cols;
    }

    public static void main(String[] args){
        LoadMachine lm = new LoadMachine("input.json");
        System.out.println(lm.cols);
        System.out.println(lm.rows);
    }
}
