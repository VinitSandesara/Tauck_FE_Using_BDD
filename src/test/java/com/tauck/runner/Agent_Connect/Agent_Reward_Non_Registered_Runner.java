package com.tauck.runner.Agent_Connect;


import com.tauck.customrunner.CustomAbstractTestNGCucumberTestsWithTag;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

// tags works in the alphabetically order, what i means is If there are 2 feature file says a.feature and login.feature and you want to
// execute tag defined in login.feature 1st and the tag defined in a.feature it will not work in that way, it will first execute tag
// defined in a.feature and then login.feature.


@CucumberOptions(
       // features = {"src/test/java/com/tauck/LoginScenario/Login.feature", "src/test/java/com/tauck/Feature/Agent_Reward_Non_Registered.feature"},
        features = {"src/test/java/com/tauck/Feature"},
        glue = {"com.tauck"},
        dryRun = false,
        monochrome = false,
        plugin = {"pretty","junit:target/junitReport/junitreport.xml"},
       // name = {"Agent_Reward_Non_Registered_User"}
        tags = {"@Sign_Up_Non_Registered_Agent_Reward"}


)
public class Agent_Reward_Non_Registered_Runner extends CustomAbstractTestNGCucumberTestsWithTag {
}
