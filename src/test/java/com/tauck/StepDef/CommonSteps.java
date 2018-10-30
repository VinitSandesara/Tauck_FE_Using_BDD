package com.tauck.StepDef;

import com.tauck.Pages.Page;
import com.tauck.services.DriverServices;
import com.tauck.utils.PageInstance;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class CommonSteps {

    private WebDriver driver;
    private DriverServices services;
    private PageInstance getPageInstance;
    private List<Map<String, String>> dataList ;
    private Map<String, String> dataMap ;


    public CommonSteps(DriverServices services, PageInstance getPageInstance) {
        this.services = services;
        this.driver = services.getDriver();
        this.getPageInstance = getPageInstance;
    }

    @Given("^I am at the page which is \"([^\"]*)\"$")
    public void Verify_Landing_Page(String Page, String expected) throws Throwable {

        getPageInstance.page = new Page(driver);
        getPageInstance.page.Verify_Landing_Page(Page, expected);
    }

    @Then("^I should navigate to offcanvas which is \"([^\"]*)\"$")
    public void Verify_It_Navigates_To_OffCanvas(String offCanvasName, String expected) throws Throwable {
        getPageInstance.offCanvas.Verify_OffCanvas_Landing(offCanvasName, expected);
    }

    @Then("^I should navigate to page which is \"([^\"]*)\"$")
    public void Verify_It_Navigates_To_Landing_Page(String Page, String expected) throws Throwable {
        getPageInstance.page.Verify_Landing_Page(Page, expected);

    }

    @When("^I click on following Menu located on left navigation$")
    public void Click_Left_Navigation_Menu_Located_Inside_MyAccount_Dashboard(DataTable table) throws Throwable {
        dataList  = table.asMaps(String.class, String.class);
        dataMap = dataList.get(0);
        getPageInstance.page = (Page) getPageInstance.page.getMyAccountpage().getLeftNavigationMenu().Click_On_Menu_And_Navigate_To_Landing_Page(dataMap.get("Menu"));
    }



}
