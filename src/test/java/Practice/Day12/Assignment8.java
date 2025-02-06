package Practice.Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment8 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys("uni");
        Thread.sleep(3000);
        List<WebElement> values =driver.findElements(By.cssSelector("ul[class*='ui-autocomplete'] li"));
        for(int i=0;i<values.size();i++){
            String text=values.get(i).getText();
            if(text.contains("United States")){
                WebElement value=values.get(i);
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",value);
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();",value);
                break;

            }

        }

    }
}
