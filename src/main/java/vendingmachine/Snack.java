package vendingmachine;
/*
 *@Author: Nikolaus Schmitt
 *This class holds the information for a single item in the vending machine.
 *@Throws IllegalStateException in two methods.
 */

public class Snack {
    
    private int amount = 0;
    private double price = 0.0;
    private String name = "";

    public Snack(String name, int amount, double price){
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public void decAmount(){
        if(this.amount < 0){
            throw new IllegalStateException("Amount is invalid");
        }
        this.amount--;
    }

    public void addAmount(){
        this.amount++;
    }

    public void changePrice(double newPrice){
        if(newPrice < 0){
            throw new IllegalStateException("Entered price in invalid");
        }
        this.price = newPrice;
    }

    public void changeName(String newName){
        this.name = newName;
    }

    public int checkAmount(){
        return this.amount;
    }

    public double checkPrice(){
        return this.price;
    }

    public String checkName(){
        return this.name;
    }

    @Override
    public String toString(){
        String str = new String();
        str = name + ", " + amount + ", $" + price;
        return str;
    }
}
