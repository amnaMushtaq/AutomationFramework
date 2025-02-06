package Practice.Day13;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class SSLcheck {
    public static void main(String[] args) throws IOException {
        ChromeOptions option=new ChromeOptions();
        option.setAcceptInsecureCerts(true);
        WebDriver driver=new ChromeDriver(option);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String projectPath=System.getProperty("user.dir");
        File destination=new File(projectPath + "/src/resources/screenshot/screenshot.png");
  //      FileUtils.copyFile(src, destination);

       // FileUtils.copyFile(src,new File("C:\\Users\\mushtamn\\screenshot.png"));
    }
}
