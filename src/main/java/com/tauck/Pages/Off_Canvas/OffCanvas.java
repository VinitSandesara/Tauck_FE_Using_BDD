package com.tauck.Pages.Off_Canvas;

import com.tauck.BasePage.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OffCanvas extends PageBase implements iOffCanvas {

    private WebDriver driver;

    public OffCanvas(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }



    public PageBase Verify_OffCanvas_Landing(String locator, String expected) {


        WebElement menu = getWebElement(getORProperties.getValueBasedOnKey(locator)+"");
       // getHyperlinkHelper().click(menu);

        return this;
    }


    @Override
    public Login_OffCanvas getLoginOffCanvasInstance() {
        return new Login_OffCanvas(driver);
    }
}
