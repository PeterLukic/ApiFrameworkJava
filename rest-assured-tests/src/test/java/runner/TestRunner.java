package runner;

import io.cucumber.testng.*;



public class TestRunner {

    @CucumberOptions(features = {"src/test/java/features/"},
            glue = {"steps"},
            plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

    public static class Runner extends AbstractTestNGCucumberTests {

    }
}
