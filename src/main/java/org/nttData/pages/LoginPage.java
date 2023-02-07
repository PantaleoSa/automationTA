package org.nttData.pages;

import org.junit.Assert;
import org.nttData.common.StartSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class LoginPage extends StartSession {
    public static String loginUrl;
    public static String homepageUrl;
    public static void userOnLoginPage(){
       loginUrl = "https://assistenza.sky.it/login";
       driver.get(loginUrl);
       WebElement cookies = driver.findElement(By.cssSelector("iframe[id*='sp_message_iframe']"));
       if (cookies.isDisplayed()){
           driver.switchTo().frame(cookies);
           WebElement acceptCookiesBtn = driver.findElement(By.cssSelector("div.message-component.message-row.mobile-reverse > div:nth-child(2) > button"));
           acceptCookiesBtn.click();
           System.out.println("cookies accepted");
       }
    }
    public static void credentialsEnter(){
        WebElement username = driver.findElement(By.name("sky-login-email"));
        WebElement password = driver.findElement(By.name("sky-login-password"));

        username.sendKeys("techdreamer.co@gmail.com");
        password.sendKeys("SkyProspect2023!?");
    }

    public static void loginClick() {
        WebElement loginButton = driver.findElement(By.className("sky-login-submit"));
        loginButton.click();
        System.out.println("Signed in with Click");
    }

    public static void userLanded(){
        homepageUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginUrl, homepageUrl);
        System.out.println("the user is landed on the homepage");
    }
}