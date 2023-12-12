package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.ComponentsPage;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.pages.TopMenuPage;
import com.tutorialsninja.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase {

    TopMenuPage topMenuPage;
    DesktopsPage desktopsPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ComponentsPage componentsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        topMenuPage = new TopMenuPage();
        desktopsPage = new DesktopsPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        //1.1 Mouse hover on “Desktops” Tab and click
        topMenuPage.hoverAndClickOnLaptopsAndNotebooksTab();
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        topMenuPage.selectMenu("Show All Desktops");
        //1.3 Verify the text ‘Desktops’
        Assert.assertEquals(desktopsPage.verifyTextFromDesktops(),"Desktops","Text not matched");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        topMenuPage.hoverAndClickOnLaptopsAndNotebooksTab();
        // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        topMenuPage.selectMenu("Show All Laptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks
        Assert.assertEquals(laptopsAndNotebooksPage.verifyTextFromLaptopsAndNotebooks(),"Laptops & Notebooks", "Text not matched");
    }
    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        //3.1 Mouse hover on “Components” Tab and click
        topMenuPage.hoverAndClickOnComponentTab();
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        topMenuPage.selectMenu("Show All Components");
        //3.3 Verify the text ‘Components
        Assert.assertEquals(componentsPage.verifyTextFromComponentText(),"Components","Text on matched");
    }
}



