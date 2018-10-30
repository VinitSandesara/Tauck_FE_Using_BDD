package com.tauck.runner.MyAccount_Guest;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/com/tauck/Feature"},
        glue = {"com.tauck"},
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","junit:target/junitReport/junitreport.xml"},
        tags = {"@Valid_Login,@Agent_Reward"}

)
public class Test_Runner extends AbstractTestNGCucumberTests {
}
