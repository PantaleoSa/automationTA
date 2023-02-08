package org.nttData.listeners;

import io.cucumber.java.Scenario;
import org.nttData.common.StartSession;

public class Hook {
    private String browser;
    private String url = "https://assistenza.sky.it/";

    //Revolution project
    /*
    1. listeners > Hook class for managing actions before and after every testcase
    2. run > TestRunner as runner of referenced testcases (feature files and stepDefinition paths)
    3. stepDefinition > Login as code of gherkin step into the feature file "login.feature"
    4. features > login.feature as feature file with gherkin steps Cucumber based
    5. pages > LoginPage as code of definition object and interactions of "Login" methods
    6. common > StartBrowser as a WebDriver manager
     */

    public static void startBrowser(){
        //this.browser = System.getProperty("browser");
        StartSession.initDriver("chrome","https://assistenza.sky.it/");
    }

    public static void closeBrowser(Scenario scenarios){
        if (scenarios.isFailed()) {
            System.out.println(scenarios.getName());
        }
        StartSession.getWebDriver().quit();
    }
}