/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.view;

import com.mycompany.productmanagement.utils.InputUtils;
import java.util.Scanner;

/**
 *
 * @author Khai
 */
public class ProductMenuView {
    public ProductMenuView(){
    }
    
    public void showActionMenu()
    {
        System.out.println("Choose an option:");
        System.out.println("1) Show products");
        System.out.println("2) Add a product");
        System.out.println("3) Update a product");
        System.out.println("4) Delete a product");
    }
    
    public int getAction(){
        int action = InputUtils.getIntFromKeyBoard();
        return action;
    }
}
