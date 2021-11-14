/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.service;

import com.mycompany.productmanagement.model.Product;
import com.mycompany.productmanagement.model.Product;

/**
 *
 * @author Khai
 */
public interface ProductWriter {
    boolean addProduct(Product p);
    boolean updateProduct(Product p);
    boolean deleteProduct(Product p);
}
