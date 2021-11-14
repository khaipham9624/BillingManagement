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
public class MainView {

    public MainView() {
    }
    
    public void showMainView(){
        System.out.println("Choose your role:");
        System.out.println("1) Admin");
        System.out.println("2) Guest");
    }
    
    public int getRole(){
        int role = InputUtils.getIntFromKeyBoard();
        return role;
    }
}
