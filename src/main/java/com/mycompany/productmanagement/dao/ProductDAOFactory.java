/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.dao;

import com.mycompany.productmanagement.dao.ProductDAO;

/**
 *
 * @author Khai
 */
public class ProductDAOFactory {
    public static ProductDAO getProductDAOFile(){
        ProductDAO p = new ProductDAOFile();
        return p;
    }
}
