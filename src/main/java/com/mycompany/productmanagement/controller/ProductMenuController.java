/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.controller;

import com.mycompany.productmanagement.utils.InputUtils;
import com.mycompany.productmanagement.view.ProductMenuView;

/**
 *
 * @author Khai
 */
public class ProductMenuController {
    private ProductMenuView view;
    
    public ProductMenuController(ProductMenuView view){
        this.view = view;
    }
    
    public int getAction(){
        view.showActionMenu();
        int action = InputUtils.getIntFromKeyBoard();
        return action;
    }
}
