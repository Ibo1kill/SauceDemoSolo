package com.saucedemo.tests;

import org.testng.annotations.DataProvider;


public class TestData {

    

    @DataProvider(name = "validLoginData")
    public static Object[][] validLoginData() {
        return new Object[][] {
            { "standard_user", "secret_sauce" }      
        };
    }

    @DataProvider(name = "wrongLoginData")
    public static Object[][] wrongLoginData() {
        return new Object[][] {
            { "standard_user",   "wrong_pass" },     
            { "locked_out_user", "secret_sauce" },   
            { "",                "" }                
        };
    }

    

    @DataProvider(name = "purchaseProducts")
    public static Object[][] purchaseProducts() {
        return new Object[][] {
            { "sauce-labs-backpack" },               
            { "sauce-labs-bike-light" }              
        };
    }

    @DataProvider(name = "removeProducts")
    public static Object[][] removeProducts() {
        return new Object[][] {
            { "sauce-labs-backpack" },               
            { "sauce-labs-bike-light" },             
            { "sauce-labs-bolt-t-shirt" }            
        };
    }

    @DataProvider(name = "removeOnProductsPage")
    public static Object[][] removeOnProductsPage() {
        return new Object[][] {
            { "sauce-labs-backpack" }                
        };
    }

    @DataProvider(name = "removeInCart")
    public static Object[][] removeInCart() {
        return new Object[][] {
            { "sauce-labs-bike-light" },             
            { "sauce-labs-bolt-t-shirt" }           
        };
    }

    

    @DataProvider(name = "validCheckoutData")
    public static Object[][] validCheckoutData() {
        return new Object[][] {
            { "Test", "User", "10115" }              
        };
    }

    @DataProvider(name = "wrongCheckoutData")
    public static Object[][] wrongCheckoutData() {
        return new Object[][] {
            { "",     "",     "" },                 
            { "Test", "User", "" }                   
        };
    }
}