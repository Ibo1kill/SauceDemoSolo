package com.saucedemo.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saucedemo.pages.RemoveFlowPage;

public class RemoveFlowTest extends WorkflowBaseTest {

    RemoveFlowPage page;

    @BeforeClass
    public void createPage() {
        page = new RemoveFlowPage(driver);
    }

    @Test(priority = 1, dataProvider = "validLoginData", dataProviderClass = TestData.class)
    public void validLogin(String username, String password) {
        page.login(username, password);
        assertEquals(page.getTitle(), "Products");
    }

    @Test(priority = 2, dataProvider = "removeProducts", dataProviderClass = TestData.class)
    public void addToCart(String product) {
        page.addToCart(product);
        assertTrue(page.isCartBadgeDisplayed());
    }

    @Test(priority = 3, dataProvider = "removeOnProductsPage", dataProviderClass = TestData.class)
    public void removeOnProductsPage(String product) {
        page.removeFromCart(product);
        assertTrue(page.isAddButtonDisplayed(product));
    }

    @Test(priority = 4)
    public void openCart() {
        page.openCart();
        assertEquals(page.getTitle(), "Your Cart");
    }

    @Test(priority = 5, dataProvider = "removeInCart", dataProviderClass = TestData.class)
    public void removeInCart(String product) {
        page.removeFromCart(product);
        assertFalse(page.isRemoveButtonDisplayed(product));
    }

    @Test(priority = 6)
    public void emptyCartHasNoBadge() {                     
        assertFalse(page.isCartBadgeDisplayed());
    }

    @Test(priority = 7)
    public void continueShopping() {
        page.clickContinueShopping();
        assertEquals(page.getTitle(), "Products");
    }

    @Test(priority = 8)
    public void logout() {
        page.logout();
        assertTrue(page.isLoginButtonDisplayed());
    }

    @Test(priority = 9)
    public void productsPageBlockedAfterLogout() {         
        page.openProductsPage();
        assertTrue(page.isErrorDisplayed());
    }
}