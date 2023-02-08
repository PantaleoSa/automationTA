package org.nttData.pages;

import org.junit.Assert;
import org.nttData.common.StartSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends StartSession {
    public static String loginUrl;
    public static String homepageUrl;

    public static void userOnLoginPage(){
       loginUrl = "https://assistenza.sky.it/login";
       driver.get(loginUrl);
       WebElement cookies = driver.findElement(By.xpath("//*[@id='sp_message_iframe_639456']"));
        if (cookies.isDisplayed()){
            //StartSession.getWebDriverWait(400).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(cookies));
            driver.switchTo().frame(cookies);
            System.out.println("Cookies Modal displayed");
            WebElement acceptCookiesBtn = driver.findElement(By.cssSelector("div.message-component.message-row.mobile-reverse > div:nth-child(2) > button"));
            acceptCookiesBtn.click();
            System.out.println("cookies accepted");
       }
    }
    public static void credentialsEnter(){
        WebElement loginForm = driver.findElement(By.cssSelector("div.login-wrapper"));
        WebElement username = driver.findElement(By.name("sky-login-email"));
        WebElement password = driver.findElement(By.name("sky-login-password"));
        StartSession.getWebDriverWait(5).until(ExpectedConditions.visibilityOf(loginForm));

        username.sendKeys("techdreamer.co@gmail.com");
        password.sendKeys("SkyProspect2023!?");
    }

    public static void loginClick() {
        WebElement loginButton = driver.findElement(By.className("sky-login-submit"));
        StartSession.getWebDriverWait(5);
        loginButton.click();
        System.out.println("Signed in with Click");
    }

    public static void userLanded(){
        homepageUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginUrl, homepageUrl);
        System.out.println("the user is landed on the homepage");
    }
}