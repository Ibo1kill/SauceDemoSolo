package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchaseFlowPage extends WorkflowBasepage {

    
    private By usernameField   = By.id("user-name");
    private By passwordField   = By.id("password");
    private By loginButton     = By.id("login-button");
    private By errorMessage    = By.cssSelector("[data-test='error']");
    private By pageTitle       = By.cssSelector("[data-test='title']");
    private By cartBadge       = By.cssSelector("[data-test='shopping-cart-badge']");
    private By cartIcon        = By.cssSelector("[data-test='shopping-cart-link']");
    private By checkoutButton  = By.id("checkout");
    private By firstNameField  = By.id("first-name");
    private By lastNameField   = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton  = By.id("continue");
    private By finishButton    = By.id("finish");
    private By thankYouMessage = By.cssSelector("[data-test='complete-header']");
    private By backHomeButton  = By.id("back-to-products");

    public PurchaseFlowPage(WebDriver driver) {
        super(driver);
    }

 
    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }

    public void addToCart(String product) {
        click(By.id("add-to-cart-" + product));
    }

    public void openCart() {
        click(cartIcon);
    }

    public void clickCheckout() {
        click(checkoutButton);
    }

    public void fillCheckout(String firstName, String lastName, String postalCode) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(postalCodeField, postalCode);
        click(continueButton);
    }

    public void clickFinish() {
        click(finishButton);
    }

    public void clickBackHome() {
        click(backHomeButton);
    }

 
    public String getTitle() {
        return getText(pageTitle);
    }

    public boolean isErrorDisplayed() {
        return waitVisible(errorMessage).isDisplayed();
    }

    public boolean isCartBadgeDisplayed() {
        return isDisplayed(cartBadge);
    }

    public String getThankYouMessage() {
        return getText(thankYouMessage);
    }
}