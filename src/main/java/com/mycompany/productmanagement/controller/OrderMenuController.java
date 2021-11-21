/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.controller;

import com.mycompany.productmanagement.dao.ProductDAO;
import com.mycompany.productmanagement.dao.ProductDAOFactory;
import com.mycompany.productmanagement.view.OrderMenuView;

/**
 *
 * @author Khai
 */
public class OrderMenuController {
    private OrderMenuView view;
    public OrderMenuController(OrderMenuView view) {
        this.view = view;
    }
    
    public int getAction(){
        return view.getAction();
    }
}
