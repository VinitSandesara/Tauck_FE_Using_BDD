package com.tauck.Pages;


import com.tauck.BasePage.PageBase;


import com.tauck.Pages.Header_And_Footer.Footer;
import com.tauck.Pages.Header_And_Footer.Header;
import com.tauck.Pages.Header_And_Footer.IHasPageHeaderAndFooter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**  Here i am following IS-A relationship (Inheritance) and also HAS-A relationship (Interface, Abstract)
 *  IS-A relationship (Inheritance)
 *          Homepage is extending PageBase
 *              HomePage "IS-A" one of the web page (pageBase)
 *
 *          HAS-A relationship
 *              HomePage "HAS-A" header and footer
 *
 */

public class HomePage extends PageBase implements IHasPageHeaderAndFooter {

    private WebDriver driver;


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    @Override
    public Header getHeader() {
        return new Header(driver);
    }

    @Override
    public Footer getFooter() {
        return new Footer(driver);
    }

    @FindBy(how = How.LINK_TEXT,using = "Forgot Password?")
    public WebElement Link_forgotPassword;

  //  @FindBy(how = How.XPATH,using = "//div[@class='c-hero-search__form-input']")
   // public List<WebElement> HomePage_Identifier;

    @FindBy(how = How.XPATH,using = "//span[text() ='See the world in a way you never thought possible']")
    public WebElement HomePage_Identifier;


    public PageBase verify_HomePage_Landing_Page(String locator, String expected){

        assertEquals(
                getWebElement("XPATH>>"+getORProperties.getValueBasedOnKey(locator)+"").getText(),
                expected);
        return this;
    }



}
