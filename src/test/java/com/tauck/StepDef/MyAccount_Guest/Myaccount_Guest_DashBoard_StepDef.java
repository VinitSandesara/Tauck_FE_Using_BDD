package com.tauck.StepDef.MyAccount_Guest;

import com.tauck.Pages.HomePage;
import com.tauck.services.DriverServices;
import com.tauck.utils.PageInstance;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class Myaccount_Guest_DashBoard_StepDef {


    private WebDriver driver;
    private DriverServices services;
    private PageInstance getPageInstance;

    public Myaccount_Guest_DashBoard_StepDef(DriverServices services,PageInstance getPageInstance) {
        this.services = services;
        this.driver = services.getDriver();
        this.getPageInstance = getPageInstance;
    }




}
