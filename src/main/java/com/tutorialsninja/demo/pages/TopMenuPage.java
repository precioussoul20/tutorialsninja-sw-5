package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopMenuPage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopLink;
    @CacheLookup
    @FindBy(linkText = "Show AllDesktops")
    WebElement showAllDesktopLink;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink;

    @CacheLookup
    @FindBy(linkText = "Show AllLaptops & Notebooks")
    WebElement showAllLaptopsAndNotebooksLink;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentLink;

    @CacheLookup
    @FindBy(xpath = "//span[text()='Currency']")
    WebElement currencyLink;
    @CacheLookup
    @FindBy(xpath = "//button[text()='£Pound Sterling']")
    WebElement poundSterling;

    public void selectMenu(String menu){
        //This method should click on the menu
        List<WebElement> elementList = driver.findElements(By.id("menu"));
        for (WebElement element : elementList) {
            if (element.getText().equalsIgnoreCase(menu)){
                element.click();
                break;
            }
        }
    }
    public void hoverAndClickOnDesktopTab(){
        clickOnElement(desktopLink);
    }
    public void hoverAndClickOnLaptopsAndNotebooksTab(){
        clickOnElement(laptopsAndNotebooksLink);
    }
    public void hoverAndClickOnComponentTab(){
        clickOnElement(componentLink);
    }
    public void clickOnShowAllDesktopsLink(){
        clickOnElement(showAllDesktopLink);
    }
    public void clickOnShowALLLaptopsAndNotebooksLink(){
        clickOnElement(showAllLaptopsAndNotebooksLink);
    }
    public void hoverAndClickOnCurrencyLink(){
        clickOnElement(currencyLink);
    }
    public void hoverAndClickOnPoundSterling(String text){
      selectByVisibleTextFromDropDown(poundSterling, text);
    }
}

