package com.tauck.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HyperlinkHelper {

	private static HyperlinkHelper hyperlinkHelper;
	private static WebDriver wdDriver;

	private HyperlinkHelper(WebDriver driver){
		wdDriver = driver;
	}
	
	public static HyperlinkHelper getInstance(WebDriver driver){
		if(hyperlinkHelper == null || wdDriver.hashCode() != driver.hashCode())
			hyperlinkHelper = new HyperlinkHelper(driver);
		return hyperlinkHelper;
	}
	
	public void click(By locator){
		wdDriver.findElement(locator).click();
	}

	public void click(WebElement element) {
		element.click();
	}

}
