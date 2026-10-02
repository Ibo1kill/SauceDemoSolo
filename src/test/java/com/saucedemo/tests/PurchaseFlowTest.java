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


    @Test(dependsOnMethods = "wrongLogin", dataProvider = "wrongLoginData", dataProviderClass = TestData.class)
    public void wrongLogin(String username, String password) {
        page.login(username, password);
        assertTrue(page.isErrorDisplayed());
    }

    @Test(dependsOnMethods = "validLogin" ,dataProvider = "validLoginData", dataProviderClass = TestData.class)
    public void validLogin(String username, String password) {
        page.login(username, password);
        assertEquals(page.getTitle(), "Products");
    }

    @Test(dependsOnMethods = "validLogin")
    public void addBackpack() {
        page.addBackpack();
        assertTrue(page.isCartBadgeDisplayed());
    }

    @Test(dependsOnMethods = "addBackpack")
    public void addBikeLight() {
        page.addBikeLight();
        assertTrue(page.isCartBadgeDisplayed());
    }

    @Test(dependsOnMethods = "addBikeLight")
    public void openCart() {
        page.openCart();
        assertEquals(page.getTitle(), "Your Cart");
    }

    @Test(dependsOnMethods = "openCart")
    public void goToCheckout() {
        page.clickCheckout();
        assertEquals(page.getTitle(), "Checkout: Your Information");
    }

    @Test(dependsOnMethods = "goToCheckout", dataProvider = "wrongCheckoutData", dataProviderClass = TestData.class)
    public void wrongCheckout(String firstName, String lastName, String postalCode) {
        page.fillCheckout(firstName, lastName, postalCode);
        assertTrue(page.isErrorDisplayed());
    }

    @Test(dependsOnMethods = "wrongCheckout", dataProvider = "validCheckoutData", dataProviderClass = TestData.class)
    public void validCheckout(String firstName, String lastName, String postalCode) {
        page.fillCheckout(firstName, lastName, postalCode);
        assertEquals(page.getTitle(), "Checkout: Overview");
    }

    @Test(dependsOnMethods = "validCheckout")
    public void finishOrder() {
        page.clickFinish();
        assertEquals(page.getThankYouMessage(), "Thank you for your order!");
    }

    @Test(dependsOnMethods = "finishOrder")
    public void backHome() {
        page.clickBackHome();
        assertEquals(page.getTitle(), "Products");
    }
}