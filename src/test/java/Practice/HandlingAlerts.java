package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Practice.Day1.WebdriverManager;


public class HandlingAlerts {
    public static void main(String[] args) {
        WebDriver driver=new WebdriverManager().getDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice");
        driver.manage().window().maximize();
        driver.findElement(By.id("name")).sendKeys("Test 123");
        driver.findElement(By.cssSelector("#alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }
}
