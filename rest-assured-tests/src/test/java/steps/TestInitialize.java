package steps;

import config.ConfigReader;
import config.Settings;
import io.cucumber.java.Before;
import utilities.RestAssuredExtension;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class TestInitialize {

    @Before
    public void TestSetup(Scenario scenario) throws IOException {

        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
        ConfigReader.PopulateSettings();
    }
}
