/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.controller;

import com.mycompany.productmanagement.utils.InputUtils;
import com.mycompany.productmanagement.view.MainView;
import com.mycompany.productmanagement.view.ProductMenuView;

/**
 *
 * @author Khai
 */
public class MainController {
    private MainView view;
    public MainController(MainView view) {
        this.view = view;
    }
    

    public int login(){
        view.showMainView();
        int role = view.getRole();
        return role;
    }
}
