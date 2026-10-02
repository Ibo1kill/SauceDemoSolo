package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RemoveFlowPage extends WorkflowBasepage {

  
    private By usernameField          = By.id("user-name");
    private By passwordField          = By.id("password");
    private By loginButton            = By.id("login-button");
    private By errorMessage    = By.xpath("//h3[@data-test='error']");
    private By pageTitle       = By.xpath("//span[@class='title']");
    private By cartBadge       = By.xpath("//span[@class='shopping_cart_badge']");
    private By cartIcon        = By.xpath("//a[@data-test='shopping-cart-link']");
    private By continueShoppingButton = By.id("continue-shopping");
    private By menuButton             = By.id("react-burger-menu-btn");
    private By logoutLink             = By.id("logout_sidebar_link");
    private By addBackpackButton      = By.id("add-to-cart-sauce-labs-backpack");
    private By addBikeLightButton     = By.id("add-to-cart-sauce-labs-bike-light");
    private By addBoltTShirtButton    = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By removeBackpackButton   = By.id("remove-sauce-labs-backpack");
    private By removeBikeLightButton  = By.id("remove-sauce-labs-bike-light");
    private By removeBoltTShirtButton = By.id("remove-sauce-labs-bolt-t-shirt");

    public RemoveFlowPage(WebDriver driver) {
        super(driver);
    }

   
    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }
    public void addBackpack()      { click(addBackpackButton); }
    public void addBikeLight()     { click(addBikeLightButton); }
    public void addBoltTShirt()    { click(addBoltTShirtButton); }

    public void removeBackpack()   { click(removeBackpackButton); }
    public void removeBikeLight()  { click(removeBikeLightButton); }
    public void removeBoltTShirt() { click(removeBoltTShirtButton); }
   

    public void openCart() {
        click(cartIcon);
    }

    public void clickContinueShopping() {
        click(continueShoppingButton);
    }

    public void logout() {
        click(menuButton);
        click(logoutLink);
    }

    public void openProductsPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

  
    public String getTitle() {
        return getText(pageTitle);
    }

    public boolean isCartBadgeDisplayed() {
        return isDisplayed(cartBadge);
    }

    public boolean isAddBackpackButtonDisplayed() {
        return waitVisible(addBackpackButton).isDisplayed();
    }

    public boolean isRemoveBikeLightButtonDisplayed() {
        return isDisplayed(removeBikeLightButton);
    }

    public boolean isRemoveBoltTShirtButtonDisplayed() {
        return isDisplayed(removeBoltTShirtButton);
    }
    public boolean isLoginButtonDisplayed() {
        return waitVisible(loginButton).isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return waitVisible(errorMessage).isDisplayed();
    }
}