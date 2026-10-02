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


    @Test(priority = 2)
    public void addBackpack() {
        page.addBackpack();
        assertTrue(page.isCartBadgeDisplayed());
    }

    @Test(priority = 3)
    public void addBikeLight() {
        page.addBikeLight();
        assertTrue(page.isCartBadgeDisplayed());
    }

    @Test(priority = 4)
    public void addBoltTShirt() {
        page.addBoltTShirt();
        assertTrue(page.isCartBadgeDisplayed());
    }

    @Test(priority = 5)
    public void removeBackpackOnProductsPage() {
        page.removeBackpack();
        assertTrue(page.isAddBackpackButtonDisplayed());
    }

    @Test(priority = 6)
    public void openCart() {
        page.openCart();
        assertEquals(page.getTitle(), "Your Cart");
    }

    @Test(priority = 7)
    public void removeBikeLightInCart() {
        page.removeBikeLight();
        assertFalse(page.isRemoveBikeLightButtonDisplayed());
    }

    @Test(priority = 8)
    public void removeBoltTShirtInCart() {                
        page.removeBoltTShirt();
        assertFalse(page.isRemoveBoltTShirtButtonDisplayed());
    }

    @Test(priority = 9)
    public void emptyCartHasNoBadge() {                    
        assertFalse(page.isCartBadgeDisplayed());
    }

    @Test(priority = 10)
    public void continueShopping() {
        page.clickContinueShopping();
        assertEquals(page.getTitle(), "Products");
    }

    @Test(priority = 11)
    public void logout() {
        page.logout();
        assertTrue(page.isLoginButtonDisplayed());
    }

    @Test(priority = 12)
    public void productsPageBlockedAfterLogout() {        
        page.openProductsPage();
        assertTrue(page.isErrorDisplayed());
    }
}