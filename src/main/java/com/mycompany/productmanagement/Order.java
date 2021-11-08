/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Khai
 */
public class Order implements Serializable{
    private static ProductDAO productDAO = null;
    private String Id;
    private Map<String, Integer> order = null;
    private double totalPrice = 0;
    public Order(String Id){
        this.Id = Id;
        order = new HashMap<>();
        productDAO = ProductDAOFactory.getProductDAOFile();
    }
    
    public String getId(){
        return Id;
    }
    
    public boolean add(String productId, int quantity){
        Product p = null;
        if ((p = productDAO.getProduct(productId)) != null)
        {
            Integer value = order.get(productId);
            if (value == null)
                order.put(productId, quantity);
            else
                order.put(productId, value + quantity);
            return true;
        }
        else
            return false;
    }
    
    public void set(String productId, int quantity){
        order.put(productId, quantity);
    }
    
//    protected Map<String, Integer> getOrderList(){
//        return order;
//    }
    
    protected double getTotalPrice(){
        totalPrice = 0;
        for (Map.Entry item : order.entrySet())
        {
            totalPrice += productDAO.getProduct(item.getKey().toString()).getPrice() * (int)item.getValue();
        }
        return totalPrice;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Product,Unit Price, Quantity, Price");
        
        for (Map.Entry item : order.entrySet())
        {
            double unitPrice = productDAO.getProduct(item.getKey().toString()).getPrice();
            int quantity = (int)item.getValue();
            str.append("\n");
            str.append(productDAO.getProduct(item.getKey().toString()).getName());
            str.append(", ");
            str.append(unitPrice);
            str.append(", ");
            str.append(quantity);
            str.append(", ");
            str.append(unitPrice * quantity);
        }
        return str.toString();
    }

//    @Override
//    public Product getProduct(String productId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String getProductsString() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
