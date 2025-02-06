package Practice.OverallPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class practice2 {
    @Test
    public void hover(){
        WebDriver driver=new ChromeDriver();
//        driver.get("https://www.cypress-outdoorliving.com/");
        //driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        //Actions a=new Actions(driver);
//        a.moveToElement(driver.findElement(By.cssSelector(".nav-item.dropdown"))).build().perform();
   //     driver.findElement(By.cssSelector("a[href*='liferoom-screens']")).click();
        //WebElement searchButton =driver.findElement(By.cssSelector("[type='search']"));
      //  a.moveToElement(searchButton).click().keyDown(Keys.SHIFT).sendKeys("rice").keyUp(Keys.SHIFT).build().perform();
       // a.keyDown(Keys.SHIFT).sendKeys("rice").keyUp(Keys.SHIFT).keyDown(Keys.ENTER).build().perform();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> window=driver.getWindowHandles();
        Iterator<String> iterator = window.iterator();
        String parentWindow = iterator.next();
        String childWindow=iterator.next();
        driver.switchTo().window(childWindow);
        String emailAddress=driver.findElement(By.cssSelector(".im-para.red")).getText().split("with")[0].trim().split("at")[1].trim();
        driver.switchTo().window(parentWindow);
        driver.findElement(By.id("username")).sendKeys(emailAddress);
        driver.switchTo().frame("locator");
        Actions a=new Actions(driver);
        driver.switchTo().defaultContent();



    }
}
