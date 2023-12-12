package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.pages.TopMenuPage;
import com.tutorialsninja.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksTest extends TestBase {

    TopMenuPage topMenuPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        topMenuPage = new TopMenuPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        shoppingCartPage = new ShoppingCartPage();
    }
    @Test(groups = {"sanity","smoke", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        topMenuPage.hoverAndClickOnLaptopsAndNotebooksTab();
        //1.2 Click on “Show All Laptops & Notebooks”
        topMenuPage.clickOnShowALLLaptopsAndNotebooksLink();
        //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.clickOnSortByDropDown();
        laptopsAndNotebooksPage.selectPriceHighToLowFromDropdown();
        //1.4 Verify the Product price will arrange in High to Low order.
        laptopsAndNotebooksPage.verifyProductsByPriceHighToLow();
    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatUserPlaceOrderSuccessfully(){
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        topMenuPage.hoverAndClickOnLaptopsAndNotebooksTab();
        //2.2 Click on “Show All Laptops & Notebooks”
        topMenuPage.clickOnShowALLLaptopsAndNotebooksLink();
        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.clickOnSortByDropDown();
        laptopsAndNotebooksPage.selectPriceHighToLowFromDropdown();
        //2.4 Select Product “MacBook”
        laptopsAndNotebooksPage.selectProductMacBook();
        //2.5 Verify the text “MacBook”
        Assert.assertEquals(laptopsAndNotebooksPage.getTextFromMacBook(), "MacBook","Error Message");
        //2.6 Click on ‘Add To Cart’ button
        laptopsAndNotebooksPage.clickOnAddCartButton();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertTrue(laptopsAndNotebooksPage.getTextSuccess().contains("Success: You have added MacBook to your shopping cart!"),"Error");
        //2.8 Click on link “shopping cart” display into success message
        laptopsAndNotebooksPage.clickOnAddCartButton();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertTrue(shoppingCartPage.getTextShoppingCart().contains("Shopping Cart"), "Error");
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(shoppingCartPage.getTextFromMacBook(), "MacBook","Error Message");
        //2.11 Change Quantity "2"
        shoppingCartPage.changeQuantity();
        // 2.12 Click on “Update” Tab
        shoppingCartPage.clickOnUpdateTab();
        // 2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertEquals(shoppingCartPage.getSuccessTextMessage(),"Success: You have modified your shopping cart!","Error");
        //2.14 Verify the Total £737.45
        Assert.assertEquals(shoppingCartPage.getTextTotal(),"£737.45", "Error");
        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckOutTab();
        //2.16 Verify the text “Checkout”
        Assert.assertEquals(shoppingCartPage.getTextCheckOut(),"Checkout", "Error");
        //2.17 Verify the Text “New Customer”
        Assert.assertEquals(shoppingCartPage.getTextNewCustomer(),"New Customer", "Error");
        //2.18 Click on “Guest Checkout” radio button
        shoppingCartPage.clickOnRadioButton();
        //2.19 Click on “Continue” tab
        shoppingCartPage.clickOnContinueButton();
        //2.20 Fill the mandatory fields
        shoppingCartPage.fillInMandatoryFields();
        //2.21 Click on “Continue” Button
        shoppingCartPage.clickOnContinueButton1();
        //2.22 Add Comments About your order into text area
        shoppingCartPage.addCommentsAboutOrder();
        //2.23 Check the Terms & Conditions check box
        shoppingCartPage.clickOnTermsAndConditionCheckbox();
        //2.24 Click on “Continue” button
        shoppingCartPage.clickOnContinueButton2();
        // 2.25 Verify the message “Warning: Payment method required!”
        Assert.assertTrue(shoppingCartPage.getTextWarningMessage().contains("Warning: Payment method required!"),"Error");
    }
}


