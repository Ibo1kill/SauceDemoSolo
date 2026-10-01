package com.saucedemo.tests;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saucedemo.pages.LoginPage;

public class LoginTests extends BaseTest {

    @DataProvider(name = "loginTestData")
    public Object[][] loginTestData(Method test) {
        Object[][] data = {
           
            { "standard_user",   "secret_sauce" },  
           
            { "standard_user",   "wrong_pass" },     
            { "locked_out_user", "secret_sauce" },  
            { "STANDARD_USER",   "secret_sauce" },   
            { "",                "" },              
            { "standard_user",   "SECRET_SAUCE" }   
        };
        return new Object[][] { data[test.getAnnotation(Test.class).priority() - 1] };
    }

    @Test(priority = 1, dataProvider = "loginTestData",
          description = "TC01 - Happy: standard_user logs in")
    public void validLoginStandardUser(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        assertTrue(loginPage.getCurrentUrl().contains("inventory.html"));
    }

  

    @Test(priority = 2, dataProvider = "loginTestData",
          description = "TC03 - Negative: wrong password")
    public void wrongPassword(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }

    @Test(priority = 3, dataProvider = "loginTestData",
          description = "TC04 - Negative: locked out user")
    public void lockedOutUser(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        assertTrue(loginPage.getErrorMessage().contains("Sorry, this user has been locked out"));
    }

    @Test(priority = 4, dataProvider = "loginTestData",
          description = "TC05 - Edge: username in capitals")
    public void usernameInCapitals(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }

    @Test(priority = 5, dataProvider = "loginTestData",
          description = "TC06 - Edge: both fields empty")
    public void emptyFields(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        assertTrue(loginPage.getErrorMessage().contains("Username is required"));
    }

    @Test(priority = 6, dataProvider = "loginTestData",
          description = "TC07 - Edge: password in capitals")
    public void passwordInCapitals(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }
}