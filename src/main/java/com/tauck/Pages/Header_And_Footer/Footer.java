package com.tauck.Pages.Header_And_Footer;


import com.tauck.BasePage.PageBase;
import com.tauck.Pages.Off_Canvas.Login_OffCanvas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Footer extends PageBase {

    private WebDriver driver;

    public Footer(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(how = How.LINK_TEXT,using = "Login")
    public WebElement Link_login;

    @FindBy(how = How.XPATH,using = "//div[@class='c-emergency-banners--container js-emergency-banners--container']")
    public WebElement emergencyBanner;


    public void closeEmergencyBanner() {

        emergencyBanner.findElement(By.tagName("button")).click();

    }


    public PageBase Click_Login_Link_And_Navigate_To_Login_OffCanvas(){
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.elementToBeClickable(emergencyBanner));
        closeEmergencyBanner();
        Link_login.click();
        Login_OffCanvas loginOffCanvas = new Login_OffCanvas(driver);
        return loginOffCanvas;
    }


}
