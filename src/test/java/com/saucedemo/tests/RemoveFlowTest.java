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
    public void addBoltTShirt() {
        page.addBoltTShirt();
        assertTrue(page.isCartBadgeDisplayed());
    }

    @Test(dependsOnMethods = "addBoltTShirt")
    public void removeBackpackOnProductsPage() {
        page.removeBackpack();
        assertTrue(page.isAddBackpackButtonDisplayed());
    }

    @Test(dependsOnMethods = "removeBackpackOnProductsPage")
    public void openCart() {
        page.openCart();
        assertEquals(page.getTitle(), "Your Cart");
    }

    @Test(dependsOnMethods = "openCart")
    public void removeBikeLightInCart() {
        page.removeBikeLight();
        assertFalse(page.isRemoveBikeLightButtonDisplayed());
    }

    @Test(dependsOnMethods = "removeBikeLightInCart")
    public void removeBoltTShirtInCart() {                
        page.removeBoltTShirt();
        assertFalse(page.isRemoveBoltTShirtButtonDisplayed());
    }

    @Test(dependsOnMethods = "removeBoltTShirtInCart")
    public void emptyCartHasNoBadge() {                    
        assertFalse(page.isCartBadgeDisplayed());
    }

    @Test(dependsOnMethods = "emptyCartHasNoBadge")
    public void continueShopping() {
        page.clickContinueShopping();
        assertEquals(page.getTitle(), "Products");
    }

    @Test(dependsOnMethods = "continueShopping")
    public void logout() {
        page.logout();
        assertTrue(page.isLoginButtonDisplayed());
    }

    @Test(dependsOnMethods = "logout")
    public void productsPageBlockedAfterLogout() {        
        page.openProductsPage();
        assertTrue(page.isErrorDisplayed());
    }
}