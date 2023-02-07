package org.nttData.stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.nttData.listeners.Hook;
import org.nttData.pages.LoginPage;


public class Login {
    LoginPage loginPage = new LoginPage();

    @Before
    public void callStartBrowser(){
        Hook.startBrowser();
    }

    @Given("User is on login page")
    public void userIsOnLoginPage(){
        LoginPage.userOnLoginPage();
    }

    @When("User enters username and password")
    public void userEntersUsernameAndPassword(){
        LoginPage.credentialsEnter();
    }

    @And("Click on login button")
    public void clickOnLoginButton(){
        LoginPage.loginClick();
    }

    @Then("User navigates to the homepage")
    public void userNavigatesToTheHomePage(){
        LoginPage.userLanded();
    }

    @After
    public static void closeBrowser(Scenario scenarios){
        Hook.closeBrowser(scenarios);
    }

}