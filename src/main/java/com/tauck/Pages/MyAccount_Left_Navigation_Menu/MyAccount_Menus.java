package com.tauck.Pages.MyAccount_Left_Navigation_Menu;

import com.tauck.BasePage.PageBase;
import com.tauck.Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccount_Menus extends PageBase {

    public WebDriver driver;

    public MyAccount_Menus(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(how = How.XPATH,using = "//a[@data-path='Agent Rewards']")
    public WebElement AgentRewards;


    public PageBase Click_On_Menu_And_Navigate_To_Landing_Page(String menuName) {

        WebElement menu = getWebElement("XPATH>>//a[@data-path='"+menuName+"']");
        getHyperlinkHelper().click(menu);
        Page page = new Page(driver);
        return page;
    }



}
