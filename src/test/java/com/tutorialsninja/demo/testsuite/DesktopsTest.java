package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.pages.TopMenuPage;
import com.tutorialsninja.demo.testbase.TestBase;
import resources.testdata.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DesktopsTest extends TestBase {
    TopMenuPage topMenuPage;

    DesktopsPage desktopsPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){

        topMenuPage = new TopMenuPage();
        desktopsPage = new DesktopsPage();
        shoppingCartPage = new ShoppingCartPage();
    }
    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder(){
        //1.1 Mouse hover on Desktops Tab. and click
        topMenuPage.hoverAndClickOnDesktopTab();
        //1.2 Click on “Show All Desktops”
        topMenuPage.clickOnShowAllDesktopsLink();
        //1.3 Select Sort By position "Name: Z to A"
        desktopsPage.selectPositionByZtoA();
        //1.4 Verify the Product will arrange in Descending order.
        desktopsPage.verifyProductsInDescendingOrder();
    }
    @Test(groups = {"smoke","regression"}, dataProvider = "DATA SET", dataProviderClass = TestData.class)
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty, String successMessage,
                                                             String productName, String model, String total ){

        //2.1 Mouse hover on Currency Dropdown and click
        topMenuPage.hoverAndClickOnCurrencyLink();
        // 2.2 Mouse hover on £Pound Sterling and click
        topMenuPage.hoverAndClickOnPoundSterling("£Pound Sterling");
        //2.3 Mouse hover on Desktops Tab.
        topMenuPage.hoverAndClickOnDesktopTab();
        //2.4 Click on “Show All Desktops”
        topMenuPage.clickOnShowAllDesktopsLink();
        //2.5 Select Sort By position "Name: A to Z"
        desktopsPage.selectPositionByAtoZ();
        //2.6 Select product <product>
        desktopsPage.selectProductByName(product);
        //2.7 Enter Qty <qty> using Select class.
        desktopsPage.enterProductQuantity(qty);
        //2.8 Click on “Add to Cart” button
        desktopsPage.clickToCartButton();
        //2.9 Verify the Message <successMessage>
        Assert.assertEquals(desktopsPage.getSuccessMessage(), "successMessage", "Error");
        //2.10 Click on link “shopping cart” display into success message
        desktopsPage.clickOnShoppingCarTab();
        //2.11 Verify the text "Shopping Cart"
        Assert.assertTrue(desktopsPage.getTextShoppingCart().contains("Shopping Cart"));
        //2.12 Verify the Product name <productName>
        Assert.assertEquals(shoppingCartPage.verifyProductByName(productName),"productName", "Error");
        //2.13 Verify the Model <model>
        //2.14 Verify the Total <total>

    }







    }

