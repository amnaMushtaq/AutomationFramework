package Practice.Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        //1. Select checkbox
        driver.findElement(By.cssSelector("#checkBoxOption2")).click();
        String checkboxText = driver.findElement(By.cssSelector("label[for='benz']")).getText().trim();
        WebElement staticDropDown = driver.findElement(By.id("dropdown-class-example"));
        Select options = new Select(staticDropDown);
        options.selectByVisibleText(checkboxText);
        driver.findElement(By.cssSelector("input[id='name']")).sendKeys(checkboxText);
        driver.findElement(By.id("alertbtn")).click();
       // System.out.println(driver.switchTo().alert().getText().split(",")[0].split(" ")[1].trim());
        String alertText=driver.switchTo().alert().getText();
        if(alertText.contains(checkboxText)){
            System.out.println("The checkbox text is present in alert text");

        }
        driver.switchTo().alert().accept();

    }
}