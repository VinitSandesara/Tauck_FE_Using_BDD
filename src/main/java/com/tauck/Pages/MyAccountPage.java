package com.tauck.Pages;

import com.tauck.BasePage.PageBase;
import com.tauck.Pages.MyAccount_Left_Navigation_Menu.IhasLeftNavMenu;
import com.tauck.Pages.MyAccount_Left_Navigation_Menu.MyAccount_Menus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class MyAccountPage extends PageBase implements IhasLeftNavMenu{

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public MyAccount_Menus getLeftNavigationMenu() {
        return new MyAccount_Menus(driver);
    }

    @FindBy(how = How.XPATH,using = "//div[@class='c-navigation__header c-navigation__header--agent']/h4")
    public WebElement MyAccountPage_Identifier;

    public PageBase verify_MyAccount_Landing_Page(String expected){
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(MyAccountPage_Identifier));
        assertEquals(MyAccountPage_Identifier.getText().toLowerCase(), expected.toLowerCase());
        return this;
    }



}
