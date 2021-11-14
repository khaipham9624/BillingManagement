/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.dao;

import com.mycompany.productmanagement.dao.OrderDAO;
import com.mycompany.productmanagement.dao.OrderDAOFile;

/**
 *
 * @author Khai
 */
public class OrderDAOFactory {
    public static OrderDAO getOrderDAO(){
        OrderDAO orderDAO = new OrderDAOFile();
        return orderDAO;
    }
}
