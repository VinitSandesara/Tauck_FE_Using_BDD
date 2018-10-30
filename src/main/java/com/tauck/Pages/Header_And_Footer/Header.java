package com.tauck.Pages.Header_And_Footer;

import com.tauck.BasePage.PageBase;
import com.tauck.Pages.Off_Canvas.Login_OffCanvas;
import com.tauck.Pages.MyAccountPage;
import com.tauck.Pages.Off_Canvas.OffCanvas;
import com.tauck.Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Header extends PageBase {


    private WebDriver driver;


    public Header(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(how = How.LINK_TEXT, using = "Login")
    public WebElement Link_Header_login;

    @FindBy(how = How.XPATH, using = "//div[@class='c-emergency-banners--container js-emergency-banners--container']")
    public WebElement emergencyBanner;

    @FindBy(how = How.LINK_TEXT, using = "MyAccount")
    public WebElement Link_MyAccount;

    @FindBy(how = How.LINK_TEXT, using = "Agent Connect")
    public WebElement Link_AgentConnect;


    public void closeEmergencyBanner() {

        try {
            getButtonHelper().ClickByTagName(emergencyBanner, "button");
        } catch (Throwable t) {
            System.out.println("Banner is not visible to close...");
        }
        // emergencyBanner.findElement(By.tagName("button")).click();

    }


    public PageBase Click_Login_Link_And_Navigate_To_Login_OffCanvas() {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.elementToBeClickable(emergencyBanner));
        closeEmergencyBanner();

        getHyperlinkHelper().click(Link_Header_login);
        OffCanvas offCanvas = new OffCanvas(driver);
        return offCanvas;
    }

  /*  public PageBase Click_MyAccount_Link_And_Navigate_To_MyAccount_LandingPage() {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.elementToBeClickable(Link_MyAccount));
        //  closeEmergencyBanner();
        getHyperlinkHelper().click(Link_MyAccount);
        MyAccountPage myAccount = new MyAccountPage(driver);
        return myAccount;
    }

    public PageBase Click_AgentConnect_Link_And_Navigate_To_AgentConnect_LandingPage() {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.elementToBeClickable(Link_AgentConnect));
        //  closeEmergencyBanner();
        getHyperlinkHelper().click(Link_AgentConnect);
        MyAccountPage myAccount = new MyAccountPage(driver);
        return myAccount;
    }*/


    public PageBase Click_AgentConnect_Or_MyAccount_And_Navigate_To_LandingPage(String MenuName) {

        WebElement menu = getWebElement("LINK>>" + MenuName + "");
        getHyperlinkHelper().click(menu);
        Page page = new Page(driver);
        return page;
    }


}
