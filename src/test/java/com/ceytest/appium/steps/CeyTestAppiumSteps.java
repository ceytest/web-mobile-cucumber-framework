package com.ceytest.appium.steps;

import com.ceytest.appium.baseTests.AppiumBaseTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;
import java.util.Date;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

public class CeyTestAppiumSteps extends AppiumBaseTest {
    @Value("${appium.sleep}")
    private Long timeToSleep;

    private AndroidElement textView;
    private AndroidDriver<AndroidElement> driver;

    private Logger log = Logger.getLogger(this.getClass().getName());

    @When("I launch the application")
    public void shouldLaunchTheApplication() throws Exception {
        log.info("Running: I launch the application at " + new Date());
        driver = getDriver();
    }

    @Then("I should be able to see the category list")
    public void shouldDisplayCategories() throws Exception {
        log.info("Running: I should be able to see the category list at " + new Date());
        assumeTrue(driver.findElement(By.id("listViewCategories")) != null);
        textView = driver.findElement(By.id("categoryTextView"));
        assertEquals("Curativos", textView.getText());
    }

    @And("I should be able to click in the category")
    public void shouldClickInCategory() throws Exception {
        log.info("Running: I should be able to click in the category at " + new Date());
        waitForElement(textView).click();
    }

    @And("I should be able to list beverages")
    public void shouldListBeverages() throws Exception {
        log.info("Running: I should be able to list beverages at " + new Date());
        assertNotNull(driver.findElement(By.id("action_bar_container")));
        assumeTrue(driver.findElement(By.id("content")) != null);
        assumeTrue(driver.findElement(By.id("listViewBeverages")) != null);

        log.info("Beverages container and beverage list are there");
        textView = driver.findElement(By.id("beverageTextView"));
        assertEquals("Jugo para evitar los calambres", textView.getText());
    }

    private void assertNotNull(AndroidElement action_bar_container) {
    }

    @And("I should be able to click in a beverage")
    public void shouldClickInBeverage() throws Exception {
        log.info("Running: I should be able to click in a beverage at " + new Date());
        waitForElement(textView).click();
    }

    @And("I should be able to view a recipe")
    public void shouldViewRecipe() throws Exception {
        log.info("Running: I should be able to view a recipe at " + new Date());
        assertNotNull(driver.findElement(By.id("name")));
        assertNotNull(driver.findElement(By.id("image")));
        assertNotNull(driver.findElement(By.id("ingredients")));
        assertNotNull(driver.findElement(By.id("recipe")));
    }

    @And("I should back to beverage section")
    public void shouldBackToBeverageSection() throws Exception {
        log.info("Running: I should back to the beverage section at " + new Date());
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(timeToSleep));
    }

    @And("I should back to category section")
    public void shouldBackToCategorySection() throws Exception {
        log.info("Running: I should back to the category section at " + new Date());
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(timeToSleep));
    }

    @And("I should be able to close application")
    public void shouldCloseTheApplication() throws Exception {
        log.info("Running: I should be able to close the application at " + new Date());
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(timeToSleep));
    }
}
