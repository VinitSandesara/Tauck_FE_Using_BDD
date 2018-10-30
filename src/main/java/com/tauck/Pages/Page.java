package com.tauck.Pages;

import com.tauck.BasePage.PageBase;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class Page extends PageBase implements PageInstance {

    private WebDriver driver;

    public Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    @Override
    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    @Override
    public MyAccountPage getMyAccountpage() {
        return new MyAccountPage(driver);
    }

    @Override
    public AgentRewardPage getAgentRewardPage() {
        return new AgentRewardPage(driver);
    }

    public PageBase Verify_Landing_Page(String locator, String expected) {

        assertEquals(
                getWebElement(getORProperties.getValueBasedOnKey(locator)+"").getText(),
                expected);
        return this;
    }


}
