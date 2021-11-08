/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement;

/**
 *
 * @author Khai
 */
public class MainClass {
    private static ProductDAO productDAO = null;
    public static void main(String[] args) {
        productDAO = ProductDAOFactory.getProductDAOFile();
        Product product = new Drink("1", "Ruou vang", "Ruou vang Phap", 10, Drink.DrinkType.ANCOHOL);
        Product product2 = new Food("2", "Com chien", "Com chien Duong Chau", 5, Food.FoodType.DINNER);
        Product product3 = new Food("3", "Com hai san", "Com chien hai san", 15, Food.FoodType.DINNER);
        productDAO.addProduct(product);
        productDAO.addProduct(product2);
        productDAO.addProduct(product3);
        System.out.println(productDAO.getProductsString());
        product.setPrice(15);
        productDAO.updateProduct(product);
        productDAO.deleteProduct(product2);
        System.out.println(productDAO.getProductsString());
        System.out.println("-----------");
    }
}
