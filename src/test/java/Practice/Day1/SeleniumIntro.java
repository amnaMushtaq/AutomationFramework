package Practice.Day1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntro {
    public static void main(String [] args){

        //chrome driver
        System.setProperty("webdriver.chrome.driver","C:/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //firefox driver
//        System.setProperty("webdriver.gecko.driver","C:/drivers/geckodriver.exe");
//        WebDriver driver=new FirefoxDriver();

        //edge driver
//        System.setProperty("webdriver.edge.driver","C:/drivers/msedgedriver.exe");
//        WebDriver driver=new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("amna");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacade");
        //driver.findElement(By.className("signInBtn")).click();
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("test");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("test@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("1234567890");
        driver.findElement(By.className("reset-pwd-btn")).click();
        driver.findElement(By.className("infoMsg")).getText();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }
}
