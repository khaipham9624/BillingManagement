/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement;

import java.io.Serializable;

/**
 *
 * @author Khai
 */

public abstract class Product implements Serializable{
    private String id;
    private String name;
    private String description;
    private double price;

//    public Product() {
//        id          = "No id";
//        name        = "No name";
//        description = "No description";
//        price       = 0;
//    }
    
    public Product(String id, String name, String description, double price)
    {
        this.id             = id;
        this.name           = name;
        this.description    = description;
        this.price          = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString(){
        return  "\n" + 
                "ID : " + id + "\n" +
                "Name : " + name + "\n" +
                "Description : " + description + "\n" +
                "Price : " + price;
    }
}

