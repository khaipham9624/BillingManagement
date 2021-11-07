/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement;

import java.util.Map;

/**
 *
 * @author Khai
 */
public class Bill {
    private static OrderDAO orderDAO = null;

    public static void main(String[] args) {
        orderDAO = OrderDAOFactory.getOrderDAO();
        Order o = new Order("1");
        boolean add = o.add("2", 2);
        System.out.println(add);
        orderDAO.addOrder(o);
        Order order = orderDAO.getOrder("1");
        System.out.println(order.toString());
    }
//
//    private String Id;
//    private Date orderedTime;
//    private double totalPrice;
//
//    public Bill(String Id) {
////        super(Id);
//        orderedTime = new Date();
//        for (Map.Entry item : super.getOrder().entrySet())
//        {
//            totalPrice += (int)item.getValue() * ((Product)item.getKey()).getPrice();
//        }
//    }
//    
//    public double getTotalPrice(){
//        return totalPrice;
//    }
    
}
