package com.tauck.factory;



import com.tauck.BasePage.PageBase;

import com.tauck.Pages.AgentRewardPage;
import com.tauck.Pages.Off_Canvas.Login_OffCanvas;
import com.tauck.Pages.HomePage;
import org.openqa.selenium.WebDriver;

public class CustomFactory {
	
	/*
	 * Factory design pattern is used when we have a super class with multiple sub-classes and based on input, we need to return one of the sub-class instance
	 * Super Class - PageBase -> HomePageClass, LoginPageClass, EnterBugClass so on
	 * Navigation --> Based on input we need to have intance of corr page class
	 * */
	
	public static PageBase getInstance(PageName name, WebDriver driver) {
		
		switch (name) {

			case HomePage:
				return new HomePage(driver);
			case Login_OffCanvas:
				return new Login_OffCanvas(driver);
			case AgentRewardPage:
				return new AgentRewardPage(driver);


		default:
			throw new RuntimeException("Invalid PageInstance Name");
		}
		
	}

}
