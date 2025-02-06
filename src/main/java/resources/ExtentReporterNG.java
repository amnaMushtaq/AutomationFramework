package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReporterNG {
    public static ExtentReports config() {
        ExtentReports extent = new ExtentReports();
        String filepath = System.getProperty("user.dir") + "//reports//" + "index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(filepath);
        reporter.config().setReportName("Framework Extent Report");
        reporter.config().setDocumentTitle("Test Results");
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Amna");
        //extent.createTest(filepath);
        return extent;

    }

}
