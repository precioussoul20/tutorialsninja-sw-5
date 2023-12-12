package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DesktopsPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2")
    WebElement deskTopsText;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByPosition;
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    WebElement allProductList;

    @CacheLookup
    @FindBy(linkText = "HTC Touch HD")
    WebElement htcTouch;

    @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement quantity;

    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successText;

    @CacheLookup
    @FindBy(linkText = "shopping cart")
    WebElement shoppingCartTab;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement textShoppingCart;

    public String verifyTextFromDesktops() {
        return getTextFromElement(deskTopsText);
    }

    public void clickOnSortByDropDown() {
        clickOnElement(sortByPosition);
    }
    public void selectPositionByZtoA() {
        selectByVisibleTextFromDropDown(sortByPosition, "Name (Z - A)");
    }
    public void selectPositionByAtoZ() {
        selectByVisibleTextFromDropDown(sortByPosition, "Name (A - Z)");
    }
    public void verifyProductsInDescendingOrder(){
        //Get all the products name and stored into array list
        List<WebElement> products = (List<WebElement>) allProductList;
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        //Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = (List<WebElement>) allProductList;
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        Assert.assertEquals(originalProductsName,afterSortByZToAProductsName,"Error in sorting");

    }
    public void selectProductByName(String productName){
        clickOnElement(By.linkText(productName));
    }
    public void enterProductQuantity(String productQuantity){
        sendTextToElement(quantity, productQuantity);

    }
    public void clickToCartButton(){
        clickOnElement(addToCart);
    }
    public String getSuccessMessage(){
        return getTextFromElement(successText);
    }
    public void clickOnShoppingCarTab(){
        clickOnElement(shoppingCartTab);
    }
    public String getTextShoppingCart(){
        return getTextFromElement(textShoppingCart);
    }


    }






