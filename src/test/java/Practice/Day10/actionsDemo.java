package Practice.Day10;
import Practice.Day1.WebdriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {
    public static void main(String[] args) {
        WebDriver driver= new WebdriverManager().getDriver();
       // driver.get("https://www.amazon.com/");
        driver.get("https://www.cypress-outdoorliving.com/");
        driver.manage().window().maximize();
        Actions a=new Actions(driver);
        WebElement move=driver.findElement(By.cssSelector(".nav-item.dropdown"));
        a.moveToElement(move).build().perform();
        driver.navigate().to("https://www.daraz.pk/");
        a.moveToElement(driver.findElement(By.cssSelector("input[type='search']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        a.moveToElement(driver.findElement(By.cssSelector(".cart-icon-daraz"))).contextClick().build().perform();
        //a.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).build().perform();


    }
}
