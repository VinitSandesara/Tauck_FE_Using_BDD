package com.tauck.StepDef.Agent_Connect;

import com.tauck.Pages.AgentRewardPage;
import com.tauck.Pages.MyAccountPage;
import com.tauck.Pages.MyAccount_Left_Navigation_Menu.MyAccount_Menus;
import com.tauck.Pages.Off_Canvas.OffCanvas;
import com.tauck.Pages.Page;
import com.tauck.factory.PageName;
import com.tauck.services.DriverServices;
import com.tauck.utils.PageInstance;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.Map;

public class Agent_Reward_Non_Registered_StepDef {


    private WebDriver driver;
    private DriverServices services;
    private PageInstance getPageInstance;
    public List<Map<String, String>> dataList ;
    public Map<String, String> dataMap ;

    public Agent_Reward_Non_Registered_StepDef(DriverServices services, PageInstance getPageInstance) {
        this.services = services;
        this.driver = services.getDriver();
        this.getPageInstance = getPageInstance;
    }






    @And("^I need to verify following list of flex cards for non registered agent rewards$")
    public void Verify_Agent_Rewards_Flex_Cards(DataTable table) throws Throwable {
        dataList  = table.asMaps(String.class, String.class);
        dataMap = dataList.get(0);
        getPageInstance.page.getAgentRewardPage().Verify_Flex_Cards(dataMap.get("FlexCards"));

    }

    @When("^I click on Sign Up Now button$")
    public void Click_SignUp_Now_Button() throws Throwable {
        getPageInstance.offCanvas = (OffCanvas) getPageInstance.page.getAgentRewardPage().Click_SignUp_Now_Button();
    }



    }
