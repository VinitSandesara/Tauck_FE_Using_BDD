package com.tauck.Pages.Off_Canvas;


import com.tauck.BasePage.PageBase;
import com.tauck.Pages.HomePage;
import com.tauck.Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Login_OffCanvas extends PageBase {


    private WebDriver driver;

    public Login_OffCanvas(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(how = How.LINK_TEXT,using = "Forgot Password?")
    public WebElement Link_forgotPassword;


    @FindBy(how = How.ID,using = "email")
    public WebElement TextBox_email;

    @FindBy(how = How.ID,using = "password")
    public WebElement TextBox_password;

    @FindBy(how = How.ID,using = "btnloginoffcanvas")
    public WebElement Button_Login;

    @FindBy(how = How.LINK_TEXT,using = "Join Now")
    public WebElement Link_joinNow;



    public PageBase verify_Login_OffCanvas_LandingPage(String expected) {

        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.elementToBeClickable(Link_joinNow));
        assertEquals(Link_joinNow.getText(), expected);
        return this;

    }


    public PageBase Input_Login_Credential(String Email, String Password){

        getTextBoxHelper().setText(TextBox_email,Email);
        getTextBoxHelper().setText(TextBox_password,Password);
        getButtonHelper().click(Button_Login);

        Page page = new Page(driver);

        return page;
    }


    public PageBase Input_Invalid_Login_Credential(String Email, String Password){
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.elementToBeClickable(Link_forgotPassword));

        TextBox_email.sendKeys(Email);
        TextBox_password.sendKeys(Password);
        Button_Login.click();

        Login_OffCanvas login_offCanvas = new Login_OffCanvas(driver);

        return login_offCanvas;
    }

}
