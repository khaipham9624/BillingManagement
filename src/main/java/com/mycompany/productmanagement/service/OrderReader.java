/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.service;

import com.mycompany.productmanagement.model.Order;

/**
 *
 * @author Khai
 */
public interface OrderReader {
    Order getOrder(String Id);
    String getOrdersString();
}
