/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
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

public class ProductDAOFile implements ProductDAO{
    private final String ProductFileName = "product.dat";
    private List<Product> ProductList = null;
    private boolean isReadProductFromFile = false;
    
    public ProductDAOFile(){
        ProductList = new ArrayList<Product>();
    }
    
    private boolean readProductFromFileToList(String fileName){
//        Product p = null;
        FileInputStream fis = null;
        ObjectInputStream ios = null;
        try {
            fis = new FileInputStream(fileName);
            ios = new ObjectInputStream(fis);
            ProductList = (ArrayList<Product>)ios.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ios != null)
                try {
                    ios.close();
            } catch (IOException ex) {
                Logger.getLogger(ProductDAOFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (fis != null)
                try {
                    fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ProductDAOFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        isReadProductFromFile = true;
        return true;
    }

    private boolean writeProductListToFile(String fileName){
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(ProductList);
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
    public Product getProduct(String productId) {
        Product p = null;
        if (!isReadProductFromFile && !readProductFromFileToList(ProductFileName))
        {
            // do nothing
        }
        else
        {
            for (Product i : ProductList){
                if (i.getId().equals(productId))
                    p = i;
            }
        }
        return p;
    }

    @Override
    public String getProductsString() {
        if (!isReadProductFromFile && !readProductFromFileToList(ProductFileName))
            return "";
        StringBuilder allProductString = new StringBuilder("");
        for (Product i : ProductList){
            allProductString.append(i.toString());
        }
        return allProductString.toString();
    }

    @Override
    public boolean addProduct(Product p) {
        for (Product i : ProductList){
            if (i.getId().equals(p.getId()))
                return false;
        }
        ProductList.add(p);
        if (!writeProductListToFile(ProductFileName))
            ProductList.remove(p);
        return true;
    }

    @Override
    public boolean updateProduct(Product p) {
        for (int i = 0; i < ProductList.size(); i++){
            if (ProductList.get(i).getId().equals(p.getId()))
            {
                Product temp = ProductList.get(i);
                ProductList.set(i, p);
                if (!writeProductListToFile(ProductFileName))
                {
                    ProductList.set(i, temp);
                    return false;
                }    
            }
        }
        return true;
    }

    @Override
    public boolean deleteProduct(Product p) {
        if (ProductList.remove(p) && !writeProductListToFile(ProductFileName))
        {
            ProductList.add(p);
            return false;
        }
        return true;
    }
}
