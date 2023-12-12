package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.MyAccountPage;
import com.tutorialsninja.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountsTest extends TestBase {
    MyAccountPage myAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        myAccountPage = new MyAccountPage();

    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        //1.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        myAccountPage.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        Assert.assertEquals(myAccountPage.getTextFromRegister(),"Register Account", "Error");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        //2.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        myAccountPage.selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer
        Assert.assertEquals(myAccountPage.getTextFromReturningCustomer(), "Returning Customer", "Error");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserRegisterAccountSuccessfully(){
        //3.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        myAccountPage.selectMyAccountOptions("Register");
        //3.3 Enter First Name
        //3.4 Enter Last Name
        //3.5 Enter Email
        //3.6 Enter Telephone
        //3.7 Enter Password
        //3.8 Enter Password Confirm
        //3.9 Select Subscribe Yes radio button
        //3.10 Click on Privacy Policy check box
        //3.11 Click on Continue button
        myAccountPage.fillInInformation();
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(myAccountPage.getTextAccountCreated(), "Your Account Has Been Created!", "Error");
        //3.13 Click on Continue button
        myAccountPage.clickOnContinueButton();
        //3.14 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        myAccountPage.selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals(myAccountPage.getTextAccountLogOut(),"Account Logout", "Error");
        //3.17 Click on Continue button
        myAccountPage.clickOnContinueButton2();
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        //4.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        myAccountPage.selectMyAccountOptions("Login");
        //4.3 Enter Email address
        //4.4 Enter Last Name
        //4.5 Enter Password
        //4.6 Click on Login button
        myAccountPage.fillInEmailPassword();
        //4.7 Verify text “My Account”
        Assert.assertEquals(myAccountPage.getTextMyAccount(),"My Account", "Error");
        //4.8 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        myAccountPage.selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        Assert.assertEquals(myAccountPage.getTextAccountLogOut(),"Account Logout","Error");
        //4.11 Click on Continue button
        myAccountPage.clickOnContinueButton2();
    }
}
