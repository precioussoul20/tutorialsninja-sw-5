package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComponentsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2")
    WebElement componentText;

    public String verifyTextFromComponentText(){
        return getTextFromElement(componentText);

    }
}
