package org.nttData.run;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/login.feature",
        glue={"org.nttData.stepDefinition"}
)

public class TestRunner {
}