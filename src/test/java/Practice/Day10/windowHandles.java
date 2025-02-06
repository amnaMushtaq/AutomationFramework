package Practice.Day10;

import Practice.Day1.WebdriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class windowHandles {
    public static void main(String[] args) {
        WebDriver driver=new WebdriverManager().getDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows=driver.getWindowHandles(); // [parentId, subchildid]
        Iterator<String> it=windows.iterator();
        String parentId=it.next();
        String childId=it.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String emailAddress=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        System.out.println(emailAddress);
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailAddress);
    }
}
