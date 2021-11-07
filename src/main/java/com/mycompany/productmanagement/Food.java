/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement;

/**
 *
 * @author Khai
 */
public class Food extends Product{
    public enum FoodType{
        BREAKFAST,
        LUNCH,
        DINNER;
        
        public String toString(){
            if (this.ordinal() == 0)
                return "Breakfast";
            else if (this.ordinal() == 1)
                return "Lunch";
            else if (this.ordinal() == 2)
                return "Dinner";
            else
                return "";
        }
    }
    private FoodType foodType;
//    public Food(){
//        super();
//        FoodType = 0;
//    }
    
    public Food(String id, String name, String description, double price, FoodType foodType){
        super(id, name, description, price);
        this.foodType = foodType;
    }
    
    private String getStringFoodType(){
        switch (foodType) {
            case BREAKFAST:
                return "Breakfast";
            case LUNCH:
                return "Lunch";
            case DINNER:
                return "Dinner";
            default:
                return "";
        }
    }
    public String toString(){
        return super.toString() + "\n" + "Type : " + getStringFoodType();
    }
}
