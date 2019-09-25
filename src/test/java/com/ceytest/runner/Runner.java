package com.ceytest.runner;

import com.ceytest.utility.CeyDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "steps",
        features = {"target/parallel/features/[CUCABLE:FEATURE].feature"},
        plugin = {"json:target/cucumber-report/[CUCABLE:RUNNER].json"}
)
public class Runner {
    // [CUCABLE:CUSTOM:comment]
    @After
    public void cleanUp() {
        System.out.println("Clean Up...");
        //.manage().deleteAllCookies();
    }

    @After
    public void tearDown() {
        System.out.println("Tear Down...");
        //driver.close();
    }
}

