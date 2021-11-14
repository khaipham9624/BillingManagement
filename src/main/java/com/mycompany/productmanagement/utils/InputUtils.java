/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.utils;

import java.util.Scanner;

/**
 *
 * @author Khai
 */
public class InputUtils {
    public static Scanner sc = new Scanner(System.in);
    
    public static int getIntFromKeyBoard()
    {
        int input = 0;
        boolean isValid = false;
        while(!isValid)
        {
            if (sc.hasNextInt()){
                input = sc.nextInt();
                isValid = true;
            }
            sc.nextLine();
        }
        return input;
    }
    
    public static double getDoubleFromKeyBoard()
    {
        double input = 0.0;
        boolean isValid = false;
        while(!isValid)
        {
            if (sc.hasNextDouble()){
                input = sc.nextDouble();
                isValid = true;
            }
            sc.nextLine();
        }
        return input;
    }
    
    public static String getStringFromKeyBoard()
    {
        String input = null;
        boolean isValid = false;
        while (!isValid)
        {
            if (sc.hasNext())
            {
                input = sc.next();
                isValid = true;
            }
            sc.nextLine();
        }
        return input;
    }
    
    public static String getLineFromKeyBoard()
    {
        String input = null;
        boolean isValid = false;
        while (!isValid)
        {
            if (sc.hasNextLine())
            {
                input = sc.nextLine();
                isValid = true;
            }
        }
        return input;
    }
}
