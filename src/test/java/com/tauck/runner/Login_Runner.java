package com.tauck.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/com/tauck/Feature/Login.feature"},
        glue = {"com.tauck"},
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","junit:target/junitReport/junitreport.xml"}
)
public class Login_Runner extends AbstractTestNGCucumberTests {
}
