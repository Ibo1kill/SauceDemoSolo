package com.saucedemo.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

 
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    protected WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
   
    protected void type (By locator, String text ) {
    	WebElement element = waitVisible (locator);
    	element.clear();
    	element.sendKeys(text);
    }
    protected String getText(By locator) {
    	return waitVisible(locator).getText();

    }
    protected boolean isDisplayed(By locator) {
    	List<WebElement> elements = driver.findElements(locator);
    	return !elements.isEmpty()&& elements.get(0).isDisplayed();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}