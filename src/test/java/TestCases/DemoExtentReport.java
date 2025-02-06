package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoExtentReport {
    ExtentReports extent;

    @BeforeTest
    public void config(){
        extent=new ExtentReports();
        String filepath=System.getProperty("user.dir")+"//reports//"+"index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(filepath);
        reporter.config().setReportName("Order Error Validation");
        reporter.config().setDocumentTitle("Order Summary Report");
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Amna");

    }

    @Test
    public void initialDemo(){
        ExtentTest test=extent.createTest("Inital Demo");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        driver.close();
        test.fail("Result do not match");
        extent.flush();

    }
}
