package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement textShoppingCart;
    @CacheLookup
    @FindBy(xpath = "(//h1)[2]")
    WebElement macBookText;
    @CacheLookup
    @FindBy(name = "quantity[90342]")
    WebElement quantityField;

    @CacheLookup
    @FindBy(css = "div.input-group.btn-block>input")
    WebElement quantity;
    @CacheLookup
    @FindBy(css = ".fa.fa-refresh")
    WebElement updateTab;
    @CacheLookup
    @FindBy(css = ".alert.alert-success.alert-dismissible")
    WebElement successMessage;
    @CacheLookup
    @FindBy(css = "#content > div.row > div > table > tbody > tr:nth-child(4) > td:nth-child(2)")
    WebElement total;
    @CacheLookup
    @FindBy(css = "a.btn.btn-primary")
    WebElement checkOut;
    @CacheLookup
    @FindBy(xpath = "//h1[text()='Checkout']")
    WebElement textCheckOut;
    @CacheLookup
    @FindBy(xpath = "//h2[text()='New Customer']")
    WebElement textNewCustomer;
    @CacheLookup
    @FindBy(css = "input[value='guest']")
    WebElement radioButton;
    @CacheLookup
    @FindBy(css = "#button-account")
    WebElement continueButton;
    @CacheLookup
    @FindBy(css = "#input-payment-firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(css = "#input-payment-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(css = "#input-payment-email")
    WebElement email;
    @CacheLookup
    @FindBy(css = "#input-payment-telephone")
    WebElement telephone;
    @CacheLookup
    @FindBy(css = "#input-payment-address-1")
    WebElement address;
    @CacheLookup
    @FindBy(css = "#input-payment-city")
    WebElement city;
    @CacheLookup
    @FindBy(css = "#input-payment-postcode")
    WebElement postcode;
    @CacheLookup
    @FindBy(css = "#input-payment-zone")
    WebElement zone;
    @CacheLookup
    @FindBy(css = "#button-guest")
    WebElement continueButton1;
    @CacheLookup
    @FindBy(css = "textarea[name='comment']")
    WebElement comments;
    @CacheLookup
    @FindBy(css = "input[type='checkbox']")
    WebElement tncCheckbox;
    @CacheLookup
    @FindBy(css = "#button-payment-method")
    WebElement continueButton2;
    @CacheLookup
    @FindBy(css = ".alert.alert-danger.alert-dismissible")
    WebElement warningText;


    public String getTextShoppingCart() {
        return getTextFromElement(textShoppingCart);
    }

    public String getTextFromMacBook() {
        return getTextFromElement(macBookText);
    }

    public String verifyProductByName(String productName) {
        return getTextFromElement(By.linkText(productName));
    }

    public void changeQuantity() {
        sendTextToElement(quantity, Keys.BACK_SPACE + "2");
    }

    public void clickOnUpdateTab() {
        clickOnElement(updateTab);
    }

    public String getSuccessTextMessage() {
        return getTextFromElement(successMessage);
    }

    public String getTextTotal() {
        return getTextFromElement(total);

    }

    public void clickOnCheckOutTab() {
        clickOnElement(checkOut);

    }

    public String getTextCheckOut() {
        return getTextFromElement(textCheckOut);
    }

    public String getTextNewCustomer() {
        return getTextFromElement(textNewCustomer);
    }

    public void clickOnRadioButton() {
        clickOnElement(radioButton);

    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public void fillInMandatoryFields() {

        sendTextToElement(firstName, "Roma");
        sendTextToElement(lastName, "Patel");
        sendTextToElement(email, "rameshpatel@gmail.com");
        sendTextToElement(telephone, "76895433452");
        sendTextToElement(address, "Kings Street");
        sendTextToElement(city, "London");
        sendTextToElement(postcode, "WC11BC");
        selectByVisibleTextFromDropDown(zone, "Berkshire");

    }
    public void clickOnContinueButton1() {
        clickOnElement(continueButton1);
    }
    public void addCommentsAboutOrder() {
        sendTextToElement(comments, "Thank You for Your Order");
    }
    public void clickOnTermsAndConditionCheckbox() {
        clickOnElement(tncCheckbox);
    }
    public void clickOnContinueButton2() {
        clickOnElement(continueButton2);
    }
    public String getTextWarningMessage() {
        return getTextFromElement(warningText);
    }
}