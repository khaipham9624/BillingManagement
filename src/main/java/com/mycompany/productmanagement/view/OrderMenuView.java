/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.view;

import com.mycompany.productmanagement.utils.InputUtils;

/**
 *
 * @author Khai
 */
public class OrderMenuView {

    public OrderMenuView() {
    }
    public int getAction(){
        System.out.println("1) Add product to this order");
        System.out.println("2) Show this order");
        int action = InputUtils.getIntFromKeyBoard();
        return action;
    }
    
}
