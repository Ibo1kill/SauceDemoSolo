package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RemoveFlowPage extends BasePage {

  
    private By usernameField          = By.id("user-name");
    private By passwordField          = By.id("password");
    private By loginButton            = By.id("login-button");
    private By errorMessage           = By.cssSelector("[data-test='error']");
    private By pageTitle              = By.cssSelector("[data-test='title']");
    private By cartBadge              = By.cssSelector("[data-test='shopping-cart-badge']");
    private By cartIcon               = By.cssSelector("[data-test='shopping-cart-link']");
    private By continueShoppingButton = By.id("continue-shopping");
    private By menuButton             = By.id("react-burger-menu-btn");
    private By logoutLink             = By.id("logout_sidebar_link");

    public RemoveFlowPage(WebDriver driver) {
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

    public void removeFromCart(String product) {
        click(By.id("remove-" + product));
    }

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

    public boolean isAddButtonDisplayed(String product) {
        return waitVisible(By.id("add-to-cart-" + product)).isDisplayed();
    }

    public boolean isRemoveButtonDisplayed(String product) {
        return isDisplayed(By.id("remove-" + product));
    }

    public boolean isLoginButtonDisplayed() {
        return waitVisible(loginButton).isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return waitVisible(errorMessage).isDisplayed();
    }
}