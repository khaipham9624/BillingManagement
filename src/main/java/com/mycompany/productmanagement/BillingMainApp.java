/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement;

import com.mycompany.productmanagement.model.Order;
import com.mycompany.productmanagement.dao.OrderDAOFactory;
import com.mycompany.productmanagement.model.Bill;
import com.mycompany.productmanagement.dao.OrderDAO;

/**
 *
 * @author Khai
 */
public class BillingMainApp {
    private static OrderDAO orderDAO = null;
    
    public static void main(String[] args) {
        orderDAO = OrderDAOFactory.getOrderDAO();
        Order o = new Order("1");
        o.add("2", 2);
        o.add("1", 1);
        o.add("4", 1);
        orderDAO.addOrder(o);
        
        Order order = orderDAO.getOrder("1");
        Bill b = new Bill("1", order);
        System.out.println(b.toString());
        b.exportToCSV("bill.csv");
    }
}
