package Practice.Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeExercsie {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footerDriver=driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());




    }
}
