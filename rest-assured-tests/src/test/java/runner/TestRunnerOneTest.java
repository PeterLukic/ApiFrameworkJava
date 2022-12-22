package runner;

import io.cucumber.testng.*;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRunnerOneTest {

    @CucumberOptions(features = {"src/test/java/features/"},
            glue = {"steps"},
            plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
            tags = "@OneTest")

    public static class Runner extends AbstractTestNGCucumberTests {


    }
}
