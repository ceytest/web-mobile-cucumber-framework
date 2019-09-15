package com.ceytest.pom.mobile.home;

import com.ceytest.pom.mobile.BaseMobilePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BaseMobilePage {

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    //Hoem Elements
    @AndroidFindBy( accessibility = "Open")
    private MobileElement mainMenu;

    @AndroidFindBy(id = "com.booking:id/product_container2\n")
    private MobileElement carRental;


}
