package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchaseFlowPage extends WorkflowBasepage {

    
    private By usernameField   = By.id("user-name");
    private By passwordField   = By.id("password");
    private By loginButton     = By.id("login-button");
    private By errorMessage    = By.xpath("//h3[@data-test='error']");
    private By pageTitle       = By.xpath("//span[@class='title']");
    private By cartBadge       = By.xpath("//span[@class='shopping_cart_badge']");
    private By cartIcon        = By.xpath("//a[@data-test='shopping-cart-link']");
    private By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By addBikeLightButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By checkoutButton  = By.id("checkout");
    private By firstNameField  = By.id("first-name");
    private By lastNameField   = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton  = By.id("continue");
    private By finishButton    = By.id("finish");
    private By thankYouMessage = By.xpath("//h2[@class='complete-header']");
    private By backHomeButton  = By.id("back-to-products");

    public PurchaseFlowPage(WebDriver driver) {
        super(driver);
    }

 
    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }
    public void fillCheckout(String firstName, String lastName, String postalCode) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(postalCodeField, postalCode);
        click(continueButton);
    }

    public void addBackpack() {
        click(addBackpackButton);
    }

    public void addBikeLight() {
        click(addBikeLightButton);
    }
    public void openCart() {
        click(cartIcon);
    }

    public void clickCheckout() {
        click(checkoutButton);
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