/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.controller;

import com.mycompany.productmanagement.dao.ProductDAO;
import com.mycompany.productmanagement.dao.ProductDAOFactory;
import com.mycompany.productmanagement.model.Product;
import com.mycompany.productmanagement.utils.InputUtils;
import com.mycompany.productmanagement.view.ProductView;

/**
 *
 * @author Khai
 */
public class ProductController {
    private static ProductDAO productDAO = null;
    private ProductView view;

    public ProductController(ProductView view) {
        this.view = view;
        productDAO = ProductDAOFactory.getProductDAOFile();
    }
    
    public void showAllProducts()
    {
        String allProduct = productDAO.getProductsString();
        view.showProducts(allProduct);
    }
    
    public boolean addProduct(){
        Product product = null;
        product = view.getInputProduct();
        return productDAO.addProduct(product);
    }
}
