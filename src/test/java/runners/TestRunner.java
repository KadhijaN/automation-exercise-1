package runners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.*;
import org.junit.runner.RunWith;
import utils.ExtentReportManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class TestRunner {

        private static ExtentReports extentReports = ExtentReportManager.createInstance();

        @BeforeClass
        public static void beforeClass() {
                // You can perform setup before the tests start
                System.out.println("Test execution starting...");
        }

        @AfterClass
        public static void afterClass() {
                // Flush the reports after test execution
                extentReports.flush();
        }
}
