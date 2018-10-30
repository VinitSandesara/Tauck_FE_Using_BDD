package com.tauck.services;


import com.tauck.browser.BrowserConfiguration;
import com.tauck.browser.CustomChromeDriver;
import com.tauck.browser.CustomFirefoxDriver;
import com.tauck.helper.*;
import com.tauck.utils.IReader;
import com.tauck.utils.ReadConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverServices implements Closeable {
	
	private WebDriver driver;
	private BrowserConfiguration browserConfiguration;
	
	public BrowserConfiguration getBrowserConfiguration() {
		return browserConfiguration;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public CustomChromeDriver getChromeDriver() {
		return chromeDriver;
	}

	public BrowserHelper getBrowserHelper() {
		return browserHelper;
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

	private CustomChromeDriver chromeDriver;
	private BrowserHelper browserHelper;
	private ButtonHelper buttonHelper;
	private WindowHelper windowHelper;
	private AlertHelper alertHelper;
	private TextBoxHelper textBoxHelper;
	private DropdownHelper dropDownHelper;
	private GenericHelper genericHelper;
	private HyperlinkHelper hyperlinkHelper;
	public GenericHelper getGenericHelper() {
		return genericHelper;
	}

	private IReader reader;

	public IReader getReader() {
		return reader;
	}



	public DropdownHelper getDropDownHelper() {
		return dropDownHelper;
	}

	public TextBoxHelper getTextBoxHelper() {
		return textBoxHelper;
	}
	public HyperlinkHelper getHyperlinkHelper() {
		return hyperlinkHelper;
	}

	public void launchBrowser(){
		//chromeDriver = new CustomChromeDriver();
		reader = new ReadConfigProperties();
		reader.setBrowserType();

		//driver = chromeDriver.getChromeDriver();
		driver = getBrowserDriver();
		browserHelper = BrowserHelper.getInstance(driver);
		buttonHelper = ButtonHelper.getInstance(driver);
		windowHelper = WindowHelper.getInstance(driver);
		alertHelper = AlertHelper.getInstance(driver);
		textBoxHelper = TextBoxHelper.getInstance(driver);
		dropDownHelper = DropdownHelper.getInstance(driver);
		hyperlinkHelper = HyperlinkHelper.getInstance(driver);
		genericHelper = GenericHelper.getInstance(driver);
		driver.manage().timeouts().pageLoadTimeout(reader.getExplicitWait(), TimeUnit.SECONDS); //PageInstance load time out
		browserHelper.maximize();
	}
	
	private WebDriver getBrowserDriver() {
		/*String browser = System.getProperty("browser.name");
		System.out.println(" ============== > " + browser);
		if(browser.isEmpty())
			browser = "chrome";*/
		switch (reader.getBrowserType()) {
		
		case BrowserType.CHROME:
			/*CustomChromeDriver chromeDriver = new CustomChromeDriver();
			return chromeDriver.getChromeDriver();*/
			browserConfiguration = new CustomChromeDriver();
			return browserConfiguration.getBrowserDriver();
		
		case BrowserType.FIREFOX:
			/*CustomFirefoxDriver firefoxDriver = new CustomFirefoxDriver();
			return firefoxDriver.getFirefoxDriver();*/
			browserConfiguration = new CustomFirefoxDriver();
			return browserConfiguration.getBrowserDriver();
			
		default:
			throw new RuntimeException("Invalid Browser Type : " + reader.getBrowserType());
		}
	}

	public DriverServices() {
		launchBrowser();
	}

	@Override
	public void close() throws IOException {
		
	}

}
