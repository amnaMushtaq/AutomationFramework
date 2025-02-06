package Practice.Day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


@Test
public class RelativeLoc {
    public void relativeLoc() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox=driver.findElement(By.cssSelector("input[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
        WebElement dateofbirth=driver.findElement(By.cssSelector("label[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateofbirth)).click();
        WebElement checkboxText=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(checkboxText)).click();
        WebElement radiobtn=driver.findElement(By.id("inlineRadio1"));
       System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radiobtn)).getText());






    }

}
