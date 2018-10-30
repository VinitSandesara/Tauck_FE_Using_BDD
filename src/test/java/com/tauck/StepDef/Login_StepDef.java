package com.tauck.StepDef;


import com.tauck.Pages.Off_Canvas.Login_OffCanvas;
import com.tauck.Pages.HomePage;
import com.tauck.Pages.Off_Canvas.OffCanvas;
import com.tauck.Pages.Page;
import com.tauck.services.DriverServices;
import com.tauck.utils.PageInstance;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;


public class Login_StepDef {

    private WebDriver driver;
    private DriverServices services;
    private PageInstance getPageInstance;


    public Login_StepDef(DriverServices services, PageInstance getPageInstance) {
        this.services = services;
        this.driver = services.getDriver();
        this.getPageInstance = getPageInstance;
    }


  /*  @Given("^Login_User at the Tuack home page \"([^\"]*)\"$")
    public void HomePageLanding(@Transform(readTestDataFromGDriveSpreadSheet.class)DataTable table) throws Throwable {

        List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
        Map<String, String> dataMap = dataList.get(0);

        System.out.println("Email Value is ==>" + dataMap.get("Email"));
        System.out.println("Password Value is ==>" + dataMap.get("Password"));

        driver.get(services.getReader().getApplicationUrl());
        testSettings.homePage = new HomePage(driver);
        testSettings.homePage.verify_HomePage_Landing_Page();
    }*/









    /* With Valid login */

    @And("^I input Email as \"([^\"]*)\" and Password as \"([^\"]*)\" and Click on Login button$")
    public void Input_Login_Credential_And_Click_On_Login_Button(String Email, String Password) throws Throwable {

        getPageInstance.page = (Page) getPageInstance.offCanvas.getLoginOffCanvasInstance().Input_Login_Credential(Email, Password);

        //getPageInstance.homePage = (HomePage) getPageInstance.login_offCanvas.Input_Login_Credential(Email,Password);
    }



    /* With InValid login */

    @When("^I input invalid Email as \"([^\"]*)\" and Password as \"([^\"]*)\" and Click on Login button$")
    public void Input_Invalid_Login_Credential_And_Click_On_Login_Button(String Email, String Password) throws Throwable {
        getPageInstance.login_offCanvas = (Login_OffCanvas) getPageInstance.offCanvas.getLoginOffCanvasInstance().Input_Invalid_Login_Credential(Email, Password);
    }

    @Then("^I should remain on Login OffCanvas page$")
    public void Verify_With_Invalid_Login_Credential_It_Stays_On_Login_OffCanvas(String expected) throws Throwable {
        getPageInstance.login_offCanvas.verify_Login_OffCanvas_LandingPage(expected);
    }


}
