package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {

    private static ExtentReports extentReports;

    public static ExtentReports createInstance() {
        if (extentReports == null) {
            // Define the location where you want the HTML report to be saved
            String reportPath = System.getProperty("user.dir") + "/target/ExtentReports/ExtentReport.html";

            // Create an ExtentHtmlReporter
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);

            // Create ExtentReports object and attach the reporter
            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);
        }
        return extentReports;
    }
}
