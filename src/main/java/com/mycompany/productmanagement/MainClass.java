/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement;

import com.mycompany.productmanagement.controller.MainController;
import com.mycompany.productmanagement.controller.OrderController;
import com.mycompany.productmanagement.controller.OrderMenuController;
import com.mycompany.productmanagement.controller.ProductMenuController;
import com.mycompany.productmanagement.controller.ProductController;
import com.mycompany.productmanagement.model.Food;
import com.mycompany.productmanagement.model.Drink;
import com.mycompany.productmanagement.dao.ProductDAOFactory;
import com.mycompany.productmanagement.dao.ProductDAO;
import com.mycompany.productmanagement.model.Order;
import com.mycompany.productmanagement.model.Product;
import com.mycompany.productmanagement.utils.InputUtils;
import com.mycompany.productmanagement.view.MainView;
import com.mycompany.productmanagement.view.OrderMenuView;
import com.mycompany.productmanagement.view.OrderView;
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

                while (true)
                {
                    boolean isStop = false;
                    int action = productMenuController.getAction();
                    ProductView productView = new ProductView();
                    ProductController productController = new ProductController(productView);
                    switch (action){
                        case 1:
                            productController.showAllProducts();
                            break;
                        case 2:
                            productController.addProduct();
                            break;
                        case 3:
                            productController.updateProduct();
                            break;
                        case 4:
                            productController.deleteProduct();
                            break;
                        default:
                            isStop = true;
                            break;
                    }
                    if (isStop)
                        break;
                }
                break;
            case 2:
                OrderMenuView orderMenuView = new OrderMenuView();
                OrderMenuController orderMenuController = new OrderMenuController(orderMenuView);
                Order order = new Order();

                while (true)
                {
                    boolean isStop = false;

                    int action = orderMenuController.getAction();
                    OrderView orderView = new OrderView();
                    OrderController orderController = new OrderController(orderView);
                    switch (action){
                        case 1:
                            orderController.addOrder(order);
                            break;
                        case 2:
                            orderController.showOrder(order);
                            break;
                        default:
                            isStop = true;
                            break;
                    }
                    if (isStop)
                        break;
                }
                break;
        }
    }
}