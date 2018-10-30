package com.tauck.BasePage;

import com.tauck.factory.CustomFactory;
import com.tauck.factory.PageName;
import com.tauck.helper.*;
import com.tauck.utils.ReadConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class PageBase {

    private WebDriver driver;
    public ReadConfigProperties getORProperties;

    private ButtonHelper buttonHelper;
    private WindowHelper windowHelper;
    private AlertHelper alertHelper;
    private TextBoxHelper textBoxHelper;
    private DropdownHelper dropDownHelper;
    private GenericHelper genericHelper;
    private HyperlinkHelper hyperlinkHelper;


    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        getORProperties = new ReadConfigProperties("OR.properties");
        getHelperInstance();

    }

    public void getHelperInstance() {
        buttonHelper = ButtonHelper.getInstance(driver);
        windowHelper = WindowHelper.getInstance(driver);
        alertHelper = AlertHelper.getInstance(driver);
        textBoxHelper = TextBoxHelper.getInstance(driver);
        dropDownHelper = DropdownHelper.getInstance(driver);
        hyperlinkHelper = HyperlinkHelper.getInstance(driver);
        genericHelper = GenericHelper.getInstance(driver);
    }

    public TextBoxHelper getTextBoxHelper() {
        return textBoxHelper;
    }

    public ButtonHelper getButtonHelper() {
        return buttonHelper;
    }

    public WindowHelper getWindowHelper() {
        return windowHelper;
    }

    public AlertHelper getAlertHelper() {
        return alertHelper;
    }

    public GenericHelper getGenericHelper() {
        return genericHelper;
    }

    public DropdownHelper getDropDownHelper() {
        return dropDownHelper;
    }

    public HyperlinkHelper getHyperlinkHelper() {
        return hyperlinkHelper;
    }

    protected WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }
	

	public PageBase navigateTo(PageName name, WebDriver driver){
		//WebDriverWait wait = getWait();
		//wait.until(ExpectedConditions.visibilityOf(element));
		return CustomFactory.getInstance(name, driver);
		
	}



    public WebElement getWebElement(String Key) {

        ArrayList key_LocatorType = new ArrayList(Arrays.asList(Key.split(">>")));



        switch (key_LocatorType.get(0).toString()) {
            case "LINK":
                getWait().until(ExpectedConditions.elementToBeClickable(By.linkText(key_LocatorType.get(1).toString())));
                return driver.findElement(By.linkText(key_LocatorType.get(1).toString()));

            case "ID":
                getWait().until(ExpectedConditions.elementToBeClickable(By.id(key_LocatorType.get(1).toString())));
                return driver.findElement(By.id(key_LocatorType.get(1).toString()));

            case "XPATH":
                getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(key_LocatorType.get(1).toString())));
                return driver.findElement(By.xpath(key_LocatorType.get(1).toString()));

            default:
                throw new RuntimeException("Invalid Locator");

        }

    }

}
