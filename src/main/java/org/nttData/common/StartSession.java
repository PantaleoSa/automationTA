package org.nttData.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartSession {
    private static long timeout = 5;
    protected static WebDriver driver;
    protected static void firefox(String url) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-private");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        driver.get(url);
        System.out.println("firefoxDriver started");
    }
    protected static void chrome(String url) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-private");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        driver.get(url);
        System.out.println("chromeDriver started");
    }
    public static void initDriver(String browser, String url){
        switch (browser) {
            case "firefox" -> firefox(url);
            case "chrome" -> chrome(url);
        }
    }

    public static WebDriver getWebDriver(){
        return driver;
    }

    public static WebDriverWait getWebDriverWait(long timeOut){
        return new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(500));
    }

    public static WebElement element(By by){
        return driver.findElement(by);
    }

}