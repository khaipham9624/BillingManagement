/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khai
 */
public class Bill{
//
    private String Id;
    private Date orderedTime;
    private double totalPrice;
    private Order order;
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
    
    public Bill(String Id, Order order) {
        this.Id = Id;
        orderedTime = new Date();
        this.order = order;
        totalPrice = 0;
    }

    public boolean exportToCSV(String fileName){
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fos = new FileOutputStream(fileName);
            bos = new BufferedOutputStream(fos);
            byte[] b = toString().getBytes();
            bos.write(b);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (bos != null)
                try {
                    bos.close();
            } catch (IOException ex) {
                Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (fos != null)
                try {
                    fos.close();
            } catch (IOException ex) {
                Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(order.toString());
        str.append("\n");
        str.append(",");
        str.append(",");
        str.append(",");
        str.append(order.getTotalPrice());
        return str.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
