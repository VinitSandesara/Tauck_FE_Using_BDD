package com.tauck.StepDef;

import com.tauck.Pages.Off_Canvas.OffCanvas;
import com.tauck.Pages.Page;
import com.tauck.services.DriverServices;
import com.tauck.utils.PageInstance;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class HeaderSteps {


    private WebDriver driver;
    private DriverServices services;
    private PageInstance getPageInstance;
    private List<Map<String, String>> dataList;
    private Map<String, String> dataMap;


    public HeaderSteps(DriverServices services, PageInstance getPageInstance) {
        this.services = services;
        this.driver = services.getDriver();
        this.getPageInstance = getPageInstance;
    }

    @When("^I click on Login Link located on header$")
    public void Click_Login_Link_Located_On_Header() throws Throwable {

        getPageInstance.offCanvas = (OffCanvas) getPageInstance.page.getHomePage().getHeader().Click_Login_Link_And_Navigate_To_Login_OffCanvas();

    }


    @When("^I click on following menu located on header after successful login$")
    public void Click_MyAccount_AgentConnect_Link_Located_On_Header(DataTable table) throws Throwable {

        dataList = table.asMaps(String.class, String.class);
        dataMap = dataList.get(0);
        getPageInstance.page = (Page) getPageInstance.page.getHomePage().getHeader().Click_AgentConnect_Or_MyAccount_And_Navigate_To_LandingPage(dataMap.get("HeaderMenu"));

    }


}
