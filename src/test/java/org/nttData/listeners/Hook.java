package org.nttData.listeners;

import io.cucumber.java.Scenario;
import org.nttData.common.StartSession;

public class Hook {
    //public static WebDriver browserDriver;
    private String browser;
    private String url = "https://assistenza.sky.it/";

    //Revolution project
    /*
    Hook o not Hook?
     */
    public static void startBrowser(){
        //this.browser = System.getProperty("browser");
        //this.browser = "chrome";
        StartSession.initDriver("chrome","https://assistenza.sky.it/");
    }

    public static void closeBrowser(Scenario scenarios){
        if (scenarios.isFailed()) {
            System.out.println(scenarios.getName());
        }
        StartSession.getWebDriver().quit();
    }
}