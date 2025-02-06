package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Practice.Day1.WebdriverManager;


public class checkBoxHandling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebdriverManager.getDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        Assert.assertFalse(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
        //System.out.println(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
        driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).click();
        //System.out.println(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
       // System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());

    }

}
