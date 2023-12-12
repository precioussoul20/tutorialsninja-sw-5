package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2")
    WebElement laptopsAndNotebooksText;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectSortBy;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement productMacBook;
    @CacheLookup
    @FindBy(xpath = "(//h1)[2]")
    WebElement macBookText;
    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addCart;
    @CacheLookup
    @FindBy(css = ".alert.alert-success.alert-dismissible")
    WebElement textSuccess;
    @CacheLookup
    @FindBy(linkText = "shopping cart")
    WebElement shoppingCartTab;


    public String verifyTextFromLaptopsAndNotebooks() {
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public void clickOnSortByDropDown() {
        clickOnElement(selectSortBy);
    }

    public void selectPriceHighToLowFromDropdown() {
        selectByVisibleTextFromDropDown(selectSortBy, "Price (High > Low)");

    }

    public void verifyProductsByPriceHighToLow() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        //sort by Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        // After filter Price (High > Low) Get all the products price and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        Assert.assertEquals(originalProductsPrice, afterSortByPrice, "Product not sorted by price High to Low");
    }
    public void selectProductMacBook() {
        clickOnElement(productMacBook);
    }
    public String getTextFromMacBook(){
        return getTextFromElement(macBookText);
    }
    public void clickOnAddCartButton(){
        clickOnElement(addCart);
    }
    public String getTextSuccess(){
        return getTextFromElement(textSuccess);
    }
    public void clickOnShoppingCarTab(){
        clickOnElement(shoppingCartTab);
    }


}
