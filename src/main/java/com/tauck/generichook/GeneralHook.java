package com.tauck.generichook;


import com.tauck.services.DriverServices;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class GeneralHook {
	
	private DriverServices services;
	private WebDriver driver;
	
	public GeneralHook(DriverServices services) {
		this.services = services;
		this.driver = services.getDriver();
	}
	
	@Before(value="@regression",order = 2)
	public void setupForRegression(){
		System.out.println("This is regression suite");
	}
	
	@Before(value="@smoke")
	public void setupForSmoke(){
		System.out.println("This is smoke suite");
	}
	
	@Before(order = 1)
	public void setup() {
		driver.get(services.getReader().getApplicationUrl());
	}
	
	@After
	public void teardown(Scenario scenario) {
		if(scenario.isFailed()){
			captureScreenShot(scenario);
		}
		if(driver != null){
	    	driver.quit(); // it will close all the window and stop the web driver
	    }
		
	}

	private void captureScreenShot(Scenario scenario) {
		int random = (int)(Math.random() * 1000);
		services.getGenericHelper().takeScrenShot("Screenshot", "src" + random +".png");
		scenario.embed(services.getGenericHelper().takeScrenShot(), "image/png");
	}

}
