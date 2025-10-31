package api.tests;

import api.config.ConfigManager;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite
    public void setUp() {
        RestAssured.baseURI = ConfigManager.getBaseUrl();
    }
}
