package com.tauck.Pages;

import com.tauck.BasePage.PageBase;
import com.tauck.Pages.Off_Canvas.OffCanvas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class AgentRewardPage extends PageBase {

    private WebDriver driver;

    public AgentRewardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(how = How.XPATH,using = "//p[text() ='Agent Rewards']")
    public WebElement AgentRewardLandingIdentifier;

    @FindBy(how = How.XPATH,using = "//button[@data-trk-label='Sign Up Now']")
    public WebElement SignUpBtn;

    @FindBy(how = How.XPATH, using = "//div[@class='c-flexbox-column l-pad-tb c-agent-rewards__how']/div")
    public List<WebElement> listOfFlexCards;

    public PageBase verify_AgentReward_Landing_Page(String expected){
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(AgentRewardLandingIdentifier));
        assertEquals(AgentRewardLandingIdentifier.getText(), expected.toUpperCase());
        return this;
    }


    public PageBase Verify_Flex_Cards(String flexCards) {

        ArrayList flexCardsName = new ArrayList(Arrays.asList(flexCards.split(",")));

        for(int i=0;i<listOfFlexCards.size();i++) {
            String text = listOfFlexCards.get(i).findElement(By.xpath("//p[text() ='"+flexCardsName.get(i)+"']")).getText();
            assertEquals(listOfFlexCards.get(i).findElement(By.xpath("//p[text() ='"+flexCardsName.get(i)+"']")).getText(), flexCardsName.get(i));
        }


        return this;
    }

    public PageBase Click_SignUp_Now_Button() {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.elementToBeClickable(SignUpBtn));
        getButtonHelper().click(SignUpBtn);
        OffCanvas offCanvas = new OffCanvas(driver);
        return offCanvas;
    }




}
