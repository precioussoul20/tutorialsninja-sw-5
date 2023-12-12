package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccountLink;
    @CacheLookup
    @FindBy(css = "#content h1")
    WebElement textRegister;
    @CacheLookup
    @FindBy(css = "#content > div > div:nth-child(2) > div > h2")
    WebElement textReturningCustomer;
    @CacheLookup
    @FindBy(css = "#input-firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(css = "#input-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(css = "#input-email")
    WebElement email;
    @CacheLookup
    @FindBy(css = "#input-telephone")
    WebElement telephone;
    @CacheLookup
    @FindBy(css = "#input-password")
    WebElement password;
    @CacheLookup
    @FindBy(css = "#input-confirm")
    WebElement confirmPassword;
    @CacheLookup
    @FindBy(css = "input[type='radio'][name='newsletter'][value='1']")
    WebElement radioYes;
    @CacheLookup
    @FindBy(css = "input[type='checkbox']")
    WebElement checkPrivacy;
    @CacheLookup
    @FindBy(css = "input[value='Continue']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    WebElement textAccountCreated;
    @CacheLookup
    @FindBy(css = "a[class='btn btn-primary']")
    WebElement continueButton1;
    @CacheLookup
    @FindBy(xpath = "//h1[text()='Account Logout']")
    WebElement textAccountLogOut;
    @CacheLookup
    @FindBy(css = ".btn.btn-primary")
    WebElement continueButton2;
    @CacheLookup
    @FindBy(css = "input[value='Login']")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement textMyAccount;

    public void selectMyAccountOptions(String option){
        //This method should click on the menu
        List<WebElement> elementList = driver.findElements(By.id("menu"));
        for (WebElement element : elementList) {
            if (element.getText().equalsIgnoreCase(option)){
                element.click();
                break;
            }
        }
    }
    public void clickOnMyAccountTab(){
        clickOnElement(myAccountLink);
    }
    public String getTextFromRegister(){
        return getTextFromElement(textRegister);
    }
    public String getTextFromReturningCustomer(){
        return getTextFromElement(textReturningCustomer);
    }
    public void fillInInformation(){
        sendTextToElement(firstName,"Vinayak");
        sendTextToElement(lastName,"Shah");
        sendTextToElement(email,"vinayakshah1234567@gmail.com");
        sendTextToElement(telephone,"78945636547");
        sendTextToElement(password,"12as5464");
        sendTextToElement(confirmPassword,"12as5464");
        clickOnElement(radioYes);
        clickOnElement(checkPrivacy);
        clickOnElement(continueButton);

    }
    public void fillInEmailPassword(){
        sendTextToElement(email,"vinashah1234@gmail.com");
        sendTextToElement(password,"12as5464");
        clickOnElement(loginButton);

    }
    public String getTextAccountCreated(){
        return getTextFromElement(textAccountCreated);
    }
    public void clickOnContinueButton() {
        clickOnElement(continueButton1);
    }

    public String getTextAccountLogOut(){
        return getTextFromElement(textAccountLogOut);
    }
    public void clickOnContinueButton2(){
        clickOnElement(continueButton2);
    }
    public String getTextMyAccount(){
        return getTextFromElement(textMyAccount);
    }
}
