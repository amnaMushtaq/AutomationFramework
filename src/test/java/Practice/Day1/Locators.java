package Practice.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

        //chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String password=getPassword(driver);

        //driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("amna");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
        driver.findElement(By.xpath("//*[contains(@class,'signInBtn')]")).click();
        Thread.sleep(1000);
        String welcomeText=driver.findElement(By.tagName("p")).getText();
        System.out.println(welcomeText);
        Assert.assertEquals(welcomeText,"You are successfully logged in.");
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        driver.close();

    }
    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("reset-pwd-btn")).click();

        String passwordText=driver.findElement(By.className("infoMsg")).getText();
        //Please use temporary password 'rahulshettyacademy' to Login.
        String[] passwordArray=passwordText.split("'");
        // rahulshettyacademy' to Login.
        String[] passwordArray2=passwordArray[1].split("'");
        String password=passwordArray2[0];
        System.out.println(password);
        driver.findElement(By.className("go-to-login-btn")).click();
        return password;

    }
}
