/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement;

/**
 *
 * @author Khai
 */
public interface ProductReader {
    Product getProduct(String productId);
    String getProductsString();
}
