/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.controller;

import com.mycompany.productmanagement.dao.OrderDAO;
import com.mycompany.productmanagement.dao.OrderDAOFactory;
import com.mycompany.productmanagement.model.Order;
import com.mycompany.productmanagement.dao.ProductDAO;
import com.mycompany.productmanagement.dao.ProductDAOFactory;
import com.mycompany.productmanagement.view.OrderView;

/**
 *
 * @author Khai
 */
public class OrderController {
    private static OrderDAO orderDAO = null;
    private static ProductDAO productDAO = null;
    private OrderView view;

    public OrderController(OrderView view) {
        this.view = view;
        orderDAO = OrderDAOFactory.getOrderDAO();
        productDAO = ProductDAOFactory.getProductDAOFile();
    }
    
    public boolean addOrder(Order order){ 
        view.getInputOrder(productDAO.getProductsString(), order);
//        order = view.getInputOrder(productDAO.getProductsString());
        return orderDAO.addOrder(order);
    }
    
    public void showOrder(Order order){
        view.showOrder(order);
    }
}
