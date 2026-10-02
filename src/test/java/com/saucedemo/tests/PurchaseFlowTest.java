package com.saucedemo.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saucedemo.pages.PurchaseFlowPage;


public class PurchaseFlowTest extends WorkflowBaseTest {

    PurchaseFlowPage page;

    @BeforeClass
    public void createPage() {
        page = new PurchaseFlowPage(driver);
    }


    @Test(priority = 1, dataProvider = "wrongLoginData", dataProviderClass = TestData.class)
    public void wrongLogin(String username, String password) {
        page.login(username, password);
        assertTrue(page.isErrorDisplayed());
    }

    @Test(priority = 2, dataProvider = "validLoginData", dataProviderClass = TestData.class)
    public void validLogin(String username, String password) {
        page.login(username, password);
        assertEquals(page.getTitle(), "Products");
    }

    @Test(priority = 3)
    public void addBackpack() {
        page.addBackpack();
        assertTrue(page.isCartBadgeDisplayed());
    }

    @Test(priority = 4)
    public void addBikeLight() {
        page.addBikeLight();
        assertTrue(page.isCartBadgeDisplayed());
    }

    @Test(priority = 5)
    public void openCart() {
        page.openCart();
        assertEquals(page.getTitle(), "Your Cart");
    }

    @Test(priority = 6)
    public void goToCheckout() {
        page.clickCheckout();
        assertEquals(page.getTitle(), "Checkout: Your Information");
    }

    @Test(priority = 7, dataProvider = "wrongCheckoutData", dataProviderClass = TestData.class)
    public void wrongCheckout(String firstName, String lastName, String postalCode) {
        page.fillCheckout(firstName, lastName, postalCode);
        assertTrue(page.isErrorDisplayed());
    }

    @Test(priority = 8, dataProvider = "validCheckoutData", dataProviderClass = TestData.class)
    public void validCheckout(String firstName, String lastName, String postalCode) {
        page.fillCheckout(firstName, lastName, postalCode);
        assertEquals(page.getTitle(), "Checkout: Overview");
    }

    @Test(priority = 9)
    public void finishOrder() {
        page.clickFinish();
        assertEquals(page.getThankYouMessage(), "Thank you for your order!");
    }

    @Test(priority = 10)
    public void backHome() {
        page.clickBackHome();
        assertEquals(page.getTitle(), "Products");
    }
}