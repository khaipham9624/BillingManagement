/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.dao;

import com.mycompany.productmanagement.model.Order;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khai
 */
public class OrderDAOFile implements OrderDAO{
    private final String OrderFileName = "order.dat";
    private List<Order> OrderList = null;
    private boolean isReadOrderFromFile = false;

    public OrderDAOFile() {
        OrderList = new ArrayList<>();
    }
    
    private boolean readOrderFromFileToList(String fileName){
        Order o = null;
        FileInputStream fis = null;
        ObjectInputStream ios = null;
            try {
                fis = new FileInputStream(fileName);
                ios = new ObjectInputStream(fis);
                OrderList = (ArrayList<Order>)ios.readObject();
            } catch (Exception e) {
                return false;
            } finally
            {
                if (ios != null){
                    try {
                        ios.close();
                    } catch (IOException ex) {
                        Logger.getLogger(OrderDAOFile.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (fis != null)
                {
                    try {
                        fis.close();
                    } catch (IOException ex) {
                        Logger.getLogger(OrderDAOFile.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        isReadOrderFromFile = true;
        return true;
    }
    
    private boolean writeOrderListToFile(String fileName){
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(OrderList);
        } catch (IOException ex) {
            Logger.getLogger(ProductDAOFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  finally{
            if (oos != null)
                try {
                    oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ProductDAOFile.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            if (bos != null)
                try {
                    bos.close();
            } catch (IOException ex) {
                Logger.getLogger(ProductDAOFile.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            if (fos != null)
                try {
                    fos.close();
            } catch (IOException ex) {
                Logger.getLogger(ProductDAOFile.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
    
    @Override
    public Order getOrder(String Id) {
        if (!isReadOrderFromFile)
            readOrderFromFileToList(OrderFileName);
        for (Order i : OrderList){
            if (i.getId().equals(Id))
                return i;
        }
        return null;
    }

    @Override
    public String getOrdersString() {
        if (!isReadOrderFromFile && !readOrderFromFileToList(OrderFileName))
            return "";
        StringBuilder allProductString = new StringBuilder("");
        for (Order i : OrderList){
            allProductString.append(i.toString());
        }
        return allProductString.toString();
    }

    @Override
    public boolean addOrder(Order o) {
        for (Order i : OrderList){
            if (i.getId().equals(o.getId()))
                return false;
        }
        OrderList.add(o);
        if (!writeOrderListToFile(OrderFileName))
            OrderList.remove(o);
        return true;
    }

    @Override
    public boolean updateOrder(Order o) {
        for (int i = 0; i < OrderList.size(); i++){
            if (OrderList.get(i).getId().equals(o.getId()))
            {
                Order temp = OrderList.get(i);
                OrderList.set(i, o);
                if (!writeOrderListToFile(OrderFileName))
                {
                    OrderList.set(i, temp);
                    return false;
                }    
            }
        }
        return true;
    }

    @Override
    public boolean deleteOrder(Order o) {
        if (OrderList.remove(o) && !writeOrderListToFile(OrderFileName))
        {
            OrderList.add(o);
            return false;
        }
        return true;
    }
}
