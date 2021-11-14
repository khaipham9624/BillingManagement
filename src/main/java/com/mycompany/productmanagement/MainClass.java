/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement;

import com.mycompany.productmanagement.controller.MainController;
import com.mycompany.productmanagement.controller.ProductMenuController;
import com.mycompany.productmanagement.controller.ProductController;
import com.mycompany.productmanagement.model.Food;
import com.mycompany.productmanagement.model.Drink;
import com.mycompany.productmanagement.dao.ProductDAOFactory;
import com.mycompany.productmanagement.dao.ProductDAO;
import com.mycompany.productmanagement.model.Product;
import com.mycompany.productmanagement.utils.InputUtils;
import com.mycompany.productmanagement.view.MainView;
import com.mycompany.productmanagement.view.ProductMenuView;
import com.mycompany.productmanagement.view.ProductView;
import java.util.Scanner;

/**
 *
 * @author Khai
 */
public class MainClass {
//    private static ProductDAO productDAO = null;
    
    public static void main(String[] args) {
        MainView mainView = new MainView();
        MainController mainController = new MainController(mainView);
        int role = mainController.login();
        switch (role){
            case 1:
                ProductMenuView productMenuView = new ProductMenuView();
                ProductMenuController productMenuController = new ProductMenuController(productMenuView);

                ProductView productView = new ProductView();
                ProductController productController = new ProductController(productView);
                while (true)
                {
                    int action = productMenuController.getAction();
                    switch (action){
                        case 1:
                            productController.showAllProducts();
                            break;
                        case 2:
                            productController.addProduct();
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            break;
                    }
                }
        }
//        productDAO = ProductDAOFactory.getProductDAOFile();
//        Product product = new Drink("1", "Ruou vang", "Ruou vang Phap", 10, Drink.DrinkType.ANCOHOL);
//        Product product2 = new Food("2", "Com chien", "Com chien Duong Chau", 5, Food.FoodType.DINNER);
//        Product product3 = new Food("3", "Com hai san", "Com chien hai san", 15, Food.FoodType.DINNER);
//        productDAO.addProduct(product);
//        productDAO.addProduct(product2);
//        productDAO.addProduct(product3);
//        System.out.println(productDAO.getProductsString());
//        product.setPrice(15);
//        productDAO.updateProduct(product);
//        productDAO.deleteProduct(product2);
//        System.out.println(productDAO.getProductsString());
//        System.out.println("-----------");
    }
}
