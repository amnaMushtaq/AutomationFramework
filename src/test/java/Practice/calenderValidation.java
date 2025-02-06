package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Practice.Day1.WebdriverManager;


public class calenderValidation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebdriverManager.getDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        System.out.println(driver.findElement(By.cssSelector(".picker-second")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.cssSelector(".picker-second")).getAttribute("style"));
        String opacity=driver.findElement(By.cssSelector(".picker-second")).getAttribute("style");
        if(opacity.contains("1")){
            System.out.println("Calender is enabled");
            Assert.assertTrue(true);
        }
        else
            Assert.assertTrue(false);
            //System.out.println("calender is disabled");
        driver.close();



    }

}
