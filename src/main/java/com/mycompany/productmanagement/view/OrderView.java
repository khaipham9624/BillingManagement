/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.view;

import com.mycompany.productmanagement.model.Order;
import com.mycompany.productmanagement.utils.InputUtils;

/**
 *
 * @author Khai
 */
public class OrderView {

    public OrderView() {
    }
    
    public Order getInputOrder(String productsString, Order order){
        System.out.println(productsString);
        while(true){
            boolean submitted = false;
            System.out.println("1) Add a product to order");
            System.out.println("2) Submit");
            int action = InputUtils.getIntFromKeyBoard();
            switch (action){
                case 1:
                    System.out.println("Choose a product ID");
                    String id = InputUtils.getStringFromKeyBoard();
                    System.out.println("Input quantity");
                    int n = InputUtils.getIntFromKeyBoard();
                    order.add(id, n);
                case 2:
                default:
                    submitted = true;
            }
            if (submitted)
                break;
        }

        return order;
    }
    
    public void showOrder(Order order){
        if (order == null)
            System.out.println("There is nothing in your order ¯\\_( ͡° ͜ʖ ͡°)_/¯");
        else
            System.out.println(order.toString());
    }
}
