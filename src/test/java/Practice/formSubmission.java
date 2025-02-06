package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import Practice.Day1.WebdriverManager;


public class formSubmission {
    public static void main(String[] args) {
        WebDriver driver= new WebdriverManager().getDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(" .form-group input[name='name']")).sendKeys("test");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("test@g.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("test123");
        driver.findElement(By.className("form-check-input")).click();
        WebElement dropdown=driver.findElement(By.cssSelector("#exampleFormControlSelect1"));
        Select option= new Select(dropdown);
        option.selectByVisibleText("Female");
        driver.findElement(By.cssSelector("input[value='option2']")).click();
        driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("02/25/1990");
        driver.findElement(By.cssSelector(".btn.btn-success")).click();
        System.out.println(driver.findElement(By.cssSelector("div.alert")).getText());
    }
}
