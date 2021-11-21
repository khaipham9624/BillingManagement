package com.mycompany.productmanagement.view;

import com.mycompany.productmanagement.model.Drink;
import com.mycompany.productmanagement.model.Drink.DrinkType;
import com.mycompany.productmanagement.model.Food;
import com.mycompany.productmanagement.model.Food.FoodType;
import com.mycompany.productmanagement.model.Product;
import com.mycompany.productmanagement.utils.InputUtils;
import jdk.jshell.execution.Util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khai
 */
public class ProductView {
    public ProductView()
    {
    }
    
    public void showProducts(String allProducts)
    {
        System.out.println(allProducts);
    }
    
    public Product getInputProduct()
    {
        Product product = null;

        System.out.println("Input Product ID:");
        String productId = InputUtils.getStringFromKeyBoard();
        System.out.println("Input Product Name");
        String productName = InputUtils.getLineFromKeyBoard();
        System.out.println("Input Product Description");
        String productDescription = InputUtils.getLineFromKeyBoard();
        System.out.println("Input Product Price");
        double price = InputUtils.getDoubleFromKeyBoard();
        System.out.println("Input type of product:");
        System.out.println("1) Food");
        System.out.println("2) Drink");
        int type = InputUtils.getIntFromKeyBoard();
        switch (type)
        {
            case 1: 
                System.out.println("Input Food type");
                System.out.println(FoodType.BREAKFAST.ordinal()+1 + ") " + FoodType.BREAKFAST.toString());
                System.out.println(FoodType.LUNCH.ordinal()+1 + ") " + FoodType.LUNCH.toString());
                System.out.println(FoodType.DINNER.ordinal()+1 + ") " + FoodType.DINNER.toString());
                int foodType = InputUtils.getIntFromKeyBoard();
                Food.FoodType ft;
                switch (foodType)
                {
                    case 1:
                        ft = FoodType.BREAKFAST;
                        break;
                    case 2:
                        ft = FoodType.LUNCH;
                        break;
                    case 3:
                        ft = FoodType.DINNER;
                        break;
                    default:
                        ft = FoodType.BREAKFAST;
                }
                product = new Food(productId, productName, productDescription, price, ft);
                break;
            case 2: 
                System.out.println("Input Food type");
                System.out.println(DrinkType.SOFTDRINK.ordinal()+1 + ") " + DrinkType.SOFTDRINK.toString());
                System.out.println(DrinkType.ANCOHOL.ordinal()+1 + ") " + DrinkType.ANCOHOL.toString());
                int drinkType = InputUtils.getIntFromKeyBoard();
                DrinkType dt;
                switch (drinkType)
                {
                    case 1:
                        dt = DrinkType.SOFTDRINK;
                        break;
                    case 2:
                        dt = DrinkType.ANCOHOL;
                        break;
                    default:
                        dt = DrinkType.SOFTDRINK;
                }
                product = new Drink(productId, productName, productDescription, price, dt);
                break;
        }
        return product;
    }
    
    public String getInputProductId()
    {
        System.out.println("Input Product ID to delete");
        String id = InputUtils.getStringFromKeyBoard();
        return id;
    }
}
