/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement;

import static com.mycompany.productmanagement.FoodTypeConstants.BREAKFAST;
import static com.mycompany.productmanagement.FoodTypeConstants.DINNER;
import static com.mycompany.productmanagement.FoodTypeConstants.LUNCH;

/**
 *
 * @author Khai
 */
public class Drink extends Product implements DrinkTypeConstants{
    public enum DrinkType{
        SOFTDRINK,
        ANCOHOL
    }
    DrinkType drinkType;
//    public Drink(){
//        super();
//        drinkType = 0;
//    }
    public Drink(String id, String name, String description, double price, DrinkType drinkType){
        super(id, name, description, price);
        this.drinkType = drinkType;
    }
    
    private String getStringDrinkType(){
        switch (drinkType) {
            case SOFTDRINK:
                return "Softdrink";
            case ANCOHOL:
                return "Ancohol";
            default:
                return "";
        }
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + "Type : " + getStringDrinkType();
    }
}

