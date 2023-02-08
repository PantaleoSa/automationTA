package org.nttData.pages;

import org.junit.Assert;
import org.nttData.common.StartSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends StartSession {
    public static String loginUrl;
    public static String homepageUrl = "https://assistenza.sky.it/";
    public static String currentUrl;
    public static void userOnLoginPage(){
       loginUrl = "https://assistenza.sky.it/login";
       driver.get(loginUrl);
       WebElement cookiesModal = driver.findElement(By.xpath("//*[@id='sp_message_iframe_639456']"));
        StartSession.getWebDriverWait(400).until(ExpectedConditions.visibilityOf(cookiesModal));
        if (cookiesModal.isDisplayed()){
            driver.switchTo().frame(cookiesModal);
            System.out.println("Cookies Modal displayed");
            WebElement acceptCookiesBtn = driver.findElement(By.cssSelector("button.message-component.sp_choice_type_11"));
            acceptCookiesBtn.click();
            System.out.println("cookies accepted");
            driver.switchTo().defaultContent();
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
        loginButton.click();
        System.out.println("Signed in with Click");
        StartSession.getWebDriverWait(5).until(ExpectedConditions.urlToBe(homepageUrl));
    }

    public static void userLanded(){
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, homepageUrl);
        System.out.println("the user is landed on the homepage");
    }
}